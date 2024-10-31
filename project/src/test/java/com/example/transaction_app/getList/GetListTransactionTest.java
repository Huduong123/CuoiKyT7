package com.example.transaction_app.getList;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.GetListTransactionDAOMySQL;
import com.example.ui.TransactionFormView;
import com.example.ui.get_listTransaction.GetListTransactionPresenter;
import com.example.usecase.GetListTransaction.GetListTransactionInput;
import com.example.usecase.GetListTransaction.GetListTransactionOutputDTO;
import com.example.usecase.GetListTransaction.GetListTransactionUseCase;

public class GetListTransactionTest {
    
    @Test
    public void getListTransaction(){
        TransactionFormView transactionFormView = new TransactionFormView();
        GetListTransactionDAOMySQL daoMySQL = new GetListTransactionDAOMySQL();
       
     
        GetListTransactionPresenter getListTransactionPresenter = new GetListTransactionPresenter(transactionFormView);

        GetListTransactionInput input = new GetListTransactionUseCase(getListTransactionPresenter, daoMySQL);
    
        input.getListExecute();
        
        List<GetListTransactionOutputDTO> listOutDTO = getListTransactionPresenter.getListOutputDTO();
        

        assertEquals(6, listOutDTO.size());
    }

     
}
