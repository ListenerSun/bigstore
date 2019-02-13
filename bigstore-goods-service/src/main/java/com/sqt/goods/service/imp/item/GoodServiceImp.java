package com.sqt.goods.service.imp.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.pojo.TbItem;
import com.sqt.goods.service.item.GoodService;
import com.sqt.group.Goods;
import com.sqt.goods.pojo.TbBrand;
import com.sqt.goods.pojo.TbGoods;
import com.sqt.goods.pojo.TbGoodsDesc;
import com.sqt.goods.pojo.TbItemCat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**商品服务类实现类
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  10:09
 */

@Service
@Component
public class GoodServiceImp implements GoodService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public Goods findById(Long id) throws Exception {
        Goods goods = new Goods();
        TbGoods good = (TbGoods) dao.findForObject("GoodMapper.findById",id);
        TbGoodsDesc goodsDesc = (TbGoodsDesc)dao.findForObject("GoodsDescMapper.findById",id);
        List<TbItem> itemList = (List<TbItem>) dao.findForList("ItemMapper.findByGoodsId",id);
        goods.setGoods(good);
        goods.setGoodsDesc(goodsDesc);
        goods.setItemList(itemList);
        return goods;
    }

    @Override
    public List<TbGoods> findAll() throws Exception {
        return null;
    }

    @Override
    public PageData findPageData(int pageNum, int pageSize, TbGoods good) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TbGoods> list = (List<TbGoods>) dao.findForList("GoodMapper.findAll",good);
        Page<TbGoods> page = (Page<TbGoods>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public PageData findPageData(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TbGoods> list = (List<TbGoods>) dao.findForList("GoodMapper.findAll",null);
        Page<TbGoods> page = (Page<TbGoods>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public Object add(Goods good) throws Exception {
        TbGoods goods = good.getGoods();
        goods.setAuditStatus("0");//设置状态未审核
        dao.save("GoodMapper.add",goods);
       //增加商品全信息
        List<TbItem> itemList = good.getItemList();//{spec:{},price:0,num:9999,status:'0',isDefault:'0'}
        for (TbItem item : itemList) {
            Map<String,String> map = JSON.parseObject(item.getSpec(), Map.class);
            String title = goods.getGoodsName();
            for (String key : map.keySet()) {
                title += map.get(key);
            }
            item.setTitle(title);
            item.setPrice(goods.getPrice().toString());
            // 保存三级分类的ID:
            item.setCategoryid(goods.getCategory3Id());
            item.setCreateTime(new Date());
            item.setUpdateTime(new Date());
            // 设置商品ID
            item.setGoodsId(goods.getId());
            item.setSellerId(goods.getSellerId());//登入账号就是商家信息可以获取id
            //设置分类
            TbItemCat itemCat = (TbItemCat) dao.findForObject("ItemCatMapper.findById", goods.getCategory3Id());
            item.setCategory(itemCat.getName());
            //设置品牌
            TbBrand brand = (TbBrand)dao.findForObject("BrandMapper.findById",goods.getBrandId());
            item.setBrand(brand.getName());
            //设置商家名称 根据商家id查询，商家id冲登入者获取
            dao.save("ItemMapper.add",item);
        }
        //添加商品描述
        TbGoodsDesc goodsDesc = good.getGoodsDesc();
        goodsDesc.setGoodsId(goods.getId());
        dao.save("GoodsDescMapper.add",goodsDesc);
        return null;
    }

    @Override
    public Object edit(TbGoods good) throws Exception {
        return null;
    }

    @Override
    public Object delete(Long[] ids) throws Exception {
        return null;
    }
}
