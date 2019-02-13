package com.sqt.goods.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:图片配置类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-02  10:53
 */
@Configuration
@ConfigurationProperties(prefix = "picture" )
@PropertySource(value = "classpath:picture.properties" ,encoding = "UTF-8")
public class PictureConfig {

    private String location;
    private String weburl;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    @Override
    public String toString() {
        return "PictureConfig{" + "location='" + location + '\'' + ", weburl='" + weburl + '\''
            + '}';
    }
}
