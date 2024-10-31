package com.example.ui.delete_transaction;

import com.example.usecase.DeleteTransaction.DeleteTransactionInput;
import com.example.usecase.DeleteTransaction.DeleteTransactionInputDTO;

public class DeleteTransactionController {
    private DeleteTransactionInput deleteTransactionInput = null;

    public DeleteTransactionController(DeleteTransactionInput deleteTransactionInput) {
        this.deleteTransactionInput = deleteTransactionInput;
    }

    public DeleteTransactionInput getDeleteTransactionInput() {
        return deleteTransactionInput;
    }

    public void getMaGiaoDich(String maGiaoDich){


        DeleteTransactionInputDTO deleteTransactionInputDTO = new DeleteTransactionInputDTO(Integer.parseInt(maGiaoDich));
        deleteTransactionInput.deleteExecute(deleteTransactionInputDTO);
    }
}
