package com.sqt.goods.service.item;

import com.sqt.entity.PageData;
import com.sqt.pojo.TbItem;
import java.util.List;
import java.util.Map;

/**
 * 商品服务类
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  10:00
 */
public interface ItemService {

    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    TbItem findById(Long id) throws Exception;

    /**
     * 查询所有商品列表
     * @return
     */
    List<TbItem> findAll() throws Exception;

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
     * 新增商品
     * @return
     */
    Object add(TbItem item) throws Exception;

    /**
     * 编辑商品
     * @param item
     * @return
     * @throws Exception
     */
    Object edit(TbItem item) throws Exception;

    /**
     * 删除商品
     * @param ids
     * @return
     * @throws Exception
     */
    Object delete(Long[] ids) throws Exception;



}
