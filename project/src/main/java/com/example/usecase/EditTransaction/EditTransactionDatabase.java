package com.example.usecase.EditTransaction;

import com.example.entity.RealEstate;

public interface  EditTransactionDatabase {
    int editTransaction(RealEstate realEstate);

    
    boolean existByMaGiaoDich(int maGiaoDich);

 
    RealEstate getTransactionByMaGiaoDich(int maGiaoDich);
}
