package com.example.usecase.AddTransaction;

import com.example.entity.RealEstate;

public interface  AddtransactionDatabase {

    int addTransaction(RealEstate realEstate);

    boolean existByMaGiaoDich(int maGiaoDich);

 
    RealEstate getTransactionByMaGiaoDich(int maGiaoDich);
}
