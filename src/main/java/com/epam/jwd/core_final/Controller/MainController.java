package com.epam.jwd.core_final.Controller;

import com.epam.jwd.core_final.Application.ButtonEvents;
import com.epam.jwd.core_final.Application.Events;
import com.epam.jwd.core_final.Repository.PlanetTemp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private AnchorPane Anchor;

    @FXML
    private ComboBox<String> ShowAll;

    @FXML
    private Button startNewMission;

    @FXML
    private Button plusDate;
    @FXML
    private Label currentDate;
    @FXML
    private Button saveMission;
    @Override
    public void initialize(URL Ur1, ResourceBundle rb)
    {
        saveMission.setOnAction(event -> ButtonEvents.GENERAL.saveMissionEvent());
        ObservableList<String> options = FXCollections.observableArrayList("CrewMembers", "Spaceships", "Planet map", "Missions");
        ShowAll.setItems(options);
        currentDate.setText(LocalDate.now().toString());
        PlanetTemp.GENERAL.setCurrentDate(LocalDate.now());
        plusDate.setOnAction(event -> ButtonEvents.GENERAL.currentDatePlusEvent(currentDate));
        ShowAll.setOnAction(event ->
        {
            switch (ShowAll.getValue()) {
                case "CrewMembers": {Events.GENERAL.ShowAllCrewEvent(ShowAll);break;}
                case "Spaceships": {Events.GENERAL.ShowAllSpaceshipEvent(ShowAll);break;}
                case "Planet map": {Events.GENERAL.ShowSpaceMap(ShowAll);break;}
                case "Missions": {Events.GENERAL.ShowMissions();break;}
            }
        });
        startNewMission.setOnAction(event -> ButtonEvents.GENERAL.startMissionEvent());
    }

}

