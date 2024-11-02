package com.example.usecase.CalAverageTransaction;

import java.util.List;

import com.example.entity.Land;
import com.example.entity.RealEstate;

public class CalAverageTransactionUseCase implements CalAverageTransactionInput{
    private CalAverageTransactionOutput calAverageTransactionOutput = null;
    private CalAverageTransactionDatabase calAverageTransactionDatabase = null;

  
  
  
  
  
  
  
    public CalAverageTransactionUseCase(CalAverageTransactionOutput calAverageTransactionOutput,
            CalAverageTransactionDatabase calAverageTransactionDatabase) {
        this.calAverageTransactionOutput = calAverageTransactionOutput;
        this.calAverageTransactionDatabase = calAverageTransactionDatabase;
    }








    @Override
    public double calAverageExecute() {
        List<RealEstate> transactions = calAverageTransactionDatabase.getAllTransaction();

        double tongThanhTien = 0;
        int count = 0;

           for (RealEstate transaction : transactions) {
            if (transaction instanceof Land) {
                tongThanhTien += transaction.thanhTien();
                count++;
            }
        }

        double average = count > 0 ? tongThanhTien / count : 0;

        CalAverageTransactionOutputDTO outputDTO = new CalAverageTransactionOutputDTO();
        outputDTO.setCalAverage(average);
        calAverageTransactionOutput.presenter(outputDTO);

        return  average;
    }
    
    

}
