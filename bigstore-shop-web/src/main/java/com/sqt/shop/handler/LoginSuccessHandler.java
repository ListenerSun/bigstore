//package com.sqt.shop.handler;
//
//import com.sqt.shop.model.SecurityUser;
//import com.sqt.shop.model.Sys;
//import com.sqt.shop.utils.DateUtil;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
///**
// *
// * @author rabbit
// * @date 2016年1月5日 下午12:15:31
// */
//
////可以在这里将用户登录信息存入数据库。
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
//
//    private Logger log = LoggerFactory.getLogger(getClass());
//  @Override
//  public void onAuthenticationSuccess(HttpServletRequest request,
//          HttpServletResponse response, Authentication authentication) throws IOException,
//          ServletException {
//      //获得授权后可得到用户信息   可使用SUserService进行数据库操作
////      final Object principal = authentication.getPrincipal();
//      SecurityUser sellerUser = (SecurityUser)authentication.getPrincipal();
//
//      //输出登录提示信息
//      log.debug("=============>用户 " + sellerUser.getSellerId()+  DateUtil.getTime()+ " 登录.");
//
//      log.debug("=============>IP :"+getIpAddress(request));
//      request.getRequestDispatcher(Sys.indexUrl);
//
//      super.onAuthenticationSuccess(request, response, authentication);
//  }
//
//  public String getIpAddress(HttpServletRequest request){
//      String ip = request.getHeader("x-forwarded-for");
//      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//          ip = request.getHeader("Proxy-Client-IP");
//      }
//      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//          ip = request.getHeader("WL-Proxy-Client-IP");
//      }
//      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//          ip = request.getHeader("HTTP_CLIENT_IP");
//      }
//      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//          ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//      }
//      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//          ip = request.getRemoteAddr();
//      }
//      return ip;
//  }
//
//}
//
