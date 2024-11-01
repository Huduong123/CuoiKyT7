package com.example.database.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.SearchTransaction.SearchTransactionDatabase;

public class SearchTransactionDAOMySQL implements  SearchTransactionDatabase{
 
 
    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
   

    
    @Override
    public List<RealEstate> searchTransactionByID(int maGiaoDich) {
        List<RealEstate> realEstateList = new ArrayList<>();
        String selectSQL = "SELECT * FROM datvanha WHERE MAGD = ?";
      
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
    
            preparedStatement.setInt(1, maGiaoDich);
            ResultSet rs = preparedStatement.executeQuery();
    
            while (rs.next()) {
                String loaiGiaoDich = rs.getString("LOAI_GIAO_DICH");
                if ("ĐẤT".equalsIgnoreCase(loaiGiaoDich)) {
                    Land land = new Land(
                        rs.getInt("MAGD"),
                        rs.getDate("NGAY_GIAO_DICH"),
                        loaiGiaoDich,
                        rs.getDouble("DON_GIA"),
                        rs.getDouble("DIEN_TICH"),
                        rs.getString("LOAI_DAT")
                    );
                    realEstateList.add(land);
                } else if ("NHÀ".equalsIgnoreCase(loaiGiaoDich)) {
                    House house = new House(
                        rs.getInt("MAGD"),
                        rs.getDate("NGAY_GIAO_DICH"),
                        loaiGiaoDich,
                        rs.getDouble("DON_GIA"),
                        rs.getDouble("DIEN_TICH"),
                        rs.getString("LOAI_NHA"),
                        rs.getString("DIA_CHI")
                    );
                    realEstateList.add(house);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return realEstateList;
    }

    
    @Override
    public List<RealEstate> searchTransactionbyNgayGD(Date ngayGiaoDich) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchTransactionbyNgayGD'");
    }
    @Override
    public List<RealEstate> searchTransactionByLoaiGD(String loaiGiaoDich) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchTransactionByLoaiGD'");
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

    



   
    }
    

