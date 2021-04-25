package com.epam.jwd.core_final.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private AnchorPane Anchor;

    @FXML
    private ComboBox<String> ShowAll;

    @FXML
    private Button startNewMission;
    @Override
    public void initialize(URL Ur1, ResourceBundle rb)
    {
        ObservableList<String> options = FXCollections.observableArrayList("CrewMembers", "Spaceships", "Planet map", "Missions");
        ShowAll.setItems(options);
    }

}

