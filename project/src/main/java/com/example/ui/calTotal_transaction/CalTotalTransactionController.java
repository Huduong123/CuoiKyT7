package com.example.ui.calTotal_transaction;

import com.example.usecase.CalTotalTransaction.CalTotalTransactionInput;

public class CalTotalTransactionController {
    private CalTotalTransactionInput calTotalTransactionInput = null;

    public CalTotalTransactionController(CalTotalTransactionInput calTotalTransactionInput) {
        this.calTotalTransactionInput = calTotalTransactionInput;
    }

    public CalTotalTransactionInput getCalTotalTransactionInput() {
        return calTotalTransactionInput;
    }

    public void execute(){
        calTotalTransactionInput.calTotalExecute();
    }
}
