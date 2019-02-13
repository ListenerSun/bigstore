package com.sqt.goods.service.imp.typetemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.service.typetemplate.TypeTemplateService;
import com.sqt.goods.pojo.TbTypeTemplate;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-10  14:52
 */
@Service
@Component
public class TypeTemplateServiceImp implements TypeTemplateService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;
    /**
     * 返回全部列表
     * @return
     */
    @Override
    public List<TbTypeTemplate> findAll() throws Exception {
        return (List<TbTypeTemplate>) dao.findForList("TypeTemplateMapper.findAll",null);
    }

    /**
     * 返回分页列表
     * @return
     */
    @Override
    public PageData findPage(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TbTypeTemplate>  list = (List<TbTypeTemplate>) dao.findForList("TypeTemplateMapper.findAll", null);
        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbTypeTemplate typeTemplate) throws Exception {
        dao.save("TypeTemplateMapper.add",typeTemplate);
    }

    /**
     * 更新
     * @param typeTemplate
     */
    @Override
    public void update(TbTypeTemplate typeTemplate) throws Exception {
        dao.update("TypeTemplateMapper.edit",typeTemplate);
    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public TbTypeTemplate findOne(Long id) throws Exception {
        return (TbTypeTemplate) dao.findForObject("TypeTemplateMapper.findById",id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) throws Exception {
        for (Long id : ids) {
          dao.delete("TypeTemplateMapper.delete",id);
        }

    }

    /**分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     */
    @Override
    public PageData findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize)
        throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TbTypeTemplate>  list = (List<TbTypeTemplate>) dao.findForList("TypeTemplateMapper.findAll", typeTemplate);
        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) list;
        return new PageData(page.getResult(),page.getTotal());
    }
}
