package com.example.database.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.usecase.CalTotalTransaction.CalTotalTransactionDatabase;

public class CalTotalTransactionDAOMySQL implements  CalTotalTransactionDatabase{
    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    @Override
    public int countTransactionsByType(String loaiGiaoDich) {
   String query = "SELECT COUNT(*) FROM datvanha WHERE LOAI_GIAO_DICH = ?";
        int count = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, loaiGiaoDich);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }


  
}
