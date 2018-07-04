package com.ley.mybatis.code.generator.velocity.utils;

import com.ley.mybatis.code.generator.commons.CodeGeneratorConstants;
import com.ley.mybatis.code.generator.velocity.constants.VelocityConstants;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Velocity utility class
 **/
public class VelocityUtils {


    protected static VelocityEngine getVelocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, VelocityConstants.RESOURCE_PREFIX);
        velocityEngine.setProperty(VelocityConstants.RESOURCE_LOADER_CLASS_PREFIX, VelocityConstants.RESOURCE_LOADER_CLASS.getName());
        velocityEngine.init();
        return velocityEngine;
    }


    /**
     * 获取资源模板,key值是资源模板名,value值是模板({@link Template})
     *
     * @return {@link Map}
     **/
    public static Map<String, Template> getVelocityTemplates(String encoding,String... resources) {
        Map<String, Template> templateMap = new HashMap<>();
        final VelocityEngine velocityEngine = getVelocityEngine();
        if (resources != null && resources.length > 0) {
            for (String resource : resources) {
                if(encoding!=null&&(!"".equals(encoding))){
                    //do nothing
                }else{
                    encoding=CodeGeneratorConstants.DEFAULT_ENCODING;
                }
                Template template = velocityEngine.getTemplate(resource);
                templateMap.put(resource, template);
            }
        }
        return templateMap;
    }


    /**
     * 根据resource查找velocity template
     *
     * @param resource  velocity template resource path
     * @param templates velocity template map and get by {{@link VelocityUtils#getVelocityTemplates(String, String...)}}
     **/
    public static Template getVelocityTemplatesByResource(String resource,Map<String,Template> templates) {
        final Map<String, Template> templateMap = templates;
        if (templateMap != null && templateMap.size() > 0) {
            for (Map.Entry<String, Template> templateEntry : templateMap.entrySet()) {
                if (!"".equals(resource) && resource.equals(templateEntry.getKey())) {
                    return templateEntry.getValue();
                }
            }
        }
        return null;
    }


    /**
     * 根据velocity resource获取velocity template
     *
     * @param resource velocity template resource path
     **/
    public static Template getVelocityTemplateByResource(String resource,String encoding) {
        final VelocityEngine velocityEngine = getVelocityEngine();
        Template template = null;
        if (resource != null && (!"".equals(resource))) {
            //这里需要确定编码为UTF-8,由于项目的编码UTF-8普遍多,所以这边对编码进行确定
            if(encoding!=null&&(!"".equals(encoding))){
                //do nothing
            }else{
                encoding=CodeGeneratorConstants.DEFAULT_ENCODING;
            }
            template = velocityEngine.getTemplate(resource, encoding);
        }
        return template;
    }


    /**
     * Gets velocity context
     * **/
    public static VelocityContext getVelocityContext(){
        VelocityContext context=new VelocityContext();
        return context;
    }
}
