package com.sqt.item;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.Result;
import com.sqt.entity.SearchParam;
import com.sqt.goods.service.item.ItemService;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-29  17:34
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Reference
    private ItemService itemService;

    /**
     * 查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    public Object solrSerach(/* @RequestBody SearchParam searchMap*/){
        Map result;
        try {
            result = itemService.solrSearch(null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"Server exception!");
        }
        return result;
    }

    @RequestMapping("/hello")
    public Object hello(@RequestBody Map map){
        return map;
    }
}
