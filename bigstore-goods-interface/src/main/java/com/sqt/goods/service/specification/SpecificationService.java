package com.sqt.goods.service.specification;
import com.sqt.entity.PageData;
import com.sqt.group.Specification;
import com.sqt.goods.pojo.TbSpecification;
import java.util.List;
import java.util.Map;

/**
 * @Description: 规格服务类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-07  9:18
 */
public interface SpecificationService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbSpecification> findAll() throws Exception;
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageData findPage(int pageNum, int pageSize) throws Exception;
	
	
	/**
	 * 增加
	*/
	public void add(Specification specification) throws Exception;
	
	
	/**
	 * 修改
	 */
	public void update(Specification specification) throws Exception;
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Specification findOne(Long id) throws Exception;
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids) throws Exception;

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageData findPage(TbSpecification specification, int pageNum, int pageSize)
		throws Exception;

	public List<Map> findSpecificationList() throws Exception;

	//根据typetemplateId查询option列表
	public List<Map> findOptionListByTypeId(Long id) throws Exception;
	
}
