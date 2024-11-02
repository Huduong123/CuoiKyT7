package com.example.ui.calAverage_transaction;

import javax.swing.JOptionPane;

import com.example.usecase.CalAverageTransaction.CalAverageTransactionOutput;
import com.example.usecase.CalAverageTransaction.CalAverageTransactionOutputDTO;

public class CalAverageTranPresenter implements CalAverageTransactionOutput{

    private CalAverageTranViewModel calViewModel = null;
    private CalAverageTransactionOutputDTO outputDTO = null;


    @Override
    public void presenter(CalAverageTransactionOutputDTO calAverageTransactionOutputDTO) {
        this.outputDTO = calAverageTransactionOutputDTO;

        String message = "Trung bình thành tiền Giao dịch đất Đất: " + calAverageTransactionOutputDTO.getCalAverage();


         JOptionPane.showMessageDialog(null, message, "Kết Quả Tính :3", JOptionPane.INFORMATION_MESSAGE);
 
        System.out.println(message);
        }

    @Override
    public void outResult() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'outResult'");
    }

    public CalAverageTranViewModel getCalViewModel() {
        return calViewModel;
    }

    public CalAverageTransactionOutputDTO getOutputDTO() {
        return outputDTO;
    }
    
}
