package com.epam.jwd.core_final.Controller;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowItemController implements Initializable {
    @FXML
    private AnchorPane ShowItem;

    @FXML
    private TableView<AbstractBaseEntity> ItemTable;
    @FXML
    private TableColumn<AbstractBaseEntity, String> RoleColumn;

    @FXML
    private TableColumn<AbstractBaseEntity, String> NameColumn;

    @FXML
    private TableColumn<AbstractBaseEntity, String> RankColumn;

    @Override
    public void initialize(URL Ur1, ResourceBundle rb) {
        ObservableList<AbstractBaseEntity> crews = FXCollections.observableArrayList();
        crews.addAll(BaseEntityStorage.GENERAL.getCrewStorage());
        this.RoleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        this.NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.RankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        ItemTable.getColumns().add(RoleColumn);
        ItemTable.getColumns().add(NameColumn);
        ItemTable.getColumns().add(RankColumn);
        ItemTable.setItems(crews);
    }
}
