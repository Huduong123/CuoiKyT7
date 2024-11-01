package com.example.usecase.CalTotalTransaction;

public class CalTotalTransactionUseCase implements  CalTotalTransactionInput{

    CalTotalTransactionDatabase calTotalTransactionDatabase = null;
    CalTotalTransactionOutput calTotalTransactionOutput = null;


    
    public CalTotalTransactionUseCase(CalTotalTransactionDatabase calTotalTransactionDatabase,
            CalTotalTransactionOutput calTotalTransactionOutput) {
        this.calTotalTransactionDatabase = calTotalTransactionDatabase;
        this.calTotalTransactionOutput = calTotalTransactionOutput;


    }



    @Override
    public int calTotalExecute() {
       
        int totalLandTransactions = calTotalTransactionDatabase.countTransactionsByType("Đất");
        int totalHouseTransactions = calTotalTransactionDatabase.countTransactionsByType("Nhà");
        

        // Tính tổng giao dịch của cả hai loại
        int totalTransactions = totalLandTransactions + totalHouseTransactions;

        CalTotalTransactionOutputDTO outputDTO = new CalTotalTransactionOutputDTO();
        outputDTO.setTotalLandTransactions(totalLandTransactions);
        outputDTO.setTotalHouseTransactions(totalHouseTransactions);
        outputDTO.setTotalTransactions(totalTransactions);

        calTotalTransactionOutput.presenter(outputDTO);
       
        return 0;
    }
    
}
