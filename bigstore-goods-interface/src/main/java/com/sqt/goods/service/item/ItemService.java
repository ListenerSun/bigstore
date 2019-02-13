package com.sqt.goods.service.item;

import com.sqt.entity.Result;
import java.util.Map;

/**
 * @Description: 商品详细信息
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-04  16:26
 */
public interface ItemService {

    /**
     * 商品信息导入到solr
     * @return
     * @throws Exception
     */
     Result importItemList() throws Exception;

    /**
     * 查询
     * @param searchMap
     * @throws Exception
     */
     Map solrSearch(Map searchMap) throws Exception;


}
