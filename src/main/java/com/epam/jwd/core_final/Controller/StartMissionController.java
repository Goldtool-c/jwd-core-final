package com.epam.jwd.core_final.Controller;

import com.epam.jwd.core_final.Application.ButtonEvents;
import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.Repository.PlanetTemp;
import com.epam.jwd.core_final.domain.MissionFabric;
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

    @FXML
    private Label dateStart;

    @FXML
    private Button datePlus;

    @FXML
    private Button dateMinus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name1 = planetStart.getText();
        String name2 = planetEnd.getText();
        start.setOnAction(event -> ButtonEvents.GENERAL.startPlanetEvent(
        ));
        finish.setOnAction(event -> ButtonEvents.GENERAL.finishPlanetEvent());
        setAll.setOnAction(event-> ButtonEvents.GENERAL.setAllEvent(name1, name2, planetStart, planetEnd, shipname, dateStart));
        confirm.setOnAction(event -> {
            BaseEntityStorage.GENERAL.addMission(MissionFabric.INSTANCE.create(
                    PlanetTemp.GENERAL.getFromP(),PlanetTemp.GENERAL.getToP(),PlanetTemp.GENERAL.getSpaceship(), dateStart.getText()));
        });
        datePlus.setOnAction(event -> ButtonEvents.GENERAL.datePlusEvent(dateStart));
        dateMinus.setOnAction(event -> ButtonEvents.GENERAL.dateMinusEvent(dateStart));
    }
}
