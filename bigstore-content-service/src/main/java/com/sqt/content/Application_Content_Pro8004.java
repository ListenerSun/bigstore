package com.sqt.content;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 官方不建议写xml配置文件而是推荐使用注解和配置类的方式
//@ImportResource(locations = {"classpath:bean.xml"}) // 导入spring的xml配置文件使其生效
//@MapperScan("com.sqt.goods.dao") // 整合mybatis的扫描dao层包的位置
@SpringBootApplication // 标记一个主程序入口说明是一个springboot应用
@EnableDubbo
public class Application_Content_Pro8004 {
	private static final Logger logger = LoggerFactory.getLogger(Application_Content_Pro8004.class);

	public static void main(String[] args) {
		SpringApplication.run(Application_Content_Pro8004.class, args);
		logger.info("启动成功");
	}
}
