package com.sqt.group;

import com.sqt.goods.pojo.TbSpecification;
import com.sqt.goods.pojo.TbSpecificationOption;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 规格组合实体类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-07  9:15
 */

public class Specification implements Serializable{

	private TbSpecification specification;
	
	private List<TbSpecificationOption> specificationOptionList;

	public Specification(TbSpecification specification,
		List<TbSpecificationOption> specificationOptionList) {
		this.specification = specification;
		this.specificationOptionList = specificationOptionList;
	}

	public Specification() {
	}

	public TbSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}

	public List<TbSpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}

	public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}
	
	
	
	
}
