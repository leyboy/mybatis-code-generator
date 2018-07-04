package com.ley.mybatis.code.generator.utils;

import com.ley.mybatis.code.generator.bean.MybatisGeneratorBean;
import com.ley.mybatis.code.generator.commons.CodeGeneratorConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.Properties;

/**
 * Mybatis generator init bean
 * <br/>
 * Mybatis generator bean 初始化工具类
 **/
public class MybatisGeneratorBeanUtils extends AbstractBeanUtils {

    /**
     * database resource
     * <br/>
     * 类路径下的database资源
     **/
    private String databaseResource;

    private static final Log logger = LogFactory.getLog(MybatisGeneratorBeanUtils.class);

    public MybatisGeneratorBeanUtils(String resource, String databaseResource) {
        super(resource);
        this.databaseResource = databaseResource;
    }


    @Override
    public MybatisGeneratorBean initBean() {
        MybatisGeneratorBean mybatisGeneratorBean = new MybatisGeneratorBean();
        //初始化dbUtils
        DbUtils dbUtils = new DbUtils(this.databaseResource);
        //装配DataSourceBean,获取数据库连接属性
        mybatisGeneratorBean.setDataSourceBean(new DataSourceBeanUtils(this.databaseResource).initBean());
        //获取Mybatis generator配置的Properties
        Properties properties = getProperties();
        logger.debug("加载了mybatis generator配置文件" + this.getResource());
        logger.debug("mybatis generator properties: " + properties);
        mybatisGeneratorBean.setJavaModelGeneratorTargetPackage(properties.getProperty(CodeGeneratorConstants.JAVA_MODEL_GENERATOR_TARGET_PACKAGE));

        mybatisGeneratorBean.setJavaModelGeneratorTargetProject(CodeGeneratorConstants.DEFAULT_CURRENT_PROJECT + "/" + CodeGeneratorConstants.SRC_MAIN_JAVA);
        mybatisGeneratorBean.setSqlMapGeneratorTargetPackage(properties.getProperty(CodeGeneratorConstants.SQL_MAP_GENERATOR_TARGET_PACKAGE));

        mybatisGeneratorBean.setSqlMapGeneratorTargetProject(CodeGeneratorConstants.DEFAULT_CURRENT_PROJECT + "/" + CodeGeneratorConstants.SRC_MAIN_RESOURCE);
        mybatisGeneratorBean.setJavaClientGeneratorTargetPackage(properties.getProperty(CodeGeneratorConstants.JAVA_CLIENT_GENERATOR_TARGET_PACKAGE));

        mybatisGeneratorBean.setJavaClientGeneratorTargetProject(CodeGeneratorConstants.DEFAULT_CURRENT_PROJECT + "/" + CodeGeneratorConstants.SRC_MAIN_JAVA);
        mybatisGeneratorBean.setTablePrefix(properties.getProperty(CodeGeneratorConstants.TABLE_PREFIX));

        Map<String, String> tableMap = dbUtils.getTables(mybatisGeneratorBean.getTablePrefix());
        mybatisGeneratorBean.setTableMap(tableMap);
        logger.debug("初始化MybatisGeneratorBean: " + mybatisGeneratorBean);
        dbUtils.closeConnection();
        return mybatisGeneratorBean;
    }
}
