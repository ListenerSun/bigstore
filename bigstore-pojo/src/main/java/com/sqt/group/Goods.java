package com.sqt.group;

import com.sqt.goods.pojo.TbGoods;
import com.sqt.goods.pojo.TbGoodsDesc;
import com.sqt.goods.pojo.TbItem;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 商品增加组合类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-20  16:52
 */
public class Goods implements Serializable{
    private TbGoods goods; // 商品信息
    private TbGoodsDesc goodsDesc; // 商品扩展信息

    private List<TbItem> itemList; // SKU的列表信息
    public TbGoods getGoods() {
        return goods;
    }
    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }
    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }
    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    public List<TbItem> getItemList() {
        return itemList;
    }
    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }

}
