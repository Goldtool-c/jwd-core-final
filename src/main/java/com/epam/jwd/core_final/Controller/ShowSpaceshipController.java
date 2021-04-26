package com.epam.jwd.core_final.Controller;
import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.Spaceship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowSpaceshipController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TableView<Spaceship> shipTable;
    @FXML
    private TableColumn<Spaceship, String> nameColumn;

    @FXML
    private TableColumn<Spaceship, String> distanceColumn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Spaceship> ships = FXCollections.observableArrayList();
        ships.addAll(BaseEntityStorage.GENERAL.getShipStorage());
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.distanceColumn.setCellValueFactory(new PropertyValueFactory<>("flightDistance"));
        shipTable.getColumns().add(nameColumn);
        shipTable.getColumns().add(distanceColumn);
        shipTable.setItems(ships);
    }
}

