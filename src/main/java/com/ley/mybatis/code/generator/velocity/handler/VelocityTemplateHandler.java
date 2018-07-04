package com.ley.mybatis.code.generator.velocity.handler;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.Writer;

/**
 * velocity template handler
 * **/
public class VelocityTemplateHandler {

    private VelocityCallback velocityCallback;

    private Template template;

    public VelocityTemplateHandler() {
    }

    public VelocityTemplateHandler(Template template,VelocityCallback velocityCallback) {
        this.template=template;
        this.velocityCallback = velocityCallback;
    }


    /**
     * template handler
     * **/
    public void handler(VelocityContext context, Writer writer){
        velocityCallback.doInVelocityContext(context);
        template.merge(context,writer);
    }
}
