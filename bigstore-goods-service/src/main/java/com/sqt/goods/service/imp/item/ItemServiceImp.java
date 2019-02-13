package com.sqt.goods.service.imp.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.sqt.entity.Result;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.entity.TbItem;
import com.sqt.goods.service.item.ItemService;
import com.sqt.goods.system.SystemCon;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Component;

/**
 * @Description:商品全信息服务层
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-10  23:54
 */
@Component
@Service
public class ItemServiceImp implements ItemService {

    @Resource
    private SolrTemplate solrTemplate;
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public Result importItemList() throws Exception {
        List<TbItem> list = (List<TbItem>) dao.findForList("ItemMapper.findAll", null);
        for (TbItem item : list) {
            item.setSpecMap(JSON.parseObject(item.getSpec(),Map.class));
        }
        solrTemplate.saveBeans("bigstore",list);
        solrTemplate.commit("bigstore");
        return new Result(200,"import is ok!");
    }

    @Override
    public Map solrSearch(Map searchMap) throws Exception {
        Map<String,Object> map = new HashMap();
        HighlightQuery query=new SimpleHighlightQuery();
        HighlightOptions highlightOptions=new HighlightOptions().addField("item_title");//设置高亮的域
        highlightOptions.setSimplePrefix("<em style='color:red'>");//高亮前缀
        highlightOptions.setSimplePostfix("</em>");//高亮后缀
        query.setHighlightOptions(highlightOptions);//设置高亮选项
        //按照关键字查询
        Criteria criteria=new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(SystemCon.solr_core_name,query, TbItem.class);
        for(HighlightEntry<TbItem> h: page.getHighlighted()){    //循环高亮入口集合
            TbItem item = h.getEntity();//获取原实体类
            if(h.getHighlights().size()>0 && h.getHighlights().get(0).getSnipplets().size()>0){
                item.setTitle(h.getHighlights().get(0).getSnipplets().get(0));//设置高亮的结果
            }
        }
        map.put("rows",page.getContent());
        return map;
    }
}
