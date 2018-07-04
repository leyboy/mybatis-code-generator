package com.ley.mybatis.code.generator.utils;

import com.ley.mybatis.code.generator.properties.ClasspathProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * abstract init bean utility
 * <br/>
 * 读取{{@link java.util.Properties}}并初始化响应的bean
 * **/
public abstract class AbstractBeanUtils {

    /**
     * 资源名
     * **/
    private String resource;

    /**
     * properties local
     * **/
    private Properties properties;


    private static final Log logger= LogFactory.getLog(AbstractBeanUtils.class);

    public AbstractBeanUtils(String resource) {
        this.resource = resource;
        initProperties();
    }

    /**
     * 初始化properties local
     * **/
    protected Properties initProperties() {
        ClasspathProperties classpathProperties = new ClasspathProperties(resource);
        try {
            logger.debug("创建了properties: "+classpathProperties);
            this.properties = classpathProperties.getProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    /**
     * 获取properties local
     * **/
    protected Properties getProperties(){
        return properties;
    }


    /**
     * 初始化bean
     * T:bean类型
     * **/
    protected abstract <T> T initBean();

    /**
     * 获取加载的资源名
     * **/
    public String getResource() {
        return resource;
    }
}
