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
import com.example.usecase.GetListTransaction.GetListTransactionDatabase;

public class GetListTransactionDAOMySQL implements  GetListTransactionDatabase{

    private static final String URL = "jdbc:mysql://localhost:3306/DETAIDATVANHA";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";


    @Override
    public List<RealEstate> getAllTransaction() {
        List<RealEstate> realEstates = new ArrayList<>();
        String sql = "SELECT * FROM datvanha";
    
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            while (rs.next()) {
                int maGiaoDich = rs.getInt("MAGD"); // Lấy mã giao dịch
                String loaiGiaoDich = rs.getString("LOAI_GIAO_DICH");
                // Check if the transaction is for land or house
                if ("ĐẤT".equalsIgnoreCase(loaiGiaoDich)) {
                    Land land = new Land(
                        rs.getInt("MAGD"),
                            rs.getDate("NGAY_GIAO_DICH"),
                            loaiGiaoDich,
                            rs.getDouble("DON_GIA"),
                            rs.getDouble("DIEN_TICH"),
                            rs.getString("LOAI_DAT")
                    );
                    land.setMaGiaoDich(maGiaoDich); // Set mã giao dịch vào đối tượng Land
                    realEstates.add(land);
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
                    house.setMaGiaoDich(maGiaoDich); // Set mã giao dịch vào đối tượng House
                    realEstates.add(house);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
        }
        return realEstates;
    }
}
