package com.sqt.goods.service.item;

import com.sqt.entity.PageData;
import com.sqt.pojo.TbItem;
import com.sqt.pojo.TbItemCat;
import java.util.List;

/**
 * @Description: 商品分类服务类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-19  11:22
 */
public interface ItemCatService {
    /**
     * 根据id查询商品分类
     * @param id
     * @return
     * @throws Exception
     */
    TbItemCat findById(Long id) throws Exception;

    /**
     * 查询所有商品分类列表
     * @return
     */
    List<TbItemCat> findAll() throws Exception;

    /**
     * 查询分页结果
     * @return
     */
    PageData findPageData(int pageNum,int pageSize,TbItem item) throws Exception;
    /**
     * 查询分页结果
     * @return
     */
    PageData findPageData(int pageNum,int pageSize) throws Exception;

    /**
     * 新增商品分类
     * @return
     */
    Object add(TbItemCat itemCat) throws Exception;

    /**
     * 编辑商品分类
     * @param itemCat
     * @return
     * @throws Exception
     */
    Object edit(TbItemCat itemCat) throws Exception;

    /**
     * 删除商品分类
     * @param ids
     * @return
     * @throws Exception
     */
    Object delete(Long[] ids) throws Exception;

    /**
     * 根据父类id查询商品分类
     * @param id
     * @return
     */
    List<TbItemCat> findByParentId(Long id) throws Exception;

}
