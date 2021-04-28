package com.epam.jwd.core_final.converter;

import com.epam.jwd.core_final.domain.AbstractBaseEntity;
import com.epam.jwd.core_final.domain.Spaceship;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public enum ConverterStringToSpaceship {
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
                    strings.add(sb.toString());
                    sb=new StringBuilder();
                    j++;
                }
            }
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
        String example ="#name,distance,crew {roleid:count,roleid:count,roleid:count,roleid:count};";
        strings.remove(0);
        StringBuilder sb1 = new StringBuilder(strings.get(0));
        strings.set(0, sb1.toString());
        return strings;
    }
    public ArrayList<Spaceship> convert(File file)
    {
        ArrayList<String> strings = ConverterStringToSpaceship.GENERAL.fileToString(file);
        ArrayList<Spaceship> data = new ArrayList<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String name = null;
        long distance = 0;
        short []requires=new short[4];
        for (int i = 0; i <strings.size(); i++) {
            sb=new StringBuilder();
            count=0;
            for (int j = 0; j <strings.get(i).length() ; j++) {
                if(strings.get(i).charAt(j)==','||strings.get(i).charAt(j)==';')
                {
                 switch (count)
                 {
                     case 0: {name=sb.toString(); break;}
                     case 1: {distance=Long.parseLong(sb.toString()); break;}
                     case 2: {
                         char temp=sb.toString().charAt(sb.length()-1);
                         requires[0]= Short.parseShort(String.valueOf(temp)); break;
                     }
                     case 3: {
            //             System.out.print(sb.toString().charAt(sb.length()-1));
                         char temp = sb.toString().charAt(sb.length() - 1);
                         requires[1] = Short.parseShort(String.valueOf(temp)); break;
                     }
                     case 4: {
              //           System.out.print(sb.toString().charAt(sb.length()-1));
                         char temp = sb.toString().charAt(sb.length() - 1);
                         requires[2] = Short.parseShort(String.valueOf(temp)); break;
                     }
                     case 5: {
                //         System.out.print(sb.toString().charAt(sb.length()-2));
                         char temp = sb.toString().charAt(sb.length() - 2);
                         requires[3] = Short.parseShort(String.valueOf(temp)); break;
                     }
                 }
                 count++;
                 sb=new StringBuilder();
                }
                else {sb.append(strings.get(i).charAt(j));}
            }
            data.add(new Spaceship(name, distance, requires));
        }
        return data;
    }
}
