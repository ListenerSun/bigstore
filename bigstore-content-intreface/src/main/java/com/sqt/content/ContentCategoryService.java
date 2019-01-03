package com.sqt.content;

import com.sqt.entity.PageData;
import com.sqt.pojo.TbContentCategory;
import java.util.List;

/**
 * @Description: 广告分类服务层接口
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-12-26  17:02
 */
public interface ContentCategoryService {
    /**
     * 返回全部列表
     * @return
     */
    public List<TbContentCategory> findAll() throws Exception;


    /**
     * 返回分页列表
     * @return
     */
    public PageData findPage(int pageNum,int pageSize) throws Exception;


    /**
     * 增加
     */
    public void add(TbContentCategory contentCategory) throws Exception;


    /**
     * 修改
     */
    public void update(TbContentCategory contentCategory) throws Exception;


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public TbContentCategory findOne(Long id) throws Exception;


    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long [] ids) throws Exception;

    /**
     * 分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageData findPage(TbContentCategory contentCategory, int pageNum,int pageSize)
        throws Exception;

    public Object test();
}
