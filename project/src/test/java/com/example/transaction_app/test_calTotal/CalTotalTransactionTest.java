package com.example.transaction_app.test_calTotal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.CalTotalTransactionDAOMySQL;
import com.example.ui.calTotal_transaction.CalTotalTransactionPresenter;
import com.example.usecase.CalTotalTransaction.CalTotalTransactionInput;
import com.example.usecase.CalTotalTransaction.CalTotalTransactionOutputDTO;
import com.example.usecase.CalTotalTransaction.CalTotalTransactionUseCase;

public class CalTotalTransactionTest {
    
    @Test
    public void TestCalTotalLand(){
        CalTotalTransactionDAOMySQL calTotalTransactionDAOMySQL = new CalTotalTransactionDAOMySQL();
        CalTotalTransactionPresenter calTotalTransactionPresenter = new CalTotalTransactionPresenter();
        CalTotalTransactionInput calTotalTransactionInput = new CalTotalTransactionUseCase(calTotalTransactionDAOMySQL, calTotalTransactionPresenter);

        calTotalTransactionInput.calTotalExecute();

        CalTotalTransactionOutputDTO calOutputDTO = calTotalTransactionPresenter.getCalTotalOutputDTO();

         // Assert results
        assertEquals(3, calOutputDTO.getTotalLandTransactions());
        assertEquals(3, calOutputDTO.getTotalHouseTransactions());
        assertEquals(6, calOutputDTO.getTotalTransactions());
    }


}
