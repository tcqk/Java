package sample;

import java.sql.*;

public class DB {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost/Loto?serverTimezone=UTC";
    final String USERNAME = "root";
    final String PASSWORD = "Ukir3*bCC20T";
    Connection con = null;
    PreparedStatement ps = null;

    public DB() {

        //We want to connect DB
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection is ready");
        } catch (SQLException e) {
            System.err.println("Failed" + e);
        }
    }

        public void addRes(String name, int score){
            String sql = "INSERT INTO Result (Name, Score) VALUES (?, ?)";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, score);
                ps.execute();
                System.out.println("Res added");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
}
