package com.epam.jwd.core_final.Controller;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.Repository.PlanetTemp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoosePlanetStartController implements Initializable {
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
        planetTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    @SuppressWarnings("rawtypes")
                    TablePosition pos = planetTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    int col = pos.getColumn();
                    @SuppressWarnings("rawtypes")
                    TableColumn column = pos.getTableColumn();
                    String val = column.getCellData(row).toString();
                    PlanetTemp.GENERAL.setFrom(val);
                    System.out.println(PlanetTemp.GENERAL.getFrom());
                }
            }
        });
        planetTable.getColumns().add(xColumn);
        planetTable.getColumns().add(yColumn);
        planetTable.getColumns().add(nameColumn);
        planetTable.setItems(planets);
    }
}
