package com.sqt.content.service.imp.contentcategory;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.content.ContentCategoryService;
import com.sqt.content.dao.DaoSupport;
import com.sqt.entity.PageData;
import com.sqt.pojo.TbContentCategory;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description: 广告分类服务实现类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-12-26  17:12
 */
@Service
@Component
public class ContentCategoryServiceImp implements ContentCategoryService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public List<TbContentCategory> findAll() throws Exception {
        List list = (List<TbContentCategory>)dao.findForList("ContentCategoryMapper.findAll", null);
        return list;
    }

    @Override
    public PageData findPage(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbContentCategory>)dao.findForList("ContentCategoryMapper.findAll", null);
        Page<TbContentCategory> page = (Page<TbContentCategory>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public void add(TbContentCategory contentCategory) throws Exception {
        dao.save("ContentCategoryMapper.add",contentCategory);
    }

    @Override
    public void update(TbContentCategory contentCategory) throws Exception {
        dao.update("ContentCategoryMapper.edit",contentCategory);
    }

    @Override
    public TbContentCategory findOne(Long id) throws Exception {
        TbContentCategory contentCategory = (TbContentCategory) dao.findForObject("ContentCategoryMapper.findById", id);
        return contentCategory;
    }

    @Override
    public void delete(Long[] ids) throws Exception {
        for (Long id : ids) {
          dao.delete("ContentCategoryMapper.delete",id);
        }
    }

    @Override
    public PageData findPage(TbContentCategory contentCategory, int pageNum, int pageSize)
        throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        System.out.println(contentCategory);
        List<TbContentCategory> list = (List<TbContentCategory>)dao.findForList("ContentCategoryMapper.findAll", contentCategory);
        Page<TbContentCategory> page = (Page<TbContentCategory>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public Object test() {
        List<Map<String, Object>> dataSourceStatDataList = DruidStatManagerFacade.getInstance()
            .getDataSourceStatDataList();
        return dataSourceStatDataList;
    }
}
