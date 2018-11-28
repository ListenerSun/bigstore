package com.sqt.goods.controller.specification;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.goods.service.specification.SpecificationService;
import com.sqt.group.Specification;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 商品规格控制层
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-07  11:00
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference()
    private SpecificationService specificationService;

    /**
     * 查询分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findPageData")
    public PageData findPage(int pageNum,int pageSize){
        PageData pageData = null;
        try {
            pageData = specificationService.findPage(pageNum, pageSize);
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
    public Result add(@RequestBody Specification specification){
        try {
            specificationService.add(specification);
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
    public Specification findOne(@PathVariable(value = "id") Long id){
        Specification specification = null;
        try {
            specification = specificationService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specification;
    }

    /**
     *更新
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody Specification specification){
        try {
            specificationService.update(specification);
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
            specificationService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"删除失败");
        }
        return new Result(200,"删除成功");
    }

    /**
     * 查询需要字段的规格列表
     * @return
     */
    @RequestMapping("/findSpecificationList")
    public List<Map> findSpecificationList(){
        List<Map> specificationList = null;
        try {
             specificationList = specificationService.findSpecificationList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specificationList;
    }

    /**
     * 根据typTemplateId查询规格列表
     * @return
     */
    @RequestMapping("/findOptionListByTypeId")
    public List<Map> findOptionListByTypeId(Long id){
        List<Map> optionList = null;
        try {
            optionList = specificationService.findOptionListByTypeId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return optionList;
    }
}
