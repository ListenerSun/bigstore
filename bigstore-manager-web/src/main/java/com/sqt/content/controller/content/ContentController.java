package com.sqt.content.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.content.ContentService;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.pojo.TbContent;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 广告内容应用层接口
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-12-27  19:56
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    public TbContent findById( @PathVariable("id") Long id){
        TbContent content = null;
        try {
            content = contentService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findPage")
    public PageData findPage(Integer pageNum,Integer pageSize){
        PageData page = null;
        try {
            page = contentService.findPage(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    /**
     * 增加
     * @param content
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbContent content){
        try {
            contentService.add(content);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"添加失败");
        }
        return new Result(200,"添加成功");
    }
    /**
     * 更新
     * @param content
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody TbContent content){
        try {
            contentService.update(content);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"更新失败");
        }
        return new Result(200,"更新成功");
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            contentService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"删除失败");
        }
        return new Result(200,"删除成功");
    }

    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbContent> findAll(){
        List<TbContent> contentList = null;
        try {
            contentList = contentService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentList;
    }
}
