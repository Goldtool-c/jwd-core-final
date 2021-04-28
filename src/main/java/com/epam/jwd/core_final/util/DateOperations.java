package com.epam.jwd.core_final.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateOperations {
    GENERAL;
    public String getDate()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(new Date());
    }
    public int[] StringToDate(String date)
    {
        int[] res = new int[3];
        StringBuilder sb = new StringBuilder();
        int counter=0;
        for (int i = 0; i <date.length() ; i++) {
            if(date.charAt(i)!='.') { sb.append(date.charAt(i)); }
            else {res[counter]=Integer.parseInt(sb.toString()); counter++; sb=new StringBuilder();}
        }
        res[2]=Integer.parseInt(sb.toString());
        return res;
    }
    public String dateToString(int[] date)
    {
        StringBuilder sb =new StringBuilder();
        if(date[0]<10) {sb.append(0);}
        sb.append(date[0]); sb.append('.');
        if(date[1]<10) {sb.append(0);}
        sb.append(date[1]); sb.append('.');
        sb.append(date[2]);
        return sb.toString();
    }
    public int[] localStringToDate(String date)
    {
        int[] res = new int[3];
        StringBuilder sb = new StringBuilder();
        int counter=0;
        for (int i = 0; i <date.length() ; i++) {
            if(date.charAt(i)!='-') { sb.append(date.charAt(i)); }
            else {res[2-counter]=Integer.parseInt(sb.toString()); counter++; sb=new StringBuilder();}
        }
        res[0]=Integer.parseInt(sb.toString());
        return res;
    }
}
