package com.example.database.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.EditTransaction.EditTransactionDatabase;

public class EditTransactionDAOMySQL implements  EditTransactionDatabase{
    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    
    @Override
    public int editTransaction(RealEstate realEstate) {
        String updateSQL;
        if (realEstate instanceof House) {
            updateSQL = "UPDATE datvanha SET NGAY_GIAO_DICH = ?, LOAI_GIAO_DICH = ?, DON_GIA = ?, DIEN_TICH = ?, LOAI_NHA = ?, DIA_CHI = ? WHERE MAGD = ?";
        } else if (realEstate instanceof Land) {
            updateSQL = "UPDATE datvanha SET NGAY_GIAO_DICH = ?, LOAI_GIAO_DICH = ?, DON_GIA = ?, DIEN_TICH = ?, LOAI_DAT = ? WHERE MAGD = ?";
        } else {
            return 0; // Unknown transaction type
        }
    
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
    
            // Set common fields
            preparedStatement.setDate(1, new java.sql.Date(realEstate.getNgayGiaoDich().getTime()));
            preparedStatement.setString(2, realEstate.getLoaiGiaoDich());
            preparedStatement.setDouble(3, realEstate.getDonGia());
            preparedStatement.setDouble(4, realEstate.getDienTich());
    
            // Set specific fields for House or Land
            if (realEstate instanceof House) {
                House house = (House) realEstate;
                preparedStatement.setString(5, house.getLoaiNha());
                preparedStatement.setString(6, house.getDiaChi());
                preparedStatement.setInt(7, house.getMaGiaoDich());
            } else if (realEstate instanceof Land) {
                Land land = (Land) realEstate;
                preparedStatement.setString(5, land.getLoaiDat());
                preparedStatement.setInt(6, land.getMaGiaoDich());
            }
    
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    




    
 @Override
    public boolean existByMaGiaoDich(int maGiaoDich) {
        String selectSQL = "SELECT COUNT(*) FROM datvanha WHERE MAGD = ?";
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

        preparedStatement.setInt(1, maGiaoDich);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1) > 0; // Nếu đếm được > 0, mã giao dịch đã tồn tại
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Nếu có lỗi hoặc không tìm thấy, trả về false
    }



    @Override
    public RealEstate getTransactionByMaGiaoDich(int maGiaoDich) {
        String selectSQL = "SELECT * FROM datvanha WHERE MAGD = ?";
        RealEstate realEstate = null;
    
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
    
            preparedStatement.setInt(1, maGiaoDich);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                // Assuming you have getters for all the required fields
                int magd = resultSet.getInt("MAGD");
                Date ngayGiaoDich = resultSet.getDate("NGAY_GIAO_DICH");
                String loaiGiaoDich = resultSet.getString("LOAI_GIAO_DICH");
                double donGia = resultSet.getDouble("DON_GIA");
                double dienTich = resultSet.getDouble("DIEN_TICH");
                String diaChi = resultSet.getString("DIA_CHI");
                String loaiNha = resultSet.getString("LOAI_NHA");
                String loaiDat = resultSet.getString("LOAI_DAT");
    
                if (loaiGiaoDich.equals("Nhà")) {
                    realEstate = new House(magd, ngayGiaoDich, loaiGiaoDich, donGia, dienTich, loaiNha, diaChi);
                } else if (loaiGiaoDich.equals("Đất")) {
                    realEstate = new Land(magd, ngayGiaoDich, loaiGiaoDich, donGia, dienTich, loaiDat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realEstate; // Return the retrieved RealEstate object
    }

}
