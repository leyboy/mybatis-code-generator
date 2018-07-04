package com.ley.mybatis.code.generator;

import com.ley.mybatis.code.generator.commons.CodeGeneratorConstants;
import com.ley.mybatis.code.generator.utils.ClasspathResourceUtils;
import com.ley.mybatis.code.generator.velocity.utils.MybatisGeneratorVelocityContextUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * Code generator utility
 * <br/>
 * 主要用来根据数据库来生成mybatis-generator配置文件
 * **/
public class CodeUtils {

    private final static String DEFAULT_MYBATIS_GENERATOR_LOCATION="generatorConfig.xml";

    private static final Log logger= LogFactory.getLog(CodeUtils.class);

    /**
     * 生成mybatis-generator-config.xml
     * @param  datasourceResource
     *              data source resource location
     * @param  mybatisGeneratorResource
     *              mybatis generator configuration resource location
     * @param  generateXMLLocation
     *              generate mybatis generator xml location and default
     *              location is generatorConfig.xml,即默认生成的文件是在项目的根目录下.
     *              因为当前线程的类路径,如果传入的文件名是null,则默认是user.dir,工作路径
     *
     * **/
    public static void generateMybatisGeneratorConfigXML(String datasourceResource, String mybatisGeneratorResource,String generateXMLLocation) throws IOException {
        MybatisGeneratorVelocityContextUtils contextUtils=new MybatisGeneratorVelocityContextUtils(datasourceResource,mybatisGeneratorResource, CodeGeneratorConstants.MYBATIS_GENERATOR_CONFIG_VM_LOCATION);
        if(generateXMLLocation==null){
            generateXMLLocation=DEFAULT_MYBATIS_GENERATOR_LOCATION;
        }
        InputStream generateXMLInputStream= ClasspathResourceUtils.getInputStream(generateXMLLocation);
        File file=new File(generateXMLLocation);
        FileUtils.writeStringToFile(file,contextUtils.initVelocityContext().toString(),CodeGeneratorConstants.DEFAULT_ENCODING);
        String userDir=System.getProperty("user.dir");
        String realDefaultGenerateXMLLocation=new String(userDir+"/"+generateXMLLocation);
        logger.info("生成mybatis genrator xml location: "+realDefaultGenerateXMLLocation);
    }

}
