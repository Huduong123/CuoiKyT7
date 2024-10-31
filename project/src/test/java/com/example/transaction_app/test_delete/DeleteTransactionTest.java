package com.example.transaction_app.test_delete;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.DeleteTransactionDAOMySQL;
import com.example.ui.delete_transaction.DeleteTransactionPresenter;
import com.example.ui.delete_transaction.DeleteTransactionViewModel;
import com.example.usecase.DeleteTransaction.DeleteTransactionInput;
import com.example.usecase.DeleteTransaction.DeleteTransactionInputDTO;
import com.example.usecase.DeleteTransaction.DeleteTransactionOutputDTO;
import com.example.usecase.DeleteTransaction.DeleteTransactionUseCase;



public class DeleteTransactionTest {
     //test edit nhà
    @Test
    public void testDeleteTransaction(){
       
        DeleteTransactionViewModel deleteTransactionViewModel = new DeleteTransactionViewModel();
        DeleteTransactionPresenter deleteTransactionPresenter = new DeleteTransactionPresenter(deleteTransactionViewModel);
        DeleteTransactionDAOMySQL deleteTransactionDAOMySQL = new DeleteTransactionDAOMySQL();
        
        DeleteTransactionInput useCase = new DeleteTransactionUseCase(deleteTransactionPresenter, deleteTransactionDAOMySQL);

        useCase.deleteExecute(getMockTransactionHouse());
        DeleteTransactionOutputDTO deleteTransactionOutputDTO = deleteTransactionPresenter.getDeleteTransactionOutputDTO();
    
           // test Mã giao dich
           assertEquals(getMockTransactionHouse().getMaGiaoDich(),deleteTransactionOutputDTO.getMaGiaoDich());

   
        
    
    
    }
      private DeleteTransactionInputDTO getMockTransactionHouse() {
        DeleteTransactionInputDTO transaction1 = null;
        transaction1 = new DeleteTransactionInputDTO(5);

        return transaction1;
    }
}
