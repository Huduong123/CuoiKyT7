package com.example.ui.calAverage_transaction;

import com.example.usecase.CalAverageTransaction.CalAverageTransactionInput;

public class CalAverageTranController {
    private CalAverageTransactionInput calAverageTransactionInput = null;

    public CalAverageTranController(CalAverageTransactionInput calAverageTransactionInput) {
        this.calAverageTransactionInput = calAverageTransactionInput;
    }

    public CalAverageTransactionInput getCalAverageTransactionInput() {
        return calAverageTransactionInput;
    }
    

    public void execute(){
        calAverageTransactionInput.calAverageExecute();
    }
}
