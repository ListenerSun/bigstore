//package com.sqt.goods.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import javax.sql.DataSource;
//import org.apache.ibatis.logging.stdout.StdOutImpl;
//import org.apache.ibatis.session.ExecutorType;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
///**
// * Created by BartG on 2018/6/10.
// */
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean(name = "dataSource")
////    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource testDataSource() {
////        logger.debug("==========>加载数据源");
//        /*return DataSourceBuilder.create().build();*/
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/bigstore?useUnicode=true&characterEncoding=utf-8");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        dataSource.setMaxActive(20);
//        dataSource.setMinIdle(3);
//        dataSource.setInitialSize(1);
//        dataSource.setMaxWait(6000);
//        dataSource.setTimeBetweenEvictionRunsMillis(60000);
//        dataSource.setMinEvictableIdleTimeMillis(3000);
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(200);
//        return dataSource;
//    }
//
//    @Bean("transactionManager")
//    public DataSourceTransactionManager mysqlTransactionManager(
//            @Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "sqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(
//            @Qualifier("sqlSessionFactory") SqlSessionFactory hbasePhoenixSqlSessionFactory) {
//        return new SqlSessionTemplate(hbasePhoenixSqlSessionFactory);
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory SqlSessionFactory(
//            @Qualifier("dataSource") DataSource hbasePhoenixDataSource)
//            throws Exception {
//        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        factory.setDataSource(hbasePhoenixDataSource);
//        // 创建配置对象
//        org.apache.ibatis.session.Configuration conf = new org.apache.ibatis.session.Configuration();
//        conf.setCacheEnabled(true); // 开启二级缓存
//        conf.setUseGeneratedKeys(true);
//        conf.setDefaultExecutorType(ExecutorType.REUSE);
//        conf.setCallSettersOnNulls(true);
//        conf.setLogImpl(StdOutImpl.class); // 设置打印SQL的日志类
//        factory.setConfiguration(conf); // 设置配置
////        factory.setTypeAliasesPackage("com.sparrow.hadmin.entity");// 全局包别名
//
//        //添加Mapper的XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factory.setMapperLocations(
//                resolver.getResources("classpath:mybatis/mapper/**/*.xml"));
//        factory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis.cfg.xml"));
//
//        // 添加插件
////        Interceptor[] plugins = {
//////                new PaginationInterceptor() // 分页插件
//////                new SqlExplainInterceptor(), // 执行分析插件（防止全表update/delete）
//////                new PerformanceInterceptor() // 性能分析插件
////        };
////        sqlSessionFactory.setPlugins(plugins);
//
//        return factory.getObject();
//    }
//
//
//    @Bean
//    public MapperScannerConfigurer hbasePhoenixMapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("hbasePhoenixSqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("com.sqt.goods.dao");
//        return mapperScannerConfigurer;
//    }
//
//}
