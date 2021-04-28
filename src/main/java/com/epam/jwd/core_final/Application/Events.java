package com.epam.jwd.core_final.Application;
import com.epam.jwd.core_final.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public enum Events {
    GENERAL;
    private static final Logger LOGGER = LoggerFactory.getLogger(Events.class);
    public void ShowAllCrewEvent(ComboBox<String> ShowAll) {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowItem.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/" + sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Crewmate Table");
        primaryStage.setScene(new Scene(root, 440, 400));
        primaryStage.show();
        LOGGER.info("Crew mate table initialized");
    }

    public void ShowAllSpaceshipEvent(ComboBox<String> ShowAll) {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowSpaceships.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/" + sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Spaceship Table");
        primaryStage.setScene(new Scene(root, 380, 400));
        LOGGER.info("Spaceship stage initialized");
        primaryStage.show();

    }

    public void ShowSpaceMap(ComboBox<String> ShowAll) {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowMap.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/" + sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Planet table");
        primaryStage.setScene(new Scene(root, 330, 400));
        LOGGER.info("Planet table stage initialized");
        primaryStage.show();
    }

    public void ShowMissions() {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowMissions.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/" + sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Missions table");
        primaryStage.setScene(new Scene(root, 658, 400));
        primaryStage.show();
        LOGGER.info("Mission table stage initialized");
    }
}
