/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygbc.brain.common.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Byte
 */
public class YamlUtils {
    public YamlUtils() {

    }

    public <T extends Object> T loadAs(String fileName, Class<T> type) {
        InputStream inputStream = null;
        try {
            inputStream = getClassLoader().getResourceAsStream(fileName);        // properties.load(Prop.class.getResourceAsStream(fileName));
            if (inputStream == null) {
                throw new IllegalArgumentException("yaml file not found in classpath: " + fileName);
            }
            Yaml yaml = new Yaml();

            T entities = yaml.loadAs(inputStream, type);
            return entities;
        } catch (Exception e) {
            return null;
        } finally {
            if (inputStream != null) try {
                inputStream.close();
            } catch (IOException e) {
                return null;
            }
        }
    }

    private ClassLoader getClassLoader() {
        ClassLoader ret = Thread.currentThread().getContextClassLoader();
        return ret != null ? ret : getClass().getClassLoader();
    }

}
