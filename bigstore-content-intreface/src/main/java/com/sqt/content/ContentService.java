package com.sqt.content;

import com.sqt.entity.PageData;
import com.sqt.pojo.TbContent;
import java.util.List;

/**
 * @Description: 广告内容服务接口
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-12-26  16:58
 */
public interface ContentService {

    /**
     * 返回全部列表
     * @return
     */
    public List<TbContent> findAll() throws Exception;


    /**
     * 返回分页列表
     * @return
     */
    public PageData findPage(int pageNum,int pageSize) throws Exception;


    /**
     * 增加
     */
    public void add(TbContent content) throws Exception;


    /**
     * 修改
     */
    public void update(TbContent content) throws Exception;


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public TbContent findOne(Long id) throws Exception;


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
    public PageData findPage(TbContent content, int pageNum,int pageSize);

    /**
     * 根据广告分类ID查询广告
     */
    public List<TbContent> findByCategoryId(Long categoryId) throws Exception;
}
