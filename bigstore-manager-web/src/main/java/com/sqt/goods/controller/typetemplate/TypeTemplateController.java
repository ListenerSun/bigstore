package com.sqt.goods.controller.typetemplate;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.goods.service.typetemplate.TypeTemplateService;
import com.sqt.goods.pojo.TbTypeTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-10  15:53
 */
@RestController
@RequestMapping("/type_template")
public class TypeTemplateController {

    @Reference()
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/findPageData")
    public PageData findPage(int pageSize,int pageNum){
        PageData pageData = null;
        try {
            pageData = typeTemplateService.findPage(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageData;
    }
    /**
     * 添加
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            typeTemplateService.add(tbTypeTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"新增失败");
        }
        return new Result(200,"新增成功");
    }

    /**
     *查询一个规格列表
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    public TbTypeTemplate findOne(@PathVariable(value = "id") Long id){
        TbTypeTemplate tbTypeTemplate = null;
        try {
            tbTypeTemplate = typeTemplateService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbTypeTemplate;
    }

    /**
     *更新
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            typeTemplateService.update(tbTypeTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"更新失败");
        }
        return new Result(200,"更新成功");
    }

    /**
     * 删除商品品牌
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Result delete(Long[] ids){
        try {
            typeTemplateService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"删除失败");
        }
        return new Result(200,"删除成功");
    }
}
