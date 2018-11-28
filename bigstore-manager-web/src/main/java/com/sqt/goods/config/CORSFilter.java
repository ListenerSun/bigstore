package com.sqt.goods.config;

import com.sqt.Application_Goods_Con8002;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {
	private static final org.slf4j.Logger logger = LoggerFactory
		.getLogger(CORSFilter.class);
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		 logger.debug("============>跨域请求开始");
		 String hm = ((HttpServletRequest)req).getMethod();
		 HttpServletResponse response = (HttpServletResponse) res;
		 /*response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTI ONS, DELETE");        
		 response.setHeader("Access-Control-Max-Age", "3600");        
		 response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");*/
		 response.setHeader("Access-Control-Allow-Origin","*");
		 response.setHeader("Access-Control-Allow-Methods","POST");
		 response.setHeader("Access-Control-Allow-Headers","Access-Control");
		 response.setHeader("Access-Control-Allow-Credentials","true");
		 response.setHeader("Allow","POST");
		 response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, Access-Toke,refresh_token,user_id,access_token");
		 chain.doFilter(req, res);
		 logger.debug("============>跨域请求结束");
		}   
		
		public void init(FilterConfig filterConfig) {}
		public void destroy() {}  

}
