package com.sqt.goods.service.imp.specification;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.entity.PageData;
import com.sqt.goods.dao.DaoSupport;
import com.sqt.goods.service.specification.SpecificationService;
import com.sqt.group.Specification;
import com.sqt.pojo.TbSpecification;
import com.sqt.pojo.TbSpecificationOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Description: 规格服务类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-07  9:18
 */
@Service()//version = "1.0.0"
@Component
public class SpecificationServiceImp implements SpecificationService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;
    /**
     * 返回全部列表
     * @return
     */
    @Override
    public List<TbSpecification> findAll() throws Exception {
        return (List<TbSpecification>) dao.findForList("SpecificationMapper.findAll",null);
    }
    /**
     * 返回分页列表
     * @return
     */
    @Override
    public PageData findPage(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbSpecification>)dao.findForList("SpecificationMapper.findAll", null);
        Page<TbSpecification> page = (Page<TbSpecification>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    /**
     * 增加
     */
    @Override
    public void add(Specification specification) throws Exception {
        dao.save("SpecificationMapper.add", specification.getSpecification());
        if(!specification.getSpecificationOptionList().isEmpty()){
            for (TbSpecificationOption tbSpecificationOption : specification.getSpecificationOptionList()) {
                tbSpecificationOption.setSpecId(specification.getSpecification().getId());
                dao.save("SpecificationOptionMapper.add",tbSpecificationOption);
            }
        }
    }

    /**
     * 更新
     * @param specification
     */
    @Override
    public void update(Specification specification) throws Exception {
        dao.update("SpecificationMapper.edit",specification.getSpecification());
        if(!specification.getSpecificationOptionList().isEmpty()){
            for (TbSpecificationOption tbSpecificationOption : specification.getSpecificationOptionList()) {
                dao.update("SpecificationOptionMapper.edit",tbSpecificationOption);
            }
            List<Long> idList = (List<Long>) dao.findForList("SpecificationOptionMapper.findIdList",
                specification.getSpecification().getId());
            List<Long> editIdList = new ArrayList<>();
            for (TbSpecificationOption tbSpecificationOption : specification.getSpecificationOptionList()) {
                editIdList.add(tbSpecificationOption.getId());
            }
            for (Long id : idList) {
                if(editIdList.contains(id)){
                    continue;
                }else {
                    dao.delete("SpecificationOptionMapper.delete",id);
                }

            }
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Specification findOne(Long id) throws Exception {
        TbSpecification tbSpecification = (TbSpecification) dao.findForObject("SpecificationMapper.findById", id);
        List<TbSpecificationOption> specificationOptionList = null;
        if (null != tbSpecification){
            specificationOptionList = (List<TbSpecificationOption>) dao.findForList("SpecificationOptionMapper.findBySpecificationId", tbSpecification.getId());
        }
        return new Specification(tbSpecification,specificationOptionList);
    }

    /**
     * 删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) throws Exception {
        for (Long id : ids) {
            dao.delete("SpecificationMapper.delete",id);
            dao.delete("SpecificationOptionMapper.deleteBySpecId",id);
        }
    }

    /**分页查询
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     */
    @Override
    public PageData findPage(TbSpecification specification, int pageNum, int pageSize)
        throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbSpecification>)dao.findForList("SpecificationMapper.findAll", specification);
        Page<TbSpecification> page = (Page<TbSpecification>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public List<Map> findSpecificationList() throws Exception {
        return (List<Map>) dao.findForList("SpecificationMapper.findSpecificationList",null);
    }

    @Override
    public List<Map> selectOptionList() {
        return null;
    }
}
