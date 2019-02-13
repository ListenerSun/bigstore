package com.sqt.goods.service.imp.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.service.brand.BrandService;
import com.sqt.goods.pojo.TbBrand;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: sqt 微信(810548252) 未婚
 * @Date: Created in 2018-10-31  22:14
 */
@Service()//version = "1.0.0"
@Component
public class BrandServiceImp implements BrandService {
    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public TbBrand findById(Long id) throws Exception {
        return (TbBrand) dao.findForObject("BrandMapper.findById",id);
    }

    @Override
    public List<TbBrand> findAll() throws Exception {
        return (List<TbBrand>) dao.findForList("BrandMapper.findAll",null);
    }

    /**
     * 分页查询 有条件
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageData findPageData(int pageNum,int pageSize,TbBrand brand) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbBrand>)dao.findForList("BrandMapper.findAll", brand);
        Page<TbBrand> page = (Page<TbBrand>) list;
        return new PageData(page.getResult(),page.getTotal());
    }
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageData findPageData(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbBrand>)dao.findForList("BrandMapper.findAll", null);
        Page<TbBrand> page = (Page<TbBrand>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    /**
     * 新增商品品牌
     * @param brand
     * @return
     */
    @Override
    public Object add(TbBrand brand) throws Exception {
        return dao.save("BrandMapper.add",brand);
    }

    /**
     * 编辑商品品牌
     * @param brand
     * @return
     * @throws Exception
     */
    @Override
    public Object edit(TbBrand brand) throws Exception {
        return dao.update("BrandMapper.edit",brand);
    }

    /**
     * 删除商品品牌
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public Object delete(Long[] ids) throws Exception {
        for (Long id : ids) {
            dao.delete("BrandMapper.delete",id);
        }
        return null;
    }

    @Override
    public List<Map> findBrandList() throws Exception {
        return (List<Map>) dao.findForList("BrandMapper.findBrandList",null);
    }

    @Override
    public String test() {
        return "biubiu！";
    }
}
