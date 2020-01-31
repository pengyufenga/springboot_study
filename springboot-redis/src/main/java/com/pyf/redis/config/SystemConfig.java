/**
 * @(#)SystemProperties.java, 7/12/2018.
 * <p/>
 * Copyright 2018 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.pyf.redis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 系统参数配置类
 */
@PropertySource(value = {
        "classpath:config/${spring.profiles.active}/druid.properties",
        "classpath:config/${spring.profiles.active}/redis.properties",
        "classpath:config/${spring.profiles.active}/system.properties"})
@Configuration
@MapperScan("com.pyf.bussiness.mapper")
public class SystemConfig {

}
