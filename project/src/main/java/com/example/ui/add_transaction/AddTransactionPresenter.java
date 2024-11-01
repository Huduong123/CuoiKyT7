package com.example.ui.add_transaction;

import javax.swing.JOptionPane;

import com.example.ui.TransactionFormView;
import com.example.usecase.AddTransaction.AddTransactionOutput;
import com.example.usecase.AddTransaction.AddTransactionOutputDTO;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class AddTransactionPresenter implements AddTransactionOutput {

    private AddTransactionOutputDTO addTransactionOutputDTO = null;
    private ResponseError resError = null;
    private  ResponseData resData = null;
    private TransactionFormView formMain;
    private AddTransactionViewModel addViewModel;
    
    public AddTransactionPresenter(AddTransactionViewModel addViewModel) {
        this.addViewModel = addViewModel;
    }

    
   

    public TransactionFormView getForm() {
        return formMain;
    }

    @Override
    public void presenter(AddTransactionOutputDTO addTransactionOutputDTO) {
        this.addTransactionOutputDTO = addTransactionOutputDTO;


      AddTransactionDetailForm  addTransactionDetailForm = new AddTransactionDetailForm(addTransactionOutputDTO);
      
    }

    public AddTransactionOutputDTO getAddTransactionOutputDTO() {
        return addTransactionOutputDTO;
    }

    @Override
    public void outError(ResponseError error) {

        this.resError = error;
        String errorMessage = error.getMessage() + "\nLỗi: " + error.getStoreValue();
       addViewModel.setMessageError(errorMessage);
       // JOptionPane.showMessageDialog(null,  errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);

        System.err.println(errorMessage);
    }



    public ResponseError getResError() {
        return resError;
    }

    public ResponseData getResData() {
        return resData;
    }




    @Override
    public void outResult(ResponseData success) {
        this.resData = success;
          JOptionPane.showMessageDialog(null,success.getMessage(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

}
