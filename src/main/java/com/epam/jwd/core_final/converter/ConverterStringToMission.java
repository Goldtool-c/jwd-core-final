package com.epam.jwd.core_final.converter;
import com.epam.jwd.core_final.Repository.BaseEntityStorage;
import com.epam.jwd.core_final.criteria.PlanetCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.MissionFabric;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.util.DateOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public enum ConverterStringToMission {
    GENERAL;
    private LinkedList<String> fileToString(File file)
    {
        LinkedList<String> strings = new LinkedList<>();
        try(FileInputStream fin=new FileInputStream(file))
        {
            int i=-1;
            StringBuilder sb = new StringBuilder();
            while((i=fin.read())!=-1){
                sb.append((char) i);
                if((char)i==';'){
                    strings.add(sb.toString());
                    sb=new StringBuilder();
                }
            }
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
        return strings;
    }
    private LocalDate stringToDate(String string)
    {
        int n[]= new int[3];
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <string.length() ; i++) {
            if(string.charAt(i)!='-')
            {
             sb.append(string.charAt(i));
            } else {
                n[counter]=Integer.parseInt(sb.toString());
                sb=new StringBuilder(); counter++;
            }
        }
        n[2]=Integer.parseInt(sb.toString());
        return LocalDate.of(n[0], n[1], n[2]);
    }
    public ArrayList<FlightMission> convert(File file)
    {
        LinkedList<String> strings = this.fileToString(file);
        ArrayList<FlightMission> flightMissions = new ArrayList<>();
        strings.remove(0);
        Planet to = null, from = null;
        LocalDate startDate = null;
        Spaceship spaceship = null;
        String name;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            String temp = strings.get(i);
            int j=0;
            for (j = 0; j < temp.length(); j++) {
                if(temp.charAt(j)!=',')
                {
                    sb.append(temp.charAt(j));
                } else {break;}
            }
            j++;
            name = sb.toString(); sb = new StringBuilder();
            for (; j < temp.length(); j++) {
                if(temp.charAt(j)!=',')
                {
                    sb.append(temp.charAt(j));
                } else break;
            }
            to=new PlanetCriteria().nameSearch(sb.toString()); sb = new StringBuilder();
            j++;
            for (; j< temp.length(); j++) {
                if(temp.charAt(j)!=',') {
                    sb.append(temp.charAt(j));
                } else break;
            }
            from= new PlanetCriteria().nameSearch(sb.toString());sb=new StringBuilder();
            j++;
            for (; j< temp.length(); j++) {
                if(temp.charAt(j)!=',') {
                    sb.append(temp.charAt(j));
                } else break;
            }
            startDate=this.stringToDate(sb.toString());
            sb = new StringBuilder(); j++;
            for (; j< temp.length(); j++) {
                if(temp.charAt(j)!=','&&temp.charAt(j)!=';') {
                    sb.append(temp.charAt(j));
                } else break;
            }
            spaceship=new SpaceshipCriteria().nameSearch(sb.toString());
            int k[]=DateOperations.GENERAL.localStringToDate(startDate.toString());
            flightMissions.add(MissionFabric.INSTANCE.create(from, to, spaceship, DateOperations.GENERAL.dateToString(k)));
        }
        return flightMissions;
    }
}
