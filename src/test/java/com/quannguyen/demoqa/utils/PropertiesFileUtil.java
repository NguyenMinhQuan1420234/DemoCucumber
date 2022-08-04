package com.quannguyen.demoqa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtil {
    private static final Logger LOGGER = LogManager.getLogger(PropertiesFileUtil.class);

    public static Properties readProperties(String filePath) throws IOException {
        LOGGER.info("Load Properties file {}", filePath);
        try (InputStream input = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        }
    }

    public static void writeProperties(Properties properties) {
        LOGGER.info("Append System Properties from properties file {}", properties);
        for (String name: properties.stringPropertyNames()) {
            String value = properties.getProperty(name);
            System.setProperty(name, value);
        }
    }
}
