package com.sqt.goods.service.imp.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.service.item.ItemService;
import com.sqt.pojo.TbBrand;
import com.sqt.pojo.TbItem;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  10:09
 */

@Service
@Component
public class ItemServiceImp implements ItemService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public TbItem findById(Long id) throws Exception {
        return (TbItem) dao.findForObject("ItemMapper.findById",id);
    }

    @Override
    public List<TbItem> findAll() throws Exception {
        return (List<TbItem>) dao.findForList("ItemMapper.findAll",null);
    }

    @Override
    public PageData findPageData(int pageNum, int pageSize, TbItem item) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbBrand>)dao.findForList("ItemMapper.findAll", null);
        Page<TbBrand> page = (Page<TbBrand>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public PageData findPageData(int pageNum, int pageSize) throws Exception {
        return null;
    }

    @Override
    public Object add(TbItem item) throws Exception {
        return null;
    }

    @Override
    public Object edit(TbItem item) throws Exception {
        return null;
    }

    @Override
    public Object delete(Long[] ids) throws Exception {
        return null;
    }
}
