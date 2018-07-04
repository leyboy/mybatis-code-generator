package com.ley.mybatis.code.generator.velocity.handler;

import org.apache.velocity.VelocityContext;

/**
 * Velocity callback
 * **/
public interface VelocityCallback {

    /**
     * Do in velocity context
     *
     * **/
    void doInVelocityContext(VelocityContext context);
}
