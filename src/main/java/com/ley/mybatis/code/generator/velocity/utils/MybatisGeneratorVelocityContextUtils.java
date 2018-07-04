package com.ley.mybatis.code.generator.velocity.utils;

import com.ley.mybatis.code.generator.bean.MybatisGeneratorBean;
import com.ley.mybatis.code.generator.utils.MybatisGeneratorBeanUtils;
import com.ley.mybatis.code.generator.velocity.handler.VelocityCallback;
import com.ley.mybatis.code.generator.velocity.handler.VelocityTemplateHandler;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.StringWriter;
import java.io.Writer;

/**
 * Velocity context utils
 * **/
public class MybatisGeneratorVelocityContextUtils {

    private String datasourceResource;

    private String mybatisGeneratorResource;

    private String generatorConfigVmResource;

    private static MybatisGeneratorBean mybatisGeneratorBean;

    private static final VelocityContext VELOCITY_CONTEXT= VelocityUtils.getVelocityContext();

    public MybatisGeneratorVelocityContextUtils(String datasourceResource, String mybatisGeneratorResource, String generatorConfigVmResource) {
        this.datasourceResource = datasourceResource;
        this.mybatisGeneratorResource = mybatisGeneratorResource;
        this.generatorConfigVmResource = generatorConfigVmResource;
    }

    /**
     * init velocity context
     * @return 返回{{@link StringWriter}},里面含有生成的mybatis generator config xml string
     * **/
    public Writer initVelocityContext(){
        final VelocityContext velocityContext=VELOCITY_CONTEXT;
        mybatisGeneratorBean= new MybatisGeneratorBeanUtils(mybatisGeneratorResource,datasourceResource).initBean();
        Template template=VelocityUtils.getVelocityTemplateByResource(generatorConfigVmResource,null);
        StringWriter writer = new StringWriter();
        VelocityTemplateHandler handler=new VelocityTemplateHandler(template,new MybatisGeneratorVelocityCallback());
        handler.handler(velocityContext,writer);
        return writer;
    }


    static class MybatisGeneratorVelocityCallback implements VelocityCallback {

        @Override
        public void doInVelocityContext(VelocityContext context) {
            //database connection
            context.put("username",mybatisGeneratorBean.getDataSourceBean().getUsername());
            context.put("password",mybatisGeneratorBean.getDataSourceBean().getPassword());
            context.put("jdbcUrl",mybatisGeneratorBean.getDataSourceBean().getJdbcUrl());
            context.put("driverClassName",mybatisGeneratorBean.getDataSourceBean().getDriverClassName());


            //mybatis generator
            context.put("javaModelGeneratorTargetPackage",mybatisGeneratorBean.getJavaModelGeneratorTargetPackage());
            context.put("javaModelGeneratorTargetProject",mybatisGeneratorBean.getJavaModelGeneratorTargetProject());
            context.put("sqlMapGeneratorTargetPackage",mybatisGeneratorBean.getSqlMapGeneratorTargetPackage());
            context.put("sqlMapGeneratorTargetProject",mybatisGeneratorBean.getSqlMapGeneratorTargetProject());
            context.put("javaClientGeneratorTargetPackage",mybatisGeneratorBean.getJavaClientGeneratorTargetPackage());
            context.put("javaClientGeneratorTargetProject",mybatisGeneratorBean.getJavaClientGeneratorTargetProject());
            context.put("tableMap",mybatisGeneratorBean.getTableMap());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MybatisGeneratorVelocityContextUtils{");
        sb.append("datasourceResource='").append(datasourceResource).append('\'');
        sb.append(", mybatisGeneratorResource='").append(mybatisGeneratorResource).append('\'');
        sb.append(", generatorConfigVmResource='").append(generatorConfigVmResource).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
