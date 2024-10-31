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

    public abstract double thanhTien();    
}
