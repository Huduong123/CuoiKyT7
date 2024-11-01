package com.example.ui.search_transaction;

public class SearchTransactionViewModel {

    public String maGiaoDich;
    public String ngayGiaoDich;
    public String loaiGiaoDich;
    public String donGia;
    public String dienTich;

    public String loaiDat;

    public String loaiNha;
    public String diaChi;

    public String thanhTien;

    public SearchTransactionViewModel(String maGiaoDich, String ngayGiaoDich, String loaiGiaoDich, String donGia,
            String dienTich, String diaChi, String thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.diaChi = diaChi;
        this.thanhTien = thanhTien;
    }

    public SearchTransactionViewModel(String maGiaoDich, String ngayGiaoDich, String loaiGiaoDich, String donGia,
            String dienTich, String loaiDat, String loaiNha, String diaChi, String thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.loaiDat = loaiDat; // Sửa phần này
        this.loaiNha = loaiNha; // Sửa phần này
        this.diaChi = diaChi;
        this.thanhTien = thanhTien;
    }

    public SearchTransactionViewModel(String maGiaoDich, String ngayGiaoDich, String loaiGiaoDich, String donGia,
            String dienTich, String loaiNha, String diaChi, String thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
        this.thanhTien = thanhTien;
    }

    public String messageError;

    
    public String getMessageError() {
        return messageError;
    }
    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
