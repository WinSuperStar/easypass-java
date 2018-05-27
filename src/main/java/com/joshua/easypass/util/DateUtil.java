package com.joshua.easypass.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date StrToDate(String str) {
        Date date = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = fmt.parse(str);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    public static Date autoComDate(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 15);
        dt = c.getTime();
        return dt;
    }

}
