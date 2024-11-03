package com.example.database.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.ExportTransaction.ExportTransactionDatabase;

public class ExportTransactionDAOMySQL implements ExportTransactionDatabase{


    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";


    @Override
    public List<RealEstate> getTransactionByMonth(int month) {
        List<RealEstate> transactions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM datvanha WHERE MONTH(NGAY_GIAO_DICH) = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, month);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maGiaoDich = resultSet.getInt("MAGD");
                String loaiGiaoDich = resultSet.getString("LOAI_GIAO_DICH");
                double donGia = resultSet.getDouble("DON_GIA");
                double dienTich = resultSet.getDouble("DIEN_TICH");
                java.sql.Date ngayGiaoDich = resultSet.getDate("NGAY_GIAO_DICH");

                if ("Nhà".equalsIgnoreCase(loaiGiaoDich)) {
                    String loaiNha = resultSet.getString("LOAI_NHA");
                    String diaChi = resultSet.getString("DIA_CHI");
                    transactions.add(new House(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich, loaiNha, diaChi));
                } else if ("Đất".equalsIgnoreCase(loaiGiaoDich)) {
                    String loaiDat = resultSet.getString("LOAI_DAT");
                    transactions.add(new Land(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich, loaiDat));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }
    
}
