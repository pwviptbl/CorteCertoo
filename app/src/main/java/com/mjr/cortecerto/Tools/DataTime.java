package com.mjr.cortecerto.Tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataTime {
    public static String data (){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");

        Date data = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        String data_completa = dateFormat.format(data_atual);

        return data_completa;
    }
}
