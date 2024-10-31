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
import com.example.usecase.AddTransaction.AddtransactionDatabase;

public class AddTransactionDAOMySQL implements  AddtransactionDatabase{
    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    @Override
    public int addTransaction(RealEstate realEstate) {
         String insertSQL = "INSERT INTO datvanha (MAGD, NGAY_GIAO_DICH, DON_GIA, DIEN_TICH, DIA_CHI, LOAI_GIAO_DICH, LOAI_NHA, LOAI_DAT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    int rowsAffected = 0;

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

        // Thiết lập các tham số cho PreparedStatement
        preparedStatement.setInt(1, realEstate.getMaGiaoDich());
        preparedStatement.setDate(2, new java.sql.Date(realEstate.getNgayGiaoDich().getTime()));
        preparedStatement.setDouble(3, realEstate.getDonGia());
        preparedStatement.setDouble(4, realEstate.getDienTich());
        
        if (realEstate instanceof House) {
            House house = (House) realEstate;
            preparedStatement.setString(5, house.getDiaChi());
            preparedStatement.setString(6, house.getLoaiGiaoDich());
            preparedStatement.setString(7, house.getLoaiNha());
            preparedStatement.setString(8, null); // Không có loại đất cho nhà
        } else if (realEstate instanceof Land) {
            Land land = (Land) realEstate;
            preparedStatement.setString(5, null); // Không có địa chỉ cho đất
            preparedStatement.setString(6, land.getLoaiGiaoDich());
            preparedStatement.setString(7, null); // Không có loại nhà cho đất
            preparedStatement.setString(8, land.getLoaiDat());
        }
        // Thực thi câu lệnh
        rowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return rowsAffected; // Trả về số dòng bị ảnh hưởng
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
