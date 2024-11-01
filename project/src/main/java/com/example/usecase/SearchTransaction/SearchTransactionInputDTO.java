package com.example.usecase.SearchTransaction;

import java.util.Date;

public class SearchTransactionInputDTO {
    protected int maGiaoDich;
    protected Date ngayGiaoDich;
    protected String loaiGiaoDich;


    public SearchTransactionInputDTO(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public SearchTransactionInputDTO(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public SearchTransactionInputDTO(String loaiGiaoDich) {
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

  


    
}
