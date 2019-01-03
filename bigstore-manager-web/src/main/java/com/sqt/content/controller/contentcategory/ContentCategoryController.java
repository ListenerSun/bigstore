package com.sqt.content.controller.contentcategory;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.content.ContentCategoryService;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.pojo.TbContentCategory;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 广告分类应用层接口
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-12-27  20:02
 */
@RestController
@RequestMapping("/contentcategory")
public class ContentCategoryController {

    @Reference
    private ContentCategoryService contentCategoryService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findPageData")
    public PageData findAll(int pageNum,int pageSize,@RequestBody TbContentCategory contentCategory){
        PageData page = null;
        try {
            page = contentCategoryService.findPage(contentCategory,pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * 查询所有列表
     * @param
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbContentCategory> findAll(){
        List<TbContentCategory> contentCategoryList = null;
        try {
            contentCategoryList = contentCategoryService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  contentCategoryList;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    public TbContentCategory findById(@PathVariable("id") Long id){
        TbContentCategory contentCategory = null;
        try {
            contentCategory = contentCategoryService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentCategory;
    }
    /**
     * 增加
     * @param tbContentCategory
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbContentCategory tbContentCategory){
        try {
            contentCategoryService.add(tbContentCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"添加失败");
        }
        return  new Result(200,"添加成功");
    }

    /**
     * 修改
     * @param tbContentCategory
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody TbContentCategory tbContentCategory){
        try {
            contentCategoryService.update(tbContentCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"修改失败");
        }
        return  new Result(200,"修改成功");
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            contentCategoryService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"删除失败");
        }
        return  new Result(200,"删除成功");
    }

}
