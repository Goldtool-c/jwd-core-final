package com.epam.jwd.core_final.Controller;
import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.Planet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowMapController implements Initializable {

    @FXML
    private TableColumn<Planet, String> nameColumn;

    @FXML
    private TableColumn<Planet, String> xColumn;

    @FXML
    private TableColumn<Planet, String> yColumn;

    @FXML
    private TableView<Planet> planetTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Planet> planets = FXCollections.observableArrayList();
        planets.addAll(BaseEntityStorage.GENERAL.getPlanetStorage());
        this.xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        this.yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        planetTable.getColumns().add(xColumn);
        planetTable.getColumns().add(yColumn);
        planetTable.getColumns().add(nameColumn);
        planetTable.setItems(planets);
    }
}
