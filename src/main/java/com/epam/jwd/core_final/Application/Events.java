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
    public void ShowAllEvent(ComboBox<String> ShowAll)
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
}
