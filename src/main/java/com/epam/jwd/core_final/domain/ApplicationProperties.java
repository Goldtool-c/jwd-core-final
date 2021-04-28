package com.epam.jwd.core_final.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public enum  ApplicationProperties {
    GENERAL;
    private Properties prop()
    {
        String appPath=".\\src\\main\\resources\\application.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appPath));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return appProps;
    };
    public final String input()
    {
        return this.prop().getProperty("inputRootDir");
    }
    public final String crewFileName()
    {
        return this.prop().getProperty("crewFileName");
    }
    public final String missionsFileName()
    {
        return this.prop().getProperty("missionsFileName");
    }
    public final String spaceshipFileName()
    {
        return this.prop().getProperty("spaceshipsFileName");
    }
    public final String planetMapFilename()
    {
        return this.prop().getProperty("planetMapFilename");
    }
}
