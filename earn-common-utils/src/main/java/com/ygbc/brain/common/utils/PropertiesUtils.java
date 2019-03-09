package com.ygbc.brain.common.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties文件操作类
 */
public class PropertiesUtils {

    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private String[] fileNames;

    private PropertiesUtils() {
    }

    /**
     * @param key
     * @return String 返回类型
     * @throws
     * @Title: getValue
     * @Description: 通过key获取属性文件的值
     */
    public static String getValue(String key) {
        if (properties.containsKey(key)) {
            String value = properties.getProperty(key);// 得到某一属性的值
            if (value == null) {
                return "";
            } else {
                return value;
            }
        } else {
            return "";
        }
    }

    /**
     * 通过key获取属性文件中类型为int的值
     */
    public static int getIntValue(String key){
        if (properties.containsKey(key)) {
            String value = properties.getProperty(key);// 得到某一属性的值
            if (value == null) {
                return -1;
            } else {
                return Integer.valueOf(value);
            }
        } else {
            return -1;
        }
    }

    /**
     * @param @throws Exception 设定文件
     * @return void 返回类型
     * @throws
     * @Title: load
     */
    public void load() throws Exception {
        if (fileNames.length == 0) {
            return;
        }
        for (String filename : fileNames) {
            String path = StringUtils.substringAfter(filename, ":");
            InputStream in = null;
            try {
                if (filename.startsWith("classpath")) {
                    in = this.getClass().getClassLoader().getResourceAsStream(path);
                    properties.load(in);
                } else if (filename.startsWith("file")) {
                    in = new FileInputStream(path);
                    properties.load(in);
                } else {
                    logger.error("不支持的前缀类型:" + path);
                }
            } catch (IOException e) {
                logger.error("文件加载失败", e);
            } finally {
                IOUtils.closeQuietly(in);
            }
        }
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }
}
