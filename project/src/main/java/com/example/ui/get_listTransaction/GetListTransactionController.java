package com.example.ui.get_listTransaction;

import com.example.usecase.GetListTransaction.GetListTransactionInput;

public class GetListTransactionController {
    private GetListTransactionInput getListTransactionInput;

    public GetListTransactionController(GetListTransactionInput getListTransactionInput) {
        this.getListTransactionInput = getListTransactionInput;
    }

    public void execute(){
        getListTransactionInput.getListExecute();
    }
  
}
