package com.ley.mybatis.code.generator.bean;

import java.util.List;
import java.util.Map;

/**
 * mybatis generator bean
 * **/
public class MybatisGeneratorBean {

    /**
     * data source,用来建立数据库连接
     * **/
    private DataSourceBean dataSourceBean;

    /**
     * 生成模型的包名
     * **/
    private String javaModelGeneratorTargetPackage;

    /**
     * 生成模型的位置
     * **/
    private String javaModelGeneratorTargetProject;

    /**
     * 生成映射文件的包名
     * **/
    private String sqlMapGeneratorTargetPackage;

    /**
     * 生成映射文件的位置
     * **/
    private String sqlMapGeneratorTargetProject;

    /**
     * 生成dao文件的包名
     * **/
    private String javaClientGeneratorTargetPackage;

    /**
     * 生成dao文件位置
     * **/
    private String javaClientGeneratorTargetProject;

    /**
     * 数据库表前缀,默认是tb_
     * **/
    private String tablePrefix="tb_";

    /**
     * 数据库表名map
     * **/
    private Map<String,String> tableMap;


    public MybatisGeneratorBean() {
    }



    public DataSourceBean getDataSourceBean() {
        return dataSourceBean;
    }

    public void setDataSourceBean(DataSourceBean dataSourceBean) {
        this.dataSourceBean = dataSourceBean;
    }

    public String getJavaModelGeneratorTargetPackage() {
        return javaModelGeneratorTargetPackage;
    }

    public void setJavaModelGeneratorTargetPackage(String javaModelGeneratorTargetPackage) {
        this.javaModelGeneratorTargetPackage = javaModelGeneratorTargetPackage;
    }

    public String getJavaModelGeneratorTargetProject() {
        return javaModelGeneratorTargetProject;
    }

    public void setJavaModelGeneratorTargetProject(String javaModelGeneratorTargetProject) {
        this.javaModelGeneratorTargetProject = javaModelGeneratorTargetProject;
    }

    public String getSqlMapGeneratorTargetPackage() {
        return sqlMapGeneratorTargetPackage;
    }

    public void setSqlMapGeneratorTargetPackage(String sqlMapGeneratorTargetPackage) {
        this.sqlMapGeneratorTargetPackage = sqlMapGeneratorTargetPackage;
    }

    public String getSqlMapGeneratorTargetProject() {
        return sqlMapGeneratorTargetProject;
    }

    public void setSqlMapGeneratorTargetProject(String sqlMapGeneratorTargetProject) {
        this.sqlMapGeneratorTargetProject = sqlMapGeneratorTargetProject;
    }

    public String getJavaClientGeneratorTargetPackage() {
        return javaClientGeneratorTargetPackage;
    }

    public void setJavaClientGeneratorTargetPackage(String javaClientGeneratorTargetPackage) {
        this.javaClientGeneratorTargetPackage = javaClientGeneratorTargetPackage;
    }

    public String getJavaClientGeneratorTargetProject() {
        return javaClientGeneratorTargetProject;
    }

    public void setJavaClientGeneratorTargetProject(String javaClientGeneratorTargetProject) {
        this.javaClientGeneratorTargetProject = javaClientGeneratorTargetProject;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public Map<String, String> getTableMap() {
        return tableMap;
    }

    public void setTableMap(Map<String, String> tableMap) {
        this.tableMap = tableMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MybatisGeneratorBean{");
        sb.append("dataSourceBean=").append(dataSourceBean);
        sb.append(", javaModelGeneratorTargetPackage='").append(javaModelGeneratorTargetPackage).append('\'');
        sb.append(", javaModelGeneratorTargetProject='").append(javaModelGeneratorTargetProject).append('\'');
        sb.append(", sqlMapGeneratorTargetPackage='").append(sqlMapGeneratorTargetPackage).append('\'');
        sb.append(", sqlMapGeneratorTargetProject='").append(sqlMapGeneratorTargetProject).append('\'');
        sb.append(", javaClientGeneratorTargetPackage='").append(javaClientGeneratorTargetPackage).append('\'');
        sb.append(", javaClientGeneratorTargetProject='").append(javaClientGeneratorTargetProject).append('\'');
        sb.append(", tablePrefix='").append(tablePrefix).append('\'');
        sb.append(", tableMap=").append(tableMap);
        sb.append('}');
        return sb.toString();
    }
}

