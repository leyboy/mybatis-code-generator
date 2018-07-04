package com.ley.mybatis.code.generator.utils;

import com.ley.mybatis.code.generator.bean.DataSourceBean;
import com.ley.mybatis.code.generator.commons.MySQLMetaDataConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * database utils
 * **/
public class DbUtils {

    private final String resource;

    public DbUtils(String resource) {
        this.resource=resource;
        initConnectionThreadLocal();
    }

    /**
     * 数据库连接的当地线程
     * **/
    private static ThreadLocal<Connection> connectionThreadLocal;

    private static final Log logger= LogFactory.getLog(DbUtils.class);

    /**
     * 初始化数据库连接
     * **/
    protected Connection initConnection() {
        DataSourceBeanUtils dataSourceBeanUtils=new DataSourceBeanUtils(resource);
        DataSourceBean dataSourceBean=dataSourceBeanUtils.initBean();
        Connection connection=null;
        try {
            Class.forName(dataSourceBean.getDriverClassName());
            connection= DriverManager.getConnection(dataSourceBean.getJdbcUrl(),dataSourceBean.getUsername(),
                    dataSourceBean.getPassword());
        }catch (Exception e){
            logger.info("数据库连接失败...");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 初始化connection thread local
     * **/
    protected ThreadLocal<Connection> initConnectionThreadLocal(){
        final Connection connection=initConnection();
        connectionThreadLocal=new ThreadLocal<Connection>() {
            @Override
            protected Connection initialValue() {
                logger.debug("初始化数据库连接: "+connection);
                return connection;
            }
        };
        return null;
    }



    /**
     * 获取数据库连接
     * **/
    public Connection getConnection(){
        return connectionThreadLocal.get();
    }


    /**
     * 关闭数据库连接
     * **/
    public void closeConnection(){
        Connection connection=connectionThreadLocal.get();
        if(connection!=null){
            try {
                logger.info("数据库连接关闭");
                connection.close();
            } catch (SQLException e) {
                logger.info("数据库连接关闭异常");
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取数据库表
     * @return 返回一个map,键值是表名,value值是实体类名;如果没有表返回{@code null}
     * **/
    public Map<String,String> getTables( String tablePrefix){
        Connection connection=getConnection();
        Map<String,String> tableMap=new HashMap<>();
        try {
            ResultSet resultSet=connection.getMetaData().getTables(null,null,"%",
                    MySQLMetaDataConstants.TABLE_TYPES);
            while(resultSet.next()){
                String tableName=resultSet.getString(MySQLMetaDataConstants.GET_TABLE_NAME);
                String entityClassName=tableName.substring(tablePrefix.length());
                String realEntityClassName=entityClassName.substring(0,1).toUpperCase()+entityClassName.substring(1);
                tableMap.put(tableName,realEntityClassName);
            }
            return tableMap;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("数据库没有表");
            return null;
        }
    }
}
