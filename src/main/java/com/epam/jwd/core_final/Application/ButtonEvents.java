package com.epam.jwd.core_final.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public enum ButtonEvents {
    GENERAL;
    public void startMissionEvent()
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\StartMission.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 279, 400));
        primaryStage.show();
    }
    public void startPlanetEvent()
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ChoosePlanetStart.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 330, 400));
        primaryStage.show();
    }
    public void finishPlanetEvent()
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ChoosePlanetTo.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 330, 400));
        primaryStage.show();
    }
}
