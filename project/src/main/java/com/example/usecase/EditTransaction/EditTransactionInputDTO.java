package com.example.usecase.EditTransaction;

import java.util.Date;

public class   EditTransactionInputDTO {
      protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected String loaiGiaoDich;
    protected double donGia;
    protected double dienTich;

    private String loaiDat;

    private String loaiNha;
    private String diaChi;

    

    public EditTransactionInputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;

    }

    // contructor Đất
    public EditTransactionInputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, String loaiDat) {
        this.maGiaoDich = maGiaoDich;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.loaiDat = loaiDat;
        this.loaiGiaoDich = loaiGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
    }

    // contructor nhà
    public EditTransactionInputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, String loaiNha, String diaChi) {
        this.maGiaoDich = maGiaoDich;
        this.diaChi = diaChi;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.loaiGiaoDich = loaiGiaoDich;
        this.loaiNha = loaiNha;
        this.ngayGiaoDich = ngayGiaoDich;
    }

 
    
    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }



    public String getLoaiDat() {
        return loaiDat;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getDienTich() {
        return dienTich;
    }
}
