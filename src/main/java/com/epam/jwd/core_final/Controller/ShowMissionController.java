package com.epam.jwd.core_final.Controller;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.FlightMission;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class ShowMissionController implements Initializable {
    @FXML
    private TableView<FlightMission> missionTable;

    @FXML
    private TableColumn<FlightMission, String> nameColumn;

    @FXML
    private TableColumn<FlightMission, String> startColumn;

    @FXML
    private TableColumn<FlightMission, String> endColumn;

    @FXML
    private TableColumn<FlightMission, String> startPlanetColumn;

    @FXML
    private TableColumn<FlightMission, String> endPlanetColumn;

    @FXML
    private TableColumn<FlightMission, String> distanceColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<FlightMission> missions = FXCollections.observableArrayList();
        missions.addAll(BaseEntityStorage.GENERAL.getFlightMission());
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.startPlanetColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
        this.endPlanetColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
        this.distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));
        this.endColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        this.startColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        missionTable.setItems(missions);
    }
}
