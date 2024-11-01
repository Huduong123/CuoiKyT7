package com.example.entity;

import java.util.Date;

public class House extends  RealEstate {
    private String loaiNha;
    private String diaChi;

    public House(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia, double dienTich, String loaiNha,
            String diaChi) {
        super(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    @Override
    public double thanhTien() {
        
        double donGia = getDonGia();
        double dienTich = getDienTich();

        if (loaiNha.equalsIgnoreCase("cao cấp")) {
            return dienTich * donGia;
        } else {
            return dienTich * donGia * 0.9;
        }
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
