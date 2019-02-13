package com.sqt.goods.service.imp.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.pojo.TbItem;
import com.sqt.goods.service.item.ItemCatService;
import com.sqt.goods.pojo.TbItemCat;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-19  11:28
 */
@Service
@Component
public class ItemCatServiceImp  implements ItemCatService{

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public TbItemCat findById(Long id) throws Exception {
        return (TbItemCat) dao.findForObject("ItemCatMapper.findById",id);
    }

    @Override
    public List<TbItemCat> findAll() throws Exception {
        return (List<TbItemCat>) dao.findForList("ItemCatMapper.findAll",null);
    }

    @Override
    public PageData findPageData(int pageNum, int pageSize, TbItem item) throws Exception {
        return null;
    }

    @Override
    public PageData findPageData(int pageNum, int pageSize) throws Exception {
        return null;
    }

    @Override
    public Object add(TbItemCat itemCat) throws Exception {
        return dao.save("ItemCatMapper.add",itemCat);
    }

    @Override
    public Object edit(TbItemCat itemCat) throws Exception {
        return dao.update("ItemCatMapper.update",itemCat);
    }

    @Override
    public Object delete(Long[] ids) throws Exception {
        return null;
    }

    @Override
    public List<TbItemCat> findByParentId(Long id) throws Exception {
        return (List<TbItemCat>) dao.findForList("ItemCatMapper.findByParentId",id);
    }
}
