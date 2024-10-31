package com.example.ui.edit_transaction;

import javax.swing.JOptionPane;

import com.example.ui.TransactionFormView;
import com.example.usecase.EditTransaction.EditTransactionOutput;
import com.example.usecase.EditTransaction.EditTransactionOutputDTO;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class EditTransactionPresenter implements  EditTransactionOutput{
    private EditTransactionOutputDTO editTransactionOutputDTO = null;
    private ResponseError resError = null;
    private  ResponseData resData = null;
     private TransactionFormView formMain;
    private EditTransactionViewModel editViewModel;

     
    public EditTransactionPresenter(EditTransactionViewModel editViewModel) {
        this.editViewModel = editViewModel;
    }

    @Override
    public void presenter(EditTransactionOutputDTO editTransactionOutputDTO) {
        this.editTransactionOutputDTO = editTransactionOutputDTO;
      

    }
    @Override
    public void outError(ResponseError error) {
       this.resError = error;
       String errorMessage = error.getMessage() + "\nLỗi: " + error.getStoreValue();
       editViewModel.setMessageError(errorMessage);
      
  //JOptionPane.showMessageDialog(null,  errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
        System.err.println(errorMessage);
    }
    @Override
    public void outResult(ResponseData responseData) {
     this.resData = responseData;
     JOptionPane.showMessageDialog(null,responseData.getMessage(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }


    public EditTransactionOutputDTO getEditTransactionOutputDTO() {
        return editTransactionOutputDTO;
    }

    public TransactionFormView getFormMain() {
        return formMain;
    }

    public ResponseError getResError() {
        return resError;
    }

    public ResponseData getResData() {
        return resData;
    }


}
