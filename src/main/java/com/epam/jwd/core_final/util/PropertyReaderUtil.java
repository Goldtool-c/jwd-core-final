package com.epam.jwd.core_final.util;

import com.epam.jwd.core_final.domain.ApplicationProperties;

import java.util.Properties;

public final class PropertyReaderUtil {

    private static final Properties properties = new Properties();

    private PropertyReaderUtil() {
    }

    public static void loadProperties() {
        final String propertiesFileName = "resource/application.properties";

    }
}
