package com.epam.jwd.core_final.Application;

import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.Repository.TempValues;
import com.epam.jwd.core_final.converter.ConverterMissionToString;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.util.DateOperations;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    public void setAllEvent(String name1, String name2, Label planetStart, Label planetEnd, Label shipName, Label date)
    {
        date.setText(TempValues.GENERAL.getCurrentDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        planetStart.setText(name1 + " " + TempValues.GENERAL.getFrom());
        planetEnd.setText(name2 + " " + TempValues.GENERAL.getTo());
        ArrayList<Spaceship> temp = BaseEntityStorage.GENERAL.getShipStorage();
        ArrayList<Planet> temp1 = BaseEntityStorage.GENERAL.getPlanetStorage();
        Planet to = null, from = null;
        for (int i = 0; i < temp1.size(); i++) {
            if(TempValues.GENERAL.getFrom().equals(temp1.get(i).getName()))
            {
                from=temp1.get(i);
                TempValues.GENERAL.setFromP(temp1.get(i));
            }
            if((TempValues.GENERAL.getTo().equals(temp1.get(i).getName())))
            {
                to=temp1.get(i);
                TempValues.GENERAL.setToP(temp1.get(i));
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
                TempValues.GENERAL.setSpaceship(temp.get(i));
                shipName.setText(temp.get(i).getName());
            }
        }
    }
    public void datePlusEvent(Label dat)
    {
        int[] date=DateOperations.GENERAL.StringToDate(dat.getText());
        date[0]++;
        if(date[1]==1||date[1]==3||date[1]==5||date[1]==7||date[1]==8||date[1]==10||date[1]==12)
        {
            if(date[0]>31)
            {
                date[0]=1;
                date[1]++;
            }
        } else if(date[1]==2)
        {
            if(date[0]>28)
            {date[0]=1; date[1]++;}
        } else
        {
            if(date[0]>30)
            {date[0]=1; date[1]++;}
        }
        if(date[1]>12){date[1]=1; date[2]++;}

        dat.setText(DateOperations.GENERAL.dateToString(date));
    }
    public void dateMinusEvent(Label label)
    {
        int[] date=DateOperations.GENERAL.StringToDate(label.getText());
        date[0]--;
        if(date[0]==0)
        {
            if(date[1]==1){ date[0]=31; date[1]=12; date[2]--;}
            if(date[1]==2||date[1]==4||date[1]==6||date[1]==8||date[1]==9||date[1]==11) { date[0]=31; date[1]--; }
            if(date[1]==3){date[0]=28; date[1]--;}
            if(date[1]==5||date[1]==7||date[1]==10||date[1]==12){date[0]=30; date[1]--;}
        }
        LocalDate date1=LocalDate.of(date[2], date[1], date[0]);
        LocalDate date2= TempValues.GENERAL.getCurrentDate();
        if(date1.isAfter(date2))
        {
            label.setText(DateOperations.GENERAL.dateToString(date));
        }
    }
    public void currentDatePlusEvent(Label label)
    {
        label.setText(TempValues.GENERAL.getCurrentDate().plusDays(1).toString());
        TempValues.GENERAL.setCurrentDate(TempValues.GENERAL.getCurrentDate().plusDays(1));
        ArrayList<FlightMission> flightMissions=BaseEntityStorage.GENERAL.getFlightMission();
        for (int i = 0; i <flightMissions.size() ; i++) {
            if(flightMissions.get(i).getEndDate1().toString().equals(label.getText()))
            {
                Stage stage=new Stage();
                AnchorPane root = new AnchorPane();
                Label nameLabel=new Label();
                nameLabel.setText(flightMissions.get(i).getName());
                Label resultLabel = new Label();
                AnchorPane.setLeftAnchor(nameLabel, 0.0);
                AnchorPane.setRightAnchor(nameLabel, 0.0);
                AnchorPane.setLeftAnchor(resultLabel, 0.0);
                AnchorPane.setRightAnchor(resultLabel, 0.0);
                nameLabel.setAlignment(Pos.CENTER);
                resultLabel.setAlignment(Pos.CENTER);
                nameLabel.setStyle("-fx-font-size: 14px");
                resultLabel.setStyle("-fx-font-size: 14px");
                resultLabel.relocate(nameLabel.getLayoutX(), nameLabel.getLayoutY()+20);
                if(Math.random()>0.75)
                {
                    resultLabel.setText("Mission failed");
                    resultLabel.setStyle("-fx-background-color: red; -fx-font-size: 14px");
                } else
                {
                    resultLabel.setText("Mission completed successfully");
                    resultLabel.setStyle("-fx-background-color: green; -fx-font-size: 14px");
                    List<CrewMember> crew = flightMissions.get(i).getAssignedCrew();
                    flightMissions.get(i).getAssignedSpaceShip().setReadyForNextMissions(true);
                    for (int j = 0; j < crew.size(); j++) {
                        crew.get(i).setReady(true);
                    }
                }
                root.getChildren().addAll(nameLabel, resultLabel);
                stage.setScene(new Scene(root,250, 80));
                stage.show();
            }
        }
    }
    public void saveMissionEvent()
    {
        String missions = ConverterMissionToString.GENERAL.convert();
        String appPath=".\\src\\main\\resources\\application.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter writer = new FileWriter(".\\src\\main\\resources\\input\\"+appProps.getProperty("missionsFileName"), false))
        {
            writer.write(missions);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
