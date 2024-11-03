package com.example.usecase.ExportTransaction;

import java.util.List;

import com.example.entity.RealEstate;

public interface  ExportTransactionDatabase {
    public List<RealEstate> getTransactionByMonth(int month);
}
