package com.epam.jwd.core_final;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.converter.ConverterStringToCrewMember;
import com.epam.jwd.core_final.converter.ConverterStringToSpaceMap;
import com.epam.jwd.core_final.converter.ConverterStringToSpaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends javafx.application.Application {
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
        File file = new File(".\\src\\main\\resources\\input\\crew");
        try {
            BaseEntityStorage.GENERAL.setCrewStorage(ConverterStringToCrewMember.GENERAL.convert(file));
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
        file = new File(".\\src\\main\\resources\\input\\spaceships");
        BaseEntityStorage.GENERAL.setShipStorage(ConverterStringToSpaceship.GENERAL.convert(file));
        file = new File(".\\src\\main\\resources\\input\\spacemap");
        BaseEntityStorage.GENERAL.setPlanetStorage(ConverterStringToSpaceMap.GENERAL.convert(file));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        javafx.application.Application.launch(args);

    }
}