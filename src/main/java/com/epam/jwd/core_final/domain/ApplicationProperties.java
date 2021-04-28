package com.epam.jwd.core_final.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class should be IMMUTABLE!
 * <p>
 * Expected fields:
 * <p>
 * inputRootDir {@link String} - base dir for all input files
 * outputRootDir {@link String} - base dir for all output files
 * crewFileName {@link String}
 * missionsFileName {@link String}
 * spaceshipsFileName {@link String}
 * <p>
 * fileRefreshRate {@link Integer}
 * dateTimeFormat {@link String} - date/time format for {@link java.time.format.DateTimeFormatter} pattern
 */
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
    public String input()
    {
        return this.prop().getProperty("inputRootDir");
    }
    public String crewFileName()
    {
        return this.prop().getProperty("crewFileName");
    }
    public String missionsFileName()
    {
        return this.prop().getProperty("missionsFileName");
    }
    public String spaceshipFileName()
    {
        return this.prop().getProperty("spaceshipsFileName");
    }
    public String planetMapFilename()
    {
        return this.prop().getProperty("planetMapFilename");
    }
}
