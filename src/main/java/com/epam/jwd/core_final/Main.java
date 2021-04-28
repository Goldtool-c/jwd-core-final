package com.epam.jwd.core_final;

import com.epam.jwd.core_final.Application.Init;
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
    @Override
    public void start(Stage primaryStage) {
        Init.GENERAL.init(primaryStage);
    }
    public static void main(String[] args) {
        javafx.application.Application.launch(args);

    }
}