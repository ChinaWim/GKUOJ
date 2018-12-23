package com.oj.gkuoj.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author m969130721@163.com
 * @date 18-9-17 上午11:13
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;

    static {
        String fileName = "wowomall.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常", e);
        }
    }

    public static String getProperty(String key) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key, String defaultValue) {

        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }

    public static Integer getPropertyAsInt(String key){
        String valueStr = props.getProperty(key.trim());
        if (StringUtils.isBlank(valueStr)) {
            return 0;
        }
        try{
            Integer value = Integer.parseInt(valueStr);
            return value;
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static Integer getPropertyAsInt(String key, Integer defaultValue){
        String valueStr = props.getProperty(key.trim());
        if (StringUtils.isBlank(valueStr)) {
            return defaultValue;
        }
        try{
            Integer value = Integer.parseInt(valueStr);
            return value;
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    public static Long getPropertyAsLong(String key){
        String valueStr = props.getProperty(key.trim());
        if (StringUtils.isBlank(valueStr)) {
            return 0L;
        }
        try{
            Long value = Long.parseLong(valueStr);
            return value;
        }catch (NumberFormatException e){
            return 0L;
        }
    }


    public static Long getPropertyAsLong(String key, Long defaultValue){
        String valueStr = props.getProperty(key.trim());
        if (StringUtils.isBlank(valueStr)) {
            return defaultValue;
        }
        try{
            Long value = Long.parseLong(valueStr);
            return value;
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }


}
