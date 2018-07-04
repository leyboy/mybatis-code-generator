package com.ley.mybatis.code.generator.properties;

import com.ley.mybatis.code.generator.utils.ClasspathResourceUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.Properties;

/**
 * 读取classpath下的资源并转换成{@link Properties}
 **/
public class ClasspathProperties {

    private Properties properties;

    /**
     * 资源名,针对classpath下的资源
     **/
    private final String resource;

    private static final Log logger= LogFactory.getLog(ClasspathProperties.class);

    public ClasspathProperties(String resource){
        this.resource = resource;
    }


    protected Properties initProperties() throws IOException {
        properties = new Properties();
        InputStream resourceInputStream = ClasspathResourceUtils.getInputStream(resource);
        if(resourceInputStream==null){
            logger.error("资源名为: "+resource+"在类路径下没有找到");
            throw new IOException("资源名为: "+resource+"在类路径下没有找到");
        }else{
            logger.debug("加载了资源: "+resource);
            properties.load(resourceInputStream);
            return properties;
        }
    }


    public  Properties getProperties()throws IOException {
        initProperties();
        return properties;
    }
}
