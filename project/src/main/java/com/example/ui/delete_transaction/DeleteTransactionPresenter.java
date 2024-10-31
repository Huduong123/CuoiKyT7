package com.example.ui.delete_transaction;

import javax.swing.JOptionPane;

import com.example.ui.TransactionFormView;
import com.example.usecase.DeleteTransaction.DeleteTransactionOutput;
import com.example.usecase.DeleteTransaction.DeleteTransactionOutputDTO;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class DeleteTransactionPresenter implements DeleteTransactionOutput{
    
    private DeleteTransactionOutputDTO deleteTransactionOutputDTO = null;
    private ResponseError resError = null;
    private  ResponseData resData = null;
    private TransactionFormView formMain;
    private DeleteTransactionViewModel deleteViewModel;


    public DeleteTransactionPresenter(DeleteTransactionViewModel deleteViewModel) {
        this.deleteViewModel = deleteViewModel;
    }

    
    public DeleteTransactionOutputDTO getDeleteTransactionOutputDTO() {
        return deleteTransactionOutputDTO;
    }


    public ResponseError getResError() {
        return resError;
    }


    public ResponseData getResData() {
        return resData;
    }


    public TransactionFormView getFormMain() {
        return formMain;
    }


    @Override
    public void presenter(DeleteTransactionOutputDTO deleteTransactionOutputDTO) {
        this.deleteTransactionOutputDTO = deleteTransactionOutputDTO;
    }

    @Override
    public void outError(ResponseError error) {
        this.resError = error;
     
    }

    @Override
    public void outResult(ResponseData responseData) {
        this.resData = responseData;
           JOptionPane.showMessageDialog(null,responseData.getMessage(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
  System.out.println(responseData.getMessage());
        }
    
}
