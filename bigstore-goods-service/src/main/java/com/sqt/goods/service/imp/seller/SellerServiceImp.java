package com.sqt.goods.service.imp.seller;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.service.seller.SellerService;
import com.sqt.pojo.TbSeller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  15:56
 */
@Service
@Component
public class SellerServiceImp implements SellerService {
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public Object add(TbSeller seller) throws Exception {
        seller.setStatus("1");
        return dao.save("SellerMapper.add",seller);
    }

    @Override
    public PageData query(TbSeller seller,int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TbSeller> list = (List<TbSeller>) dao.findForList("SellerMapper.query", seller);
        Page<TbSeller> page = (Page<TbSeller>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public TbSeller findOne(TbSeller seller) throws Exception {
        return null;
    }

    @Override
    public TbSeller findOneById(Long id) throws Exception {
        return (TbSeller) dao.findForObject("SellerMapper.findOneById",id);
    }

    @Override
    public TbSeller findByName(String seller_id) throws Exception {
        return (TbSeller) dao.findForObject("SellerMapper.findByName",seller_id);
    }

    @Override
    public PageData finaAll(int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TbSeller> list = (List<TbSeller>) dao.findForList("SellerMapper.findAll", null);
        Page<TbSeller> page = (Page<TbSeller>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public Object upStatus(Long id, String status) throws Exception {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",id);
        param.put("status",status);
        return dao.update("SellerMapper.upStatus",param);
    }
}
