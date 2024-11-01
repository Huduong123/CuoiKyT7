package com.example.entity;

import java.util.Date;

public abstract  class RealEstate {
    protected  int  maGiaoDich;
    protected  Date ngayGiaoDich;
    protected String loaiGiaoDich;
    protected  double donGia;
    protected  double dienTich;
    
    public RealEstate(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public RealEstate(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public RealEstate(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public RealEstate(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
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

    public abstract double thanhTien();    
}
