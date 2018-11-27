package com.sqt.goods.service.item;

import com.sqt.entity.PageData;
import com.sqt.group.Goods;
import com.sqt.pojo.TbGoods;
import com.sqt.pojo.TbItem;
import java.util.List;
import java.util.Map;

/**
 * 商品服务类
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  10:00
 */
public interface GoodService {

    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    TbGoods findById(Long id) throws Exception;

    /**
     * 查询所有商品列表
     * @return
     */
    List<TbGoods> findAll() throws Exception;

    /**
     * 查询分页结果
     * @return
     */
    PageData findPageData(int pageNum,int pageSize,TbGoods good) throws Exception;
    /**
     * 查询分页结果
     * @return
     */
    PageData findPageData(int pageNum,int pageSize) throws Exception;

    /**
     * 新增商品
     * @return
     */
    Object add(Goods good) throws Exception;

    /**
     * 编辑商品
     * @param good
     * @return
     * @throws Exception
     */
    Object edit(TbGoods good) throws Exception;

    /**
     * 删除商品
     * @param ids
     * @return
     * @throws Exception
     */
    Object delete(Long[] ids) throws Exception;



}
