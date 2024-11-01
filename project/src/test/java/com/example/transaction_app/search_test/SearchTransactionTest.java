package com.example.transaction_app.search_test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.SearchTransactionDAOMySQL;
import com.example.ui.TransactionFormView;
import com.example.ui.search_transaction.SearchTransactionPresenter;
import com.example.ui.search_transaction.SearchTransactionView;
import com.example.usecase.ResponseError;
import com.example.usecase.SearchTransaction.SearchTransactionInput;
import com.example.usecase.SearchTransaction.SearchTransactionInputDTO;
import com.example.usecase.SearchTransaction.SearchTransactionOutputDTO;
import com.example.usecase.SearchTransaction.SearchTransactionUseCase;

public class SearchTransactionTest {
    // test tìm kiếm mã giao dịch
    @Test
    public void testSearchTransaction() {

        SearchTransactionView searchTransactionView = new SearchTransactionView();
        SearchTransactionPresenter searchTransactionPresenter = new SearchTransactionPresenter(searchTransactionView);
        SearchTransactionDAOMySQL searchTransactionDAOMySQL = new SearchTransactionDAOMySQL();

        SearchTransactionInput searchTransactionInput = new SearchTransactionUseCase(searchTransactionDAOMySQL,
                searchTransactionPresenter);
        SearchTransactionInputDTO inputDTO = new SearchTransactionInputDTO(4);

        searchTransactionInput.searchExecute(inputDTO);

        List<SearchTransactionOutputDTO> listOutDTO = searchTransactionPresenter.getListOutputDTO();

        assertEquals("", 1, listOutDTO.size());

    }
 // Test kiểm tra lỗi khi nhập mã giao dịch không tồn tại
    @Test
    public void testSearchTransactionWithInvalidID() {
        SearchTransactionView searchTransactionView = new SearchTransactionView();
        SearchTransactionPresenter searchTransactionPresenter = new SearchTransactionPresenter(searchTransactionView);
        SearchTransactionDAOMySQL searchTransactionDAOMySQL = new SearchTransactionDAOMySQL();

        SearchTransactionInput searchTransactionInput = new SearchTransactionUseCase(searchTransactionDAOMySQL,
                searchTransactionPresenter);

        SearchTransactionInputDTO inputDTO = new SearchTransactionInputDTO(9999);

        searchTransactionInput.searchExecute(inputDTO);

        ResponseError responseError = searchTransactionPresenter.getResError();

        assertEquals("Mã giao dịch: 9999 không tồn tại!", responseError.getMessage());

    }
}
