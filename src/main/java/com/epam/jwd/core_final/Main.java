package com.epam.jwd.core_final;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.converter.*;
import com.epam.jwd.core_final.domain.ApplicationProperties;
import com.epam.jwd.core_final.exception.InvalidStateException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Main extends javafx.application.Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            File sample = new File(".\\src\\main\\java\\com\\epam\\jwd\\core_final\\mainSample.fxml");
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Main stage initialized");
        LOGGER.info("Application properties loaded");
        File file = new File(".\\src\\main\\resources\\"+ApplicationProperties.GENERAL.input()+"\\"+ ApplicationProperties.GENERAL.crewFileName());
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
    public static void main(String[] args) {
        javafx.application.Application.launch(args);

    }
}