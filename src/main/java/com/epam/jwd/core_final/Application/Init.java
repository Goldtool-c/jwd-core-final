package com.epam.jwd.core_final.Application;

import com.epam.jwd.core_final.Main;
import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.converter.ConverterStringToCrewMember;
import com.epam.jwd.core_final.converter.ConverterStringToMission;
import com.epam.jwd.core_final.converter.ConverterStringToSpaceMap;
import com.epam.jwd.core_final.converter.ConverterStringToSpaceship;
import com.epam.jwd.core_final.domain.ApplicationProperties;
import com.epam.jwd.core_final.exception.InvalidStateException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public enum Init {
    GENERAL;
    private static final Logger LOGGER = LoggerFactory.getLogger(Init.class);
    public void init(Stage primaryStage)
    {
        Parent root = null;
        try {
            File sample = new File(".\\src\\main\\resources\\frameSample\\mainSample.fxml");
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Main stage initialized");
        LOGGER.info("Application properties loaded");
        File file = new File(".\\src\\main\\resources\\"+ ApplicationProperties.GENERAL.input()+"\\"+ ApplicationProperties.GENERAL.crewFileName());
        try {
            BaseEntityStorage.GENERAL.setCrewStorage(ConverterStringToCrewMember.GENERAL.convert(file));
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
        LOGGER.info("Crewmate storage initialized");
        file = new File(".\\src\\main\\resources\\"+ApplicationProperties.GENERAL.input()+"\\"+ApplicationProperties.GENERAL.spaceshipFileName());
        BaseEntityStorage.GENERAL.setShipStorage(ConverterStringToSpaceship.GENERAL.convert(file));
        LOGGER.info("Spaceship storage initialized");
        file = new File(".\\src\\main\\resources\\"+ApplicationProperties.GENERAL.input()+"\\"+ApplicationProperties.GENERAL.planetMapFilename());
        BaseEntityStorage.GENERAL.setPlanetStorage(ConverterStringToSpaceMap.GENERAL.convert(file));
        LOGGER.info("Planet storage initialized");
        file = new File(".\\src\\main\\resources\\"+ApplicationProperties.GENERAL.input()+"\\"+ApplicationProperties.GENERAL.missionsFileName());
        BaseEntityStorage.GENERAL.setFlightMission(ConverterStringToMission.GENERAL.convert(file));
        LOGGER.info("Mission storage initialized");
        primaryStage.setTitle("Nasa");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
