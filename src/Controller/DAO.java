/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vang
 */
public class DAO {
    public Connection conn;
    private final String DB_URL = "jdbc:mysql://localhost/book_car";
    private final String USER_NAME = "root";
    private final String PASSWORD = "";

    public DAO() {
        try {
            conn = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}