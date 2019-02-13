//package com.sqt.shop.service;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.sqt.Application_Seller_Con8003;
//import com.sqt.goods.service.SellerService;
//import com.sqt.pojo.TbSeller;
//import com.sqt.shop.component.SecurityUser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author rabbit
// * @date 2016年1月5日 下午12:11:08
// */
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
//	@Reference //业务服务类
//	private SellerService sellerService;
//
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		logger.debug("===============>开始验证");
//        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
//        //本例使用SUser中的email作为用户名:
//		TbSeller user = null; //code8
//		try {
//			user = sellerService.findByName(userName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (user == null) {
//			throw new UsernameNotFoundException("UserName " + userName + " not found");
//		}
//		logger.debug("===============>验证结束");
//		// SecurityUser实现UserDetails并将SUser的Email映射为username
//		return new SecurityUser(user); //code9
//	}
//}
