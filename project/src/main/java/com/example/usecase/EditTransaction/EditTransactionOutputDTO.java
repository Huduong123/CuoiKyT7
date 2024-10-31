package com.example.usecase.EditTransaction;

import java.util.Date;

public class EditTransactionOutputDTO {
      protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected String loaiGiaoDich;
    protected double donGia;
    protected double dienTich;
    protected String loaiNha;
    protected String loaiDat;
    protected String diaChi;
    protected double thanhTien;

    public EditTransactionOutputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, double thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.thanhTien = thanhTien;
    }
    
    public EditTransactionOutputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, String loaiNha, String diaChi, double thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
        this.thanhTien = thanhTien;
    }

    
    public EditTransactionOutputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, String loaiDat, double thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.loaiDat = loaiDat;
        this.thanhTien = thanhTien;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    public String getDiaChi() {
        return diaChi;
    }
}
