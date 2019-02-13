//package com.sqt.shop.component;
//
//import com.sqt.pojo.TbSeller;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
///**
// *
// * @author rabbit
// * @date 2016年1月5日 下午12:23:54
// */
//public class SecurityUser extends TbSeller implements UserDetails
//{
//
//	private static final long serialVersionUID = 1L;
//	public SecurityUser(TbSeller suser) {
//		if(suser != null)
//		{
//			this.setId(suser.getId());
//			this.setName(suser.getName());
//			this.setEmail(suser.getEmail());
//			this.setPassword(suser.getPassword());
//		}
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//				SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_SELLER");
//				authorities.add(authority);
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return super.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return super.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}
//
