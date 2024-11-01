package com.example.usecase.CalTotalTransaction;

public class CalTotalTransactionOutputDTO {
    private int totalLandTransactions;
    private int totalHouseTransactions;
    private int totalTransactions;

    public int getTotalLandTransactions() {
        return totalLandTransactions;
    }

    public void setTotalLandTransactions(int totalLandTransactions) {
        this.totalLandTransactions = totalLandTransactions;
    }

    public int getTotalHouseTransactions() {
        return totalHouseTransactions;
    }

    public void setTotalHouseTransactions(int totalHouseTransactions) {
        this.totalHouseTransactions = totalHouseTransactions;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}
