package com.database.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection con = null;
    public static Connection getConnection() {
        if (con == null)
        {
            try
            {
                con = DriverManager.getConnection(DbDetails.URL,
                        DbDetails.USERNAME,
                        DbDetails.PASSWORD);

                return con;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return con;
    }
}
