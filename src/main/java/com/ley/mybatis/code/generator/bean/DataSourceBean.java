package com.ley.mybatis.code.generator.bean;

/**
 *datasource bean .
 * **/
public class DataSourceBean {

    private String username;
    private String password;
    private String jdbcUrl;
    private String driverClassName;

    public DataSourceBean() {
    }

    public DataSourceBean(String username, String password, String database, String jdbcUrl, String driverClassName) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataSourceBean{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", jdbcUrl='").append(jdbcUrl).append('\'');
        sb.append(", driverClassName='").append(driverClassName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
