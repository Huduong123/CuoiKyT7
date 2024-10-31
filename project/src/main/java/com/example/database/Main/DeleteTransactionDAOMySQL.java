package com.example.database.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.entity.RealEstate;
import com.example.usecase.DeleteTransaction.DeleteTransactionDatabase;

public class DeleteTransactionDAOMySQL implements DeleteTransactionDatabase{
  
  
    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    @Override
    public int deleteTransaction(RealEstate realEstate) {
        String query = "DELETE FROM datvanha WHERE MAGD = ?";
        int rowsAffected = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, realEstate.getMaGiaoDich());
            rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowsAffected;
    }
    
}
