package com.example.transaction_app.test_edit;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.EditTransactionDAOMySQL;
import com.example.ui.edit_transaction.EditTransactionPresenter;
import com.example.usecase.EditTransaction.EditTransactionInput;
import com.example.usecase.EditTransaction.EditTransactionInputDTO;
import com.example.usecase.EditTransaction.EditTransactionOutputDTO;
import com.example.usecase.EditTransaction.EditTransactionUseCase;

public class EditTransactionTest {
    

    //test edit nhà
    @Test
    public void testEditTransactionHouse(){
        EditTransactionInput editTransactionInput = null;
        EditTransactionPresenter presenter = new EditTransactionPresenter();
        EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
        
        editTransactionInput = new EditTransactionUseCase(presenter, editTransactionDAOMySQL);

        editTransactionInput.editExecute(getMockTransactionHouse());
        EditTransactionOutputDTO editTransactionOutputDTO = presenter.getEditTransactionOutputDTO();
    
        //test Mã giao dich
        assertEquals(getMockTransactionHouse().getMaGiaoDich(), editTransactionOutputDTO.getMaGiaoDich());
        
    
    
    }

    private EditTransactionInputDTO getMockTransactionHouse() {
        EditTransactionInputDTO transaction1 = null;
        Calendar calendar1 = Calendar.getInstance();

        // Đặt ngày, tháng, năm
        calendar1.set(Calendar.YEAR, 1984);
        calendar1.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar1.set(Calendar.DAY_OF_MONTH, 13);
        // Đặt giờ, phút, giây, mili giây (nếu cần)
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        // Tạo đối tượng Date từ Calendar
        Date date1 = calendar1.getTime();

        transaction1 = new EditTransactionInputDTO(130, date1, "Nhà", 100, 50, "Cao cấp", "23 Phan Huy Ích");

        return transaction1;
    }

        private EditTransactionInputDTO getMockTransactionLand() {
        EditTransactionInputDTO transaction2 = null;
        Calendar calendar1 = Calendar.getInstance();

        // Đặt ngày, tháng, năm
        calendar1.set(Calendar.YEAR, 1984);
        calendar1.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar1.set(Calendar.DAY_OF_MONTH, 13);
        // Đặt giờ, phút, giây, mili giây (nếu cần)
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        // Tạo đối tượng Date từ Calendar
        Date date1 = calendar1.getTime();

        transaction2 = new EditTransactionInputDTO(140, date1, "Đất", 100, 50, "A");

        return transaction2;
    }
    
}
