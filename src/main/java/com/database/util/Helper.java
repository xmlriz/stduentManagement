package com.database.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {

    public static Date javaDateToSqlDate(LocalDate date)
    {
        return Date.valueOf(date);
    }

    public static LocalDate stringDateToJavaDate(String date)
    {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
