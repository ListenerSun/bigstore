package com.sqt.goods.service.seller;

import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.pojo.TbSeller;
import java.util.List;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  15:54
 */
public interface SellerService {

    /**
     * 添加商家
     * @return
     * @throws Exception
     */
    Object add(TbSeller seller)throws Exception;

    /**
     * 根据条件查询商家列表 分页
     * @param seller
     * @return
     * @throws Exception
     */
    PageData query(TbSeller seller,int pageNum,int pageSize) throws Exception;

    /**
     * 查询一个商家
     * @param seller
     * @return
     * @throws Exception
     */
    TbSeller findOne(TbSeller seller) throws Exception;

    /**
     * 查询一个商家
     * @param id
     * @return
     * @throws Exception
     */
    TbSeller findOneById(Long id) throws Exception;

    /**
     * 根据帐号查询
     * @param seller_id
     * @return
     * @throws Exception
     */
    TbSeller findByName(String seller_id) throws Exception;

    /**
     * 查询商家列表
     * @param
     * @return
     * @throws Exception
     */
    PageData finaAll(int pageNum,int pageSize) throws Exception;

    Object upStatus(Long id,String status) throws Exception;
}
