package com.intoan.note.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    private static Properties properties = new Properties();

    static {

        InputStream in = null;

        try {
            in = JDBCUtil.class.getClassLoader().getResourceAsStream("JDBC.properties");

            properties.load(in);

            Class.forName(properties.getProperty("Driver"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (in == null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @return Connection
     */
    public static Connection getConnection(){
        Connection connection = null;

        try {
            String url = properties.getProperty("url");
            String name = properties.getProperty("name");
            String passwd = properties.getProperty("passwd");

             connection = DriverManager.getConnection(url, name, passwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

    /**
     * close connection
     * @param conn
     * @param rs
     * @param pstm
     */
    public static void close(Connection conn, ResultSet rs, PreparedStatement pstm){
//        当关闭第一个失败时将导致后面的都无法关闭
//        try {
//
//            if (conn != null){
//                conn.close();
//            }
//            if (rs != null){
//                rs.close();
//            }
//            if(pstm != null){
//                pstm.close();
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(pstm != null){
            try {
                pstm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
