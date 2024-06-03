/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DAOTask {
    private static final String URL = "jdbc:mysql://localhost:3306/cuoiky";
    private static final String USER = "root"; // Thay đổi nếu cần
    private static final String PASSWORD = "19052005"; // Thay đổi nếu cần
    
    private Connection connection;
    

    public DAOTask() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
