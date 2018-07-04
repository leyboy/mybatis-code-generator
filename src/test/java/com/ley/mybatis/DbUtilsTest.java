package com.ley.mybatis;

import com.ley.mybatis.code.generator.commons.MySQLMetaDataConstants;
import com.ley.mybatis.code.generator.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtilsTest {

    @Test
    public void testDbUtils() throws SQLException {
        DbUtils dbUtils=new DbUtils("datasource.properties");
        String[] types={"TABLE"};
        Connection connection=dbUtils.getConnection();
        ResultSet resultSet=connection.getMetaData().getTables(null,null,"%",
                types);
        while(resultSet.next()){
            System.out.println(resultSet.getString(MySQLMetaDataConstants.GET_TABLE_NAME));
        }
        String table="tb_user";
        String table_prefix="tb_";
        String entityClassName=table.substring(table_prefix.length());
        String realEntityClassName=entityClassName.substring(0,1).toUpperCase()+entityClassName.substring(1);
        System.out.println(realEntityClassName);
    }
}
