package com.epam.jwd.core_final.Thread;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MyThread extends Thread {
    @Override
    public void run() {
        Parent root = null;
        try {
            System.out.println(getClass().getResource("src/mainSample.fxml"));
            URL url = new URL("file:///D:/ENG/jwd-core-final/src/main/java/com/epam/jwd/core_final/Thread/mainSample.fxml");
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 450, 600));
        System.out.println("hui");
        primaryStage.show();
    }
}
