package com.example.entity;

import java.util.Date;

public class Land extends  RealEstate {
    private String loaiDat;

    public Land(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia, double dienTich, String loaiDat) {
        super(maGiaoDich,ngayGiaoDich, loaiGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    @Override
    public double thanhTien() {

        double donGia = getDonGia();
        double dienTich = getDienTich();


        if (loaiDat != null && loaiDat.equalsIgnoreCase("A")) {
            return dienTich * donGia * 1.5;
        } else {
            return dienTich * donGia;
        }
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
}
