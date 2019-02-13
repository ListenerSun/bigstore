package com.sqt.shop.controller.seller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sqt.entity.PageData;
import com.sqt.entity.Result;
import com.sqt.goods.service.seller.SellerService;
import com.sqt.goods.pojo.TbSeller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-13  15:48
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference()
    private SellerService sellerService;

    /**
     * 商家入驻
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbSeller seller ){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encodePassword = bCryptPasswordEncoder.encode(seller.getPassword());
//        seller.setPassword(encodePassword);
        try {
          sellerService.add(seller);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"入驻失败");
        }
        return new Result(200,"入驻成功");
    }

    /**
     * 查询分页商家列表,有条件
     * @param seller
     * @return
     */
    @RequestMapping("/query")
    public PageData query(@RequestBody TbSeller seller,int pageNum, int pageSize){
        PageData pageData = null;
        try {
            pageData = sellerService.query(seller, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageData;
    }

    /**
     * 查询所有商家列表
     * @return
     */
    @RequestMapping("/findAll")
    public PageData findAll(int pageNum,int pageSize){
        PageData pageData = null;
        try {
            pageData = sellerService.finaAll(pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageData;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/findOneById")
    public TbSeller findOneById(Long id){
        TbSeller seller = null;
        try {
            seller = sellerService.findOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seller;
    }

    /**
     * 更改商家状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/upStatus")
    public Result upStatus(Long id,String status){
        try {
            sellerService.upStatus(id,status);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"更新失败");
        }
        return new Result(200,"更改成功");
    }
}
