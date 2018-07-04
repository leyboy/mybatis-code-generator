package com.ley.mybatis.code.generator.commons;

/**
 * 常量类,含有datasource.properties的键值常量
 * **/
public final class CodeGeneratorConstants {

    /**
     * 连接的数据库url的key值
     * **/
    public static final String DATASOURCE_JDBC_URL="dataSource.jdbcUrl";

    /**
     * 连接的数据库用户名的key值
     * **/
    public static final String DATASOURCE_USERNAME ="dataSource.user";

    /**
     * 连接的数据库登录密码的key值
     * **/
    public static final String DATASOURCE_PASSWORD="dataSource.password";


    /**
     * 连接的数据库驱动类的key值
     * **/
    public static final String DATASOURCE_DRIVER_CLASS_NAME="dataSource.driverClass";

    /**
     * 生成模型的包名key值
     * **/
    public static final String JAVA_MODEL_GENERATOR_TARGET_PACKAGE="javaModelGenerator.targetPackage";

    /**
     * 生成模型的位置key值
     * <br/>
     * 为了让code-generator的配置项更少,这里将生成模型的基础位置换成<b> 当前项目名/src/main/java</b>
     * **/
    @Deprecated
    public static final String JAVA_MODEL_GENERATOR_TARGET_PROJECT="javaModelGenerator.targetProject";

    /**
     * 生成映射文件的包名key值
     * **/
    public static final String SQL_MAP_GENERATOR_TARGET_PACKAGE="sqlMapGenerator.targetPackage";

    /**
     * 生成映射文件的位置key值
     * 为了让code-generator的配置项更少,这里将生成SQL映射文件的基础位置换成<b> 当前项目名/src/main/resource</b>
     * **/
    @Deprecated
    public static final String SQL_MAP_GENERATOR_TARGET_PROJECT="sqlMapGenerator.targetProject";


    /**
     * 生成dao文件的包名key值
     * **/
    public static final String JAVA_CLIENT_GENERATOR_TARGET_PACKAGE="javaClientGenerator.targetPackage";

    /**
     * 生成dao文件位置key值
     * 为了让code-generator的配置项更少,这里将生成模型的基础位置换成<b> 当前项目名/src/main/java</b>
     * **/
    @Deprecated
    public static final String JAVA_CLIENT_GENERATOR_TARGET_PROJECT="javaClientGenerator.targetProject";


    /**
     * table prefix的key值,默认是TB_(不区分大小写)
     * **/
    public static final String TABLE_PREFIX="tablePrefix";

    /**
     * mybatis generator config template vm location
     * **/
    public static final String MYBATIS_GENERATOR_CONFIG_VM_LOCATION ="templates/mybatis-generator-config.vm";

    /**
     * src/main/java
     * **/
    public static final String SRC_MAIN_JAVA="src/main/java";

    /**
     * src/main/resource
     * **/
    public static final String SRC_MAIN_RESOURCE="src/main/resources";

    /**
     * 默认编码
     * **/
    public static final String DEFAULT_ENCODING="UTF-8";

    /**
     * 当前项目
     * **/
    public static final String DEFAULT_CURRENT_PROJECT=".";
}
