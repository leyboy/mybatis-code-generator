package com.ley.mybatis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testClasspathUtils(){
        String jdbcUrl="jdbc:mysql://43.226.44.137:3306/mysql180508e8a3_db?characterEncoding=utf8&useSSL=true";
        jdbcUrl=jdbcUrl.replaceAll("&","&amp;");
        System.out.println(jdbcUrl);
        String userDir=System.getProperty("user.dir");
        System.out.println(userDir.substring(userDir.lastIndexOf("\\")+1));
    }
}
