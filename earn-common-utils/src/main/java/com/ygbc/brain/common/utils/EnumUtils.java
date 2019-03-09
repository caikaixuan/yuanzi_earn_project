package com.ygbc.brain.common.utils;

import com.ygbc.brain.base.enums.BaseIntEnum;
import com.ygbc.brain.base.enums.BaseStrEnum;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

@SuppressWarnings("all")
public class EnumUtils {

    private static Logger logger = LoggerFactory.getLogger(EnumUtils.class);

    private static Map<String, Map<String, String>> strEnumMap = new HashMap<>();

    private static Map<String, Map<Integer, String>> intEnumMap = new HashMap<>();
    private String basePackage;
    private ClassLoader classLoader;

    public EnumUtils() {
        this.classLoader = getClass().getClassLoader();
    }

    public static void putStrMap(String enumType, Map<String, String> map) {
        strEnumMap.put(enumType, map);
    }

    public static void putIntMap(String enumType, Map<Integer, String> map) {
        intEnumMap.put(enumType, map);
    }

    public static String getDesc(String enumType, String value) {
        if (strEnumMap.containsKey(enumType)) {
            Map<String, String> valueMap = strEnumMap.get(enumType);
            if (valueMap.containsKey(value)) {
                return valueMap.get(value);
            }
        }
        return null;
    }

    public static String getDesc(String enumType, int value) {
        if (intEnumMap.containsKey(enumType)) {
            Map<Integer, String> valueMap = intEnumMap.get(enumType);
            if (valueMap.containsKey(value)) {
                return valueMap.get(value);
            }
        }
        return null;
    }

    public static boolean hasItem(String enumType, String value) {
        if (strEnumMap.containsKey(enumType)) {
            Map<String, String> valueMap = strEnumMap.get(enumType);
            if (valueMap.containsKey(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasItem(String enumType, int value) {
        if (intEnumMap.containsKey(enumType)) {
            Map<Integer, String> valueMap = intEnumMap.get(enumType);
            if (valueMap.containsKey(value)) {
                return true;
            }
        }
        return false;
    }

    public void scan() {
        try {
            String[] packages = this.getBasePackages();
            if (packages == null) {
                return;
            }
            for (String packageName : packages) {
                packageName = this.dotToSplash(packageName);
                Enumeration<URL> urls = classLoader.getResources(packageName);
                while (urls.hasMoreElements()) {
                    URL url = urls.nextElement();
                    String filePath = this.getRootPath(url);
                    if (isJarFile(filePath)) {
                        readFromJarFile(filePath, packageName);
                    } else {
                        readFromDirectory(filePath);
                    }
                }
            }

            if (!CollectionUtils.isEmpty(strEnumMap)) {
                for (String key : strEnumMap.keySet()) {
                    logger.info("加载枚举:{}", key);
                }
            }
            if (!CollectionUtils.isEmpty(intEnumMap)) {
                for (String key : intEnumMap.keySet()) {
                    logger.info("加载枚举:{}", key);
                }
            }
        } catch (Exception e) {
            logger.error("枚举加载失败", e);
        }
    }

    private void readFromJarFile(String jarPath, String splashedPackageName) {
        try {
            JarInputStream jarIn = new JarInputStream(new FileInputStream(jarPath));
            JarEntry entry = jarIn.getNextJarEntry();
            while (null != entry) {
                String name = entry.getName();
                if (name.toLowerCase().contains("enums") && isClassFile(name)) {
                    String className = splashToDot(name).replace(".class", "");
                    Class classz = Class.forName(className);
                    if (classz.isEnum()) {
                        dealInterface(classz);
                    }
                }
                entry = jarIn.getNextJarEntry();
            }
        } catch (Exception e) {
            logger.error("读取Jar包异常", e);
        }
    }

    private void readFromDirectory(String path) throws Exception {
        File file = new File(path);
        String[] names = file.list();
        if (null == names) {
            return;
        }
        for (String name : names) {
            File f = new File(FilenameUtils.concat(path, name));
            if (f.isDirectory()) {
                readFromDirectory(f.getAbsolutePath());
            } else {
                if (!path.toLowerCase().contains("enums")) {
                    continue;
                }
                if (!this.isClassFile(name)) {
                    continue;
                }
                Class classz = Class.forName(FilenameUtils.concat(path, name));
                if (classz.isEnum()) {
                    dealInterface(classz);
                }
            }
        }
    }

    private void dealInterface(Class classz) throws Exception {
        Class<?>[] iters = classz.getInterfaces();
        for (Class c : iters) {
            String className = c.getName();
            String className1 = BaseStrEnum.class.getName();
            String className2 = BaseIntEnum.class.getName();
            if (className.equals(className1)) {
                Method method = classz.getMethod("values");
                BaseStrEnum inter[] = (BaseStrEnum[]) method.invoke(null, null);
                Map<String, String> map = new HashMap<>();
                for (BaseStrEnum e : inter) {
                    map.put(e.getValue(), e.getDesc());
                }
                putStrMap(classz.getSimpleName(), map);
            } else if (className.equals(className2)) {
                Method method = classz.getMethod("values");
                BaseIntEnum inter[] = (BaseIntEnum[]) method.invoke(null, null);
                Map<Integer, String> map = new HashMap<>();
                for (BaseIntEnum e : inter) {
                    map.put(e.getValue(), e.getDesc());
                }
                putIntMap(classz.getSimpleName(), map);
            }
        }
    }

    private String[] getBasePackages() {
        if (StringUtils.isNotBlank(this.basePackage)) {
            logger.info("EnumScanner将扫描:{}", this.basePackage);
            return this.basePackage.split(",");
        }
        return null;
    }

    private String dotToSplash(String name) {
        return name.replaceAll("\\.", "/");
    }

    private String splashToDot(String name) {
        return name.replaceAll("/", "\\.");
    }

    private boolean isClassFile(String name) {
        return name.endsWith(".class");
    }

    private boolean isJarFile(String name) {
        return name.endsWith(".jar");
    }

    private String getRootPath(URL url) {
        String fileUrl = url.getFile();
        int pos = fileUrl.indexOf('!');

        if (-1 == pos) {
            return fileUrl;
        }

        fileUrl = fileUrl.substring(5, pos);
        fileUrl = StringUtils.replace(fileUrl, "%7B", "{");
        fileUrl = StringUtils.replace(fileUrl, "%7D", "}");
        return fileUrl;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
