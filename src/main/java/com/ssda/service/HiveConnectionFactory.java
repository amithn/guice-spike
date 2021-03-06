package com.ssda.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class HiveConnectionFactory {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    //private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HiveConnection createNew() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:hive2://localhost:21050/;auth=noSasl");
            //con = DriverManager.getConnection("jdbc:hive://localhost:10000/default", "cloudera", "cloudera");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HiveConnection(con);
    }
}
