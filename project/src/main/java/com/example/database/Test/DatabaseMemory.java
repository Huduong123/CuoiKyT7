package com.example.database.Test;

import java.util.HashMap;
import java.util.Map;

import com.example.entity.RealEstate;

public class DatabaseMemory {
    
    private Map<Integer, RealEstate> database = new HashMap<>();


    public Map<Integer, RealEstate> getDatabase() {
        return database;
    }
}
