package com.sqt.goods.service.brand;

import com.sqt.entity.PageData;
import com.sqt.pojo.TbBrand;
import java.util.List;
import java.util.Map;

/**
 * @Description: 商品品牌服务
 * @author: sqt
 * @Date: Created in 2018-10-31  11:07
 */
public interface BrandService {

    /**
     * 根据id查询商品品牌
     * @param id
     * @return
     * @throws Exception
     */
    TbBrand findById(Long id) throws Exception;

    /**
     * 查询所有商品品牌列表
     * @return
     */
    List<TbBrand> findAll() throws Exception;

    /**
     * 查询分页结果
     * @return
     */
    PageData findPageData(int pageNum,int pageSize,TbBrand brand) throws Exception;
    /**
     * 查询分页结果
     * @return
     */
    PageData findPageData(int pageNum,int pageSize) throws Exception;

    /**
     * 新增商品品牌
     * @return
     */
    Object add(TbBrand brand) throws Exception;

    /**
     * 编辑商品
     * @param brand
     * @return
     * @throws Exception
     */
    Object edit(TbBrand brand) throws Exception;

    /**
     * 删除商品品牌
     * @param ids
     * @return
     * @throws Exception
     */
    Object delete(Long[] ids) throws Exception;

    /**
     * 查询需要字段的品牌列表     * @return
     */
    List<Map> findBrandList() throws Exception;


    String test();

}
