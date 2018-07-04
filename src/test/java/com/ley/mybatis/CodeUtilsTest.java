package com.ley.mybatis;

import com.ley.mybatis.code.generator.CodeUtils;
import org.junit.Test;

import java.io.IOException;

public class CodeUtilsTest {

    @Test
    public void testGenerateMybatisGeneratorConfigXML() throws IOException {
        CodeUtils.generateMybatisGeneratorConfigXML("datasource.properties","config/code-generator.properties",null);
    }
}
