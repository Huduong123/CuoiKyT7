package com.example.ui.search_transaction;

import javax.swing.JOptionPane;

import com.example.usecase.SearchTransaction.SearchTransactionInput;
import com.example.usecase.SearchTransaction.SearchTransactionInputDTO;

public class SearchTransactionController {
    
    private SearchTransactionInput searchTransactionInput = null;

    public SearchTransactionController(SearchTransactionInput searchTransactionInput) {
        this.searchTransactionInput = searchTransactionInput;
    }

    public SearchTransactionInput getSearchTransactionInput() {
        return searchTransactionInput;
    }

     public void getMaGiaoDich(String maGiaoDich){


        try {
            int id = Integer.parseInt(maGiaoDich);
            SearchTransactionInputDTO searchTransactionInputDTO = new SearchTransactionInputDTO(id);
            searchTransactionInput.searchExecute(searchTransactionInputDTO);
        } catch (NumberFormatException e) {
            System.out.println("Mã giao dịch không hợp lệ. Vui lòng nhập lại.");
              JOptionPane.showMessageDialog(null, "Mã giao dịch không hợp lệ. Vui lòng nhập lại.", maGiaoDich, JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
