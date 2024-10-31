package com.example.usecase;

import java.util.List;

import com.example.entity.RealEstate;

public class DataExport {
    public  List<RealEstate> list = null;

    public DataExport(List<RealEstate> list) {
        this.list = list;
    }

    public List<RealEstate> getList() {
        return list;
    }

    
}
