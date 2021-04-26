package com.epam.jwd.core_final.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public enum Events {
    GENERAL;
    public void ShowAllCrewEvent(ComboBox<String> ShowAll)
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowItem.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 440, 400));
        primaryStage.show();
    }
    public void ShowAllSpaceshipEvent(ComboBox<String> ShowAll)
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowSpaceships.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 380, 400));
        primaryStage.show();
    }
    public void ShowSpaceMap(ComboBox<String> ShowAll)
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ShowMap.fxml");
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
