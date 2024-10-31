package com.example.ui.get_listTransaction;

public class GetListTransactionViewModel {
    public String maGiaoDich;
    public String ngayGiaoDich;
    public String loaiGiaoDich;
    public String donGia;
    public String dienTich;

    public String loaiDat;

    public String loaiNha;
    public String diaChi;

    public String thanhTien;

    public GetListTransactionViewModel(String maGiaoDich, String ngayGiaoDich, String loaiGiaoDich, String donGia,
            String dienTich, String diaChi, String thanhTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.diaChi = diaChi;
        this.thanhTien = thanhTien;
    }

    public GetListTransactionViewModel(String maGiaoDich, String ngayGiaoDich, String loaiGiaoDich, String donGia,
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

    public GetListTransactionViewModel(String maGiaoDich, String ngayGiaoDich, String loaiGiaoDich, String donGia,
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

}
