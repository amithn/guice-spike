package com.spike.app;


import java.sql.*;

public class HiveJDBCClient {
    private static String hiveServer2driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String hiveServer1driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    /**
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(hiveServer1driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        //replace "hive" here with the name of the user the queries should run as
        Connection con = DriverManager.getConnection("jdbc:hive://localhost.localdomain:10000/default");
        Statement stmt = con.createStatement();

        String sql = "show tables";
        ResultSet res = stmt.executeQuery(sql);
        if (res.next()) {
            System.out.println(res.getString(1));
        }
    }
}
