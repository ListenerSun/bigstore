package com.sqt.goods.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

import javax.annotation.Resource;

/**
 * @Description:s solr的配置类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-11  0:04
 */
@Configuration
public class SolrConfig {

    private Logger logger = LoggerFactory.getLogger(SolrConfig.class);
    @Resource
    private SolrClient solrClient;
    /**
     * 配置SolrTemplate
     */
    @Bean
    public SolrTemplate solrTemplate() {
        logger.info("===========>开始注入solrTemplate");
        SolrTemplate solrTemplate = new SolrTemplate(solrClient);
        logger.info("===========>完成注入solrTemplate");
        return solrTemplate;
    }

}
