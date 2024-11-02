package com.example.transaction_app.test_calAverage;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.CalAverageTransactionDAOMySQL;
import com.example.ui.calAverage_transaction.CalAverageTranPresenter;
import com.example.usecase.CalAverageTransaction.CalAverageTransactionInput;
import com.example.usecase.CalAverageTransaction.CalAverageTransactionOutputDTO;
import com.example.usecase.CalAverageTransaction.CalAverageTransactionUseCase;

public class CalAverageTest {
    

    @Test
    public void TestCalAverageLand(){
        CalAverageTransactionDAOMySQL calDAOMySQL = new CalAverageTransactionDAOMySQL();
        CalAverageTranPresenter calAverageTranPresenter = new CalAverageTranPresenter();
        CalAverageTransactionInput calUseCase = new CalAverageTransactionUseCase(calAverageTranPresenter, calDAOMySQL);

        calUseCase.calAverageExecute();

        CalAverageTransactionOutputDTO calOutputDTO = calAverageTranPresenter.getOutputDTO();


        double expectedAverage = 45666.666666666664; // Replace with expected value based on known data in the database
        assertEquals("Giá trị trung bình được tính toán phải khớp với giá trị mong đợ", expectedAverage, calOutputDTO.getCalAverage(), 0.001);
    }
}
