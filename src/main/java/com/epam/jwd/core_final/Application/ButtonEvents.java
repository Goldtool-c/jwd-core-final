package com.epam.jwd.core_final.Application;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.Repository.PlanetTemp;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public enum ButtonEvents {
    GENERAL;
    public void startMissionEvent()
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\StartMission.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 279, 400));
        primaryStage.show();
    }
    public void startPlanetEvent()
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ChoosePlanetStart.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 330, 400));
        primaryStage.show();
    }
    public void finishPlanetEvent()
    {
        File sample = new File(".\\src\\main\\resources\\frameSample\\ChoosePlanetTo.fxml");
        Parent root = null;
        try {
            URL url = new URL("file:/"+sample.getAbsolutePath());
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 330, 400));
        primaryStage.show();
    }
    public void setAllEvent(String name1, String name2, Label planetStart, Label planetEnd, Label shipName)
    {
        planetStart.setText(name1 + " " + PlanetTemp.GENERAL.getFrom());
        planetEnd.setText(name2 + " " + PlanetTemp.GENERAL.getTo());
        ArrayList<Spaceship> temp = BaseEntityStorage.GENERAL.getShipStorage();
        ArrayList<Planet> temp1 = BaseEntityStorage.GENERAL.getPlanetStorage();
        Planet to = null, from = null;
        for (int i = 0; i < temp1.size(); i++) {
            if(PlanetTemp.GENERAL.getFrom().equals(temp1.get(i).getName()))
            {
                from=temp1.get(i);
                PlanetTemp.GENERAL.setFromP(temp1.get(i));
            }
            if((PlanetTemp.GENERAL.getTo().equals(temp1.get(i).getName())))
            {
                to=temp1.get(i);
                PlanetTemp.GENERAL.setToP(temp1.get(i));
            }
        }
        int k1,k2;
        double d;
        k1=(from.getX()-to.getX())*(from.getX()-to.getX());
        k2=(from.getY()-to.getY())*(from.getY()-to.getY());
        d=Math.sqrt(k1+k2);
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getReady()&&temp.get(i).getFlightDistance()>d)
            {
                PlanetTemp.GENERAL.setSpaceship(temp.get(i));
                shipName.setText(temp.get(i).getName());
            }
        }
    }
}
