package com.example.ui.calTotal_transaction;

import javax.swing.JOptionPane;

import com.example.usecase.CalTotalTransaction.CalTotalTransactionOutput;
import com.example.usecase.CalTotalTransaction.CalTotalTransactionOutputDTO;
import com.example.usecase.ResponseData;

public class CalTotalTransactionPresenter implements CalTotalTransactionOutput {

    private CalTotalTransactionOutputDTO calTotalOutputDTO = null;
    private CalTotalTransactionViewModel calTotalViewModel = null;

    @Override
    public void presenter(CalTotalTransactionOutputDTO calTotalTransactionOutputDTO) {
       // Hiển thị kết quả bằng JOptionPane
     this.calTotalOutputDTO = calTotalTransactionOutputDTO;
        String message = "Tổng số giao dịch đất: " + calTotalTransactionOutputDTO.getTotalLandTransactions() +
                         "\nTổng số giao dịch nhà: " + calTotalTransactionOutputDTO.getTotalHouseTransactions() +
                         "\nTổng số giao dịch: " + calTotalTransactionOutputDTO.getTotalTransactions();
        JOptionPane.showMessageDialog(null, message, "Kết Quả Tính Toán Giao Dịch", JOptionPane.INFORMATION_MESSAGE);


        System.out.println("Tổng số giao dịch đất: " + calTotalTransactionOutputDTO.getTotalLandTransactions() +
                         "\nTổng số giao dịch nhà: " + calTotalTransactionOutputDTO.getTotalHouseTransactions() +
                         "\nTổng số giao dịch: " + calTotalTransactionOutputDTO.getTotalTransactions());
    }

    @Override
    public int outResult(ResponseData responseData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'outResult'");
    }

    public CalTotalTransactionOutputDTO getCalTotalOutputDTO() {
        return calTotalOutputDTO;
    }

    public CalTotalTransactionViewModel getCalTotalViewModel() {
        return calTotalViewModel;
    }

    
    
}
