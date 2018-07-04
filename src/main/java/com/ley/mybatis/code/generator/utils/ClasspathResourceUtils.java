package com.ley.mybatis.code.generator.utils;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取classpath的文件资源
 **/
public class ClasspathResourceUtils {

    /**
     * 获取({@link ClassLoader})
     **/
    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();


    /**
     * 根据资源名在类路径下寻找资源
     *
     * @param resource 资源名
     * @return {@link InputStream}.如果没有找到资源时,返回{@code null};如果找到了资源,返回{@link InputStream}
     **/
    public static InputStream getInputStream(String resource) {
        InputStream inputStream = classLoader.getResourceAsStream(resource);
        if (inputStream != null) {
            return inputStream;
        } else {
            return null;
        }
    }


    /**
     * 判断classpath路径下是否含有资源名为resource的资源
     *
     * @param resource 资源名
     * @return 当在类路径下寻找到资源时, 返回{{@code true}};否则返回{{@code false}}
     **/
    public static boolean containsResource(String resource) {
        return getInputStream(resource) == null ? false : true;
    }


    /**
     * 根据资源名在类路径下寻找资源
     *
     * @param resources 资源名数组
     * @return 返回classpath存在的资源,{{@link Map}},其中key值是存在资源名,value值是{{@link InputStream}};如果没有,返回{@code null}
     **/
    public static Map<String, InputStream> getInputStreams(String... resources) {
        Map<String, InputStream> inputStreams = new HashMap<>();
        if (resources != null && resources.length > 0) {
            for (String resource : resources) {
                if (containsResource(resource)) {
                    inputStreams.put(resource, getInputStream(resource));
                }
            }
        }
        if (inputStreams.size() > 0) {
            return inputStreams;
        } else {
            return null;
        }
    }


    /**
     * 获取current project name
     * **/
    @Deprecated
    public static String getCurrentProjectName(){
        String userDir=System.getProperty("user.dir");
        String currentProject=userDir.substring(userDir.lastIndexOf("\\")+1);
        return currentProject;
    }
}
