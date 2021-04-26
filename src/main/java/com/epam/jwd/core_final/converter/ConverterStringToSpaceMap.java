package com.epam.jwd.core_final.converter;

import com.epam.jwd.core_final.domain.Planet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public enum ConverterStringToSpaceMap {
    GENERAL;
    private int n=0;
    public ArrayList<String> fileToString(File file) {
        int max=0;
        ArrayList<String> strings = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream(file)) {
            int i = -1;
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while ((i = fin.read()) != -1) {
                sb.append((char) i);
                if ((char) i == ',') {
                    max++;
                    strings.add(sb.toString());
                    sb = new StringBuilder();
                    j++;
                }
                if((char) i=='\n'&&max>=this.n) {this.n=max; max=0;}
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return strings;
    }
    public ArrayList<Planet> convert(File file)
    {
        ArrayList<String> strings = this.fileToString(file);
        ArrayList<Planet> data = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if(!strings.get(i).contains("null"))
            {
                data.add(new Planet(strings.get(i), ((int)i/n)*100, (i%n)*100));
            }
        }
        return data;
    }
}

