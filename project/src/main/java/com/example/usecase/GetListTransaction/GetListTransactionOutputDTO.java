package com.example.usecase.GetListTransaction;

import java.util.Date;

public class GetListTransactionOutputDTO {

    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected String loaiGiaoDich;
    protected double donGia;
    protected double dienTich;

    protected String loaiDat;

    protected String loaiNha;
    protected String diaChi;

    protected double thanhTien;

    public GetListTransactionOutputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, double thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.thanhTien = thanhTien;
    }

    // Constructor Land
    public GetListTransactionOutputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
            double dienTich, String loaiDat, double thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.loaiDat = loaiDat;
        this.thanhTien = thanhTien;
    }

    // constructor House
    public GetListTransactionOutputDTO(int maGiaoDich, Date ngayGiaoDich, String loaiGiaoDich, double donGia,
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

    public String getLoaiDat() {
        return loaiDat;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public double getThanhTien() {
        return thanhTien;
    }

}
