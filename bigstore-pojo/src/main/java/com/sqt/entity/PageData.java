package com.sqt.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页查询的数据实体类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-03  20:07
 */
public class PageData implements Serializable {

    private List rows;    //数量
    private long total;   //总记录数

    public PageData(List rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
