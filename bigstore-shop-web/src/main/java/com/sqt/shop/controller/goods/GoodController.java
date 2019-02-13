package com.sqt.shop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.goods.service.item.GoodService;
import com.sqt.group.Goods;
import com.sqt.goods.pojo.TbGoods;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-18  22:18
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    @Reference
    private GoodService goodService;

    /**
     * 增加商品
     * @param good
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Goods good){
        try {
            goodService.add(good);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    /**
     * 查询商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findGoodList")
    public PageData findGoodList(int pageNum,int pageSize){
        PageData pageData = null;
        try {
           pageData = goodService.findPageData(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageData;
    }

    /**
     * 根据条件查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    public PageData search(int pageNum,int pageSize,@RequestBody TbGoods good){
        PageData data = null;
        try {
             data = goodService.findPageData(pageNum, pageSize,good);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 根据id 查询实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Goods findOne(Long id){
        Goods goods = null;
        try {
            goods = goodService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }
}
