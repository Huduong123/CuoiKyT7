package com.example.usecase.ExportTransaction;

public class ExportTransactionInputDTO {
    protected  int month;

    
    public ExportTransactionInputDTO(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }


    
}
