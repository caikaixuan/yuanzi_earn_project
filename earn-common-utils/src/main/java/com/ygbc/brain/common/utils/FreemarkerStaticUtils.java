package com.ygbc.brain.common.utils;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("deprecation")
public class FreemarkerStaticUtils extends HashMap<Object, Object> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static FreemarkerStaticUtils FREEMARKER_STATIC_MODELS;
    private Properties staticModels;

    private FreemarkerStaticUtils() {

    }

    public static FreemarkerStaticUtils getInstance() {
        if (FREEMARKER_STATIC_MODELS == null) {
            FREEMARKER_STATIC_MODELS = new FreemarkerStaticUtils();
        }
        return FREEMARKER_STATIC_MODELS;
    }

    public static TemplateHashModel useStaticPackage(String packageName) {
        try {
            BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
            TemplateHashModel staticModels = wrapper.getStaticModels();
            TemplateHashModel fileStatics = (TemplateHashModel) staticModels.get(packageName);
            return fileStatics;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Properties getStaticModels() {
        return staticModels;
    }

    public void setStaticModels(Properties staticModels) {
        if (this.staticModels == null && staticModels != null) {
            this.staticModels = staticModels;
            Set<String> keys = this.staticModels.stringPropertyNames();
            for (String key : keys) {
                FREEMARKER_STATIC_MODELS.put(key, useStaticPackage(this.staticModels.getProperty(key)));
            }
        }
    }

}