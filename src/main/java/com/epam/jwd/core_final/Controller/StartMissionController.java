package com.epam.jwd.core_final.Controller;

import com.epam.jwd.core_final.Application.ButtonEvents;
import com.epam.jwd.core_final.domain.PlanetTemp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StartMissionController implements Initializable {

        @FXML
        private Button start;

        @FXML
        private Button finish;

        @FXML
        private Label shipname;

        @FXML
        private Label planetStart;

        @FXML
        private Label planetEnd;

        @FXML
        private Button confirm;
        @FXML
        private Button setAll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name1 = planetStart.getText();
        String name2 = planetEnd.getText();
        start.setOnAction(event -> ButtonEvents.GENERAL.startPlanetEvent(
        ));
        finish.setOnAction(event -> ButtonEvents.GENERAL.finishPlanetEvent());
        setAll.setOnAction(event->
        {
            planetStart.setText(name1 + " " + PlanetTemp.GENERAL.getFrom());
            planetEnd.setText(name2 + " " + PlanetTemp.GENERAL.getTo());
        });
    }
}
