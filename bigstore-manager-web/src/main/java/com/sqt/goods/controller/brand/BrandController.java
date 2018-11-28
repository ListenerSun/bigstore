package com.sqt.goods.controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.goods.service.brand.BrandService;
import com.sqt.pojo.TbBrand;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 商品品牌服务
 * @author: sqt
 * @Date: Created in 2018-10-31  13:11
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Reference()//version = "1.0.0"
    private BrandService brandService;

    /**
     * 根据id查询商品品牌
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public TbBrand findById( @PathVariable("id") Long id)  {
        TbBrand brand = null;
        try {
            brand = brandService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    /**
     * 查询所有商品品牌列表
     * @return
     */
    @RequestMapping(value = "/list")
    public List<TbBrand> findAll(){
        List<TbBrand> brandList = null;
        try {
            brandList = brandService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  brandList;
    }

    /**
     * 查询分页商品
     * @param pageSize 当前页数量
     * @param pageNum   当前页码
     * @return
     */
    @RequestMapping(value = "/findPageData")
    public PageData findPageData( int pageNum,int pageSize ){
        PageData pageData = null;

        try {
             pageData = brandService.findPageData(pageNum, pageSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageData;
    }

    /**
     * 新增商品品牌
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            if ("".equals(brand.getName())||null == brand.getName()
                ||"".equals(brand.getFirstChar())||null == brand.getFirstChar()){
                return new Result(400,"输入的参数有误");
            }
            brandService.add(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"添加失败");
        }
        return new Result(200,"添加成功");
    }

    /**
     * 编辑商品品牌
     * @param brand
     * @return
     */
    @RequestMapping(value = "/edit")
    public Result edit(@RequestBody TbBrand brand){
        try {
            if ("".equals(brand.getName())||null == brand.getName()
                ||"".equals(brand.getFirstChar())||null == brand.getFirstChar()){
                return new Result(400,"输入的参数有误");
            }
            brandService.edit(brand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new Result(200,"更新成功");
    }

    /**
     * 删除商品品牌
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"删除失败");
        }
        return new Result(200,"删除成功");
    }

    /**
     * 根据条件查询分页商品
     * @param pageSize 当前页数量
     * @param pageNum   当前页码
     * @return
     */
    @RequestMapping(value = "/search")
    public PageData findByCondition(Integer pageNum,Integer pageSize ,@RequestBody TbBrand brand){
        PageData pageData = null;
        try {
            pageData = brandService.findPageData(pageNum, pageSize,brand);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageData;
    }

    /**
     * 查询需要字段的品牌列表
     * @return
     */
    @RequestMapping("/findBrandList")
    public List<Map> findBrandLIst(){
        List<Map> brandList = null;
        try {
            brandList = brandService.findBrandList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandList;
    }



    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        return brandService.test();//
    }



}
