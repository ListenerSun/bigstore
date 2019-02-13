package com.sqt.goods.service.typetemplate;

import com.sqt.entity.PageData;
import com.sqt.goods.pojo.TbTypeTemplate;
import java.util.List;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-10  14:47
 */
public interface TypeTemplateService {
    /**
     * 返回全部列表
     * @return
     */
    public List<TbTypeTemplate> findAll() throws Exception;


    /**
     * 返回分页列表
     * @return
     */
    public PageData findPage(int pageNum,int pageSize) throws Exception;


    /**
     * 增加
     */
    public void add(TbTypeTemplate typeTemplate) throws Exception;


    /**
     * 修改
     */
    public void update(TbTypeTemplate typeTemplate) throws Exception;


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public TbTypeTemplate findOne(Long id) throws Exception;


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
    public PageData findPage(TbTypeTemplate typeTemplate, int pageNum,int pageSize)
        throws Exception;
}
