package com.example.database.Test;

import java.util.List;

import com.example.entity.RealEstate;
import com.example.usecase.GetListTransaction.GetListTransactionDatabase;

public class GetListTransactionDAOMemory implements  GetListTransactionDatabase {
    private List<RealEstate> database = null;




    
    public GetListTransactionDAOMemory(List<RealEstate> database) {
        this.database = database;
    }





    @Override
    public List<RealEstate> getAllTransaction() {
        return  database;
    }
    
}
