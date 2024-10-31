package com.example.ui.edit_transaction;

import com.example.usecase.EditTransaction.EditTransactionInput;

public class EditTransactionController {
    private EditTransactionInput editTransactionInput = null;

    public EditTransactionController(EditTransactionInput editTransactionInput) {
        this.editTransactionInput = editTransactionInput;
    }
    
}
