package com.joshua.easypass.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
