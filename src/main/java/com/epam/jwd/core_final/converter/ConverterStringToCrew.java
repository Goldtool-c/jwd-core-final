package com.epam.jwd.core_final.converter;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public enum ConverterStringToCrew {
    GENERAL;
    public ArrayList<String> fileToString(File file)
    {
        ArrayList<String> strings = new ArrayList<>();
        try(FileInputStream fin=new FileInputStream(file))
        {
            int i=-1;
            int j=0;
            StringBuilder sb = new StringBuilder();
            while((i=fin.read())!=-1){
                sb.append((char) i);
                if((char)i==';'){
                    System.out.println(sb);
                    strings.add(sb.toString());
                    sb=new StringBuilder();
                    j++;
                }
            }
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
        String example = "role,name,rank;";
        String example1 = "#role,name,rank;";
        int n = strings.size();
        for (int i = 0; i < strings.size(); i++) {
            if(strings.get(i).equals(example)||strings.get(i).equals(example1))
            {
                strings.remove(i);
                i--;
            }
        }
        StringBuilder sb1 = new StringBuilder(strings.get(0));
        sb1.delete(0,5);
        strings.set(0, sb1.toString());
        return strings;
    }
    public ArrayList<AbstractBaseEntity> convert(File file) throws InvalidStateException {
        ArrayList<String> strings = fileToString(file);
        ArrayList<AbstractBaseEntity> dat = new ArrayList<>();
        for (int i = 0; i <strings.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String parameters;
            for (int j = 0; j <strings.get(i).length()-1; j++) {
                sb.append(strings.get(i).charAt(j));
            }
            parameters=sb.toString();
            String name = null;
            Role role = null;
            Rank rank = null;
            int counter=0;
            StringBuilder sb1=new StringBuilder();
            for (int j = 0; j <parameters.length() ; j++) {
                if(parameters.charAt(j)==','||j==parameters.length()-1)
                {
                    switch (counter) {
                        case 0: {role= Role.resolveRoleById(Integer.parseInt(sb1.toString())); break;}
                        case 1: {name=sb1.toString(); break;}
                        // case 2: {rank=Rank.resolveRankById(Integer.parseInt(sb1.toString()))} спросить
                        case 2: {rank= Rank.resolveRankById(Integer.parseInt(String.valueOf(parameters.charAt(parameters.length()-1)))); break;}
                        default:{throw new InvalidStateException("Unknown format exception"); }
                    }
                    sb1=new StringBuilder();
                    counter++;
                }
                else {sb1.append(parameters.charAt(j));}
            }
            dat.add(new CrewMember(name, role, rank));
        }
        return dat;
    }
}
