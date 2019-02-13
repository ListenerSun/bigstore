//package com.sqt.shop.service;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.sqt.goods.service.seller.SellerService;
//import com.sqt.pojo.TbSeller;
//import com.sqt.shop.model.SecurityUser;
//import java.util.ArrayList;
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//
///**
// * @Description:
// * @author: sqt(男，未婚) 微信:810548252
// * @Date: Created in 2018-11-14  15:52
// */
//@Component
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//	@Reference //业务服务类
//	private SellerService sellerService;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		logger.debug("经过了UserDetailsServiceImpl");
//		//构建角色列表
//		List<GrantedAuthority> grantAuths=new ArrayList();
//		grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));
//		//得到商家对象
//		TbSeller seller = null;
//		try {
//			seller = sellerService.findByName(username);
//		} catch (Exception e) {
//			logger.debug("没有查到商家用户");
//			e.printStackTrace();
//		}
//		if(seller!=null){
//			if(seller.getStatus().equals("1")){
//				return new SecurityUser(seller);
//			}else{
//				logger.debug("该商家还未审核，不能登入");
//				return null;
//			}
//		}else{
//			return null;
//		}
//	}
//
//}
