//package com.sqt.shop.model;
//
//import com.sqt.pojo.TbSeller;
//import java.util.Collection;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
///**
// * @Description:
// * @author: sqt(男，未婚) 微信:810548252
// * @Date: Created in 2018-11-17  20:18
// */
//public class SecurityUser extends TbSeller implements UserDetails {
//
//    private static final long serialVersionUID = 1L;
//
//    public SecurityUser(TbSeller seller) {
//        this.setId(seller.getId());
//        this.setSellerId(seller.getSellerId());
//        this.setName(seller.getName());
//        this.setNickName(seller.getNickName());
//        this.setPassword(seller.getPassword());
//        this.setEmail(seller.getEmail());
//        this.setStatus(seller.getStatus());
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return super.getSellerId();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
