package com.sqt.goods.controller.item;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.goods.service.item.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 商品全信息应用层
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-10  23:48
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Reference
    private ItemService itemService;

    @RequestMapping("/import")
    public Result importItem(){
        Result result = null;
        try {
            result = itemService.importItemList();
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg("导入失败");
            e.printStackTrace();
        }
        return result;
    }
}
