package com.ley.mybatis.code.generator.velocity.constants;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Velocity Constants
 **/
public final class VelocityConstants {

    /**
     * read velocity resource prefix
     **/
    public static final String RESOURCE_PREFIX = "classpath";

    /**
     * velocity resource loader class
     * **/
    public static final Class<?> RESOURCE_LOADER_CLASS= ClasspathResourceLoader.class;


    /**
     * velocity resource loader property
     * **/
    public static final String RESOURCE_LOADER_CLASS_PREFIX="classpath.resource.loader.class";
}
