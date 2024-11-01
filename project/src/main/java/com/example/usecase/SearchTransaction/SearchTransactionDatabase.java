package com.example.usecase.SearchTransaction;

import java.util.Date;
import java.util.List;

import com.example.entity.RealEstate;

public interface  SearchTransactionDatabase {
    List<RealEstate> searchTransactionByID(int maGiaoDich);
    
    boolean existByMaGiaoDich(int maGiaoDich);

    List<RealEstate> searchTransactionbyNgayGD(Date ngayGiaoDich);

    List<RealEstate> searchTransactionByLoaiGD(String loaiGiaoDich);
}
