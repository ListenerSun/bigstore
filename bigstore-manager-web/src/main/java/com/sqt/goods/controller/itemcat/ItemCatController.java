package com.sqt.goods.controller.itemcat;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.Result;
import com.sqt.goods.service.item.ItemCatService;
import com.sqt.pojo.TbItemCat;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-19  16:26
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long id){
        List<TbItemCat> itemCatList = null;
        try {
            itemCatList = itemCatService.findByParentId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemCatList;
    }

    @RequestMapping("/searchOne")
    public TbItemCat searchOne(Long id)  {
        TbItemCat itemCat = null;
        try {
            itemCat = itemCatService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemCat;
    }

    @RequestMapping("/add")
    public Result add(@RequestBody  TbItemCat itemCat){
        try {
            itemCatService.add(itemCat);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(404,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    @RequestMapping("/updata")
    public Result updata(@RequestBody TbItemCat itemCat){
        try {
            itemCatService.edit(itemCat);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(404,"修改失败");
        }
        return new Result(200,"修改成功");
    }

    @RequestMapping("/findItemCatList")
    public List<TbItemCat> findItemCatList(){
        List<TbItemCat> itemCatList = null;
        try {
            itemCatList =  itemCatService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemCatList;
    }
}
