package com.example.transaction_app.export_test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.ExportTransactionDAOMySQL;
import com.example.ui.export_transaction.ExportTransactionPresenter;
import com.example.usecase.ExportTransaction.ExportTransactionInput;
import com.example.usecase.ExportTransaction.ExportTransactionInputDTO;
import com.example.usecase.ExportTransaction.ExportTransactionOutputDTO;
import com.example.usecase.ExportTransaction.ExportTransactionUseCase;

public class ExportTransactionTest {
      // test tìm kiếm mã giao dịch
    @Test
    public void testExportTransaction() {

        ExportTransactionDAOMySQL exportTransactionDAOMySQL = new ExportTransactionDAOMySQL();
        ExportTransactionPresenter exportTransactionPresenter = new ExportTransactionPresenter();
        ExportTransactionInput useCase = new ExportTransactionUseCase(exportTransactionPresenter, exportTransactionDAOMySQL);
        ExportTransactionInputDTO inputDTO = new ExportTransactionInputDTO(3);
        useCase.ExportData(inputDTO);

        List<ExportTransactionOutputDTO> listOutDTO = exportTransactionPresenter.getListOutputDTO();
        assertEquals("", 0, listOutDTO.size());
    }


    
}
