package com.example.transaction_app.test_edit;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.EditTransactionDAOMySQL;
import com.example.ui.edit_transaction.EditTransactionPresenter;
import com.example.ui.edit_transaction.EditTransactionViewModel;
import com.example.usecase.EditTransaction.EditTransactionInput;
import com.example.usecase.EditTransaction.EditTransactionInputDTO;
import com.example.usecase.EditTransaction.EditTransactionUseCase;
import com.example.usecase.ResponseError;



public class EditTransactionErrorTest {
     @Test
    public void testEditTransactionError() {

        EditTransactionInput editTransactionInput = null;
     
        EditTransactionViewModel editTransactionViewModel = new EditTransactionViewModel();
        EditTransactionPresenter presenter = new EditTransactionPresenter(editTransactionViewModel);
       EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
        editTransactionInput = new  EditTransactionUseCase(presenter, editTransactionDAOMySQL);

        // Test Ngày giao dich
        EditTransactionInputDTO invalidTransactionDate = new EditTransactionInputDTO(108, null, "Nhà", 100, 50, "Cao cấp","23 Phan Huy Ích");
        editTransactionInput.editExecute(invalidTransactionDate);

        // test Loại giao dịch
        EditTransactionInputDTO invalidTransactionGD = new EditTransactionInputDTO(108, new Date(), "", 100, 50,"Cao Cấp", "23 Phan Huy Ích");
        //editTransactionInput.editExecute(invalidTransactionGD);
       
        // test Loại đất 
        EditTransactionInputDTO invalidTransactionLand = new EditTransactionInputDTO(108, new Date(), "Đất", 100, 50, "");
        //editTransactionInput.editExecute(invalidTransactionLand);
      
        // test Loại nhà
        EditTransactionInputDTO invalidTransactionHouse = new EditTransactionInputDTO(108, new Date(), "Nhà", 100, 50, "","23 Phan Huy Ích");
        //editTransactionInput.editExecute(invalidTransactionHouse);
      
        // test địa chỉ
        EditTransactionInputDTO invalidTransactionAddress = new EditTransactionInputDTO(108, new Date(), "Nhà", 100, 50, "Cap cấp", "");
       // editTransactionInput.editExecute(invalidTransactionAddress);
        ResponseError error = presenter.getResError();
        assertEquals("", error.getMessage());
    }

    // test dơn giá
    @Test
    public void testAddTransactionDonGia() {

        EditTransactionInput editTransactionInput = null;
        EditTransactionViewModel editTransactionViewModel = new EditTransactionViewModel();
        EditTransactionPresenter presenter = new EditTransactionPresenter(editTransactionViewModel);
       EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
        editTransactionInput = new  EditTransactionUseCase(presenter, editTransactionDAOMySQL);

        EditTransactionInputDTO invalidTransaction = new EditTransactionInputDTO(108, new Date(), "Nhà", -1, 50,"Cao cấp", "23 Phan Huy Ích");

        editTransactionInput.editExecute(invalidTransaction);
        ResponseError error = presenter.getResError();
        assertEquals("Đơn giá phải là số và lớn hơn 0 !", error.getMessage());
    }

    // test diện tích
    @Test
    public void testAddTransactionDienTich() {

        EditTransactionInput editTransactionInput = null;
     
        EditTransactionViewModel editTransactionViewModel = new EditTransactionViewModel();
        EditTransactionPresenter presenter = new EditTransactionPresenter(editTransactionViewModel);
       EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
        editTransactionInput = new  EditTransactionUseCase(presenter, editTransactionDAOMySQL);

        EditTransactionInputDTO invalidTransaction = new EditTransactionInputDTO(108, new Date(), "Nhà", 100, -2,"Cao cấp", "23 Phan Huy Ích");

        editTransactionInput.editExecute(invalidTransaction);
        ResponseError error = presenter.getResError();
        assertEquals("Diện tích phải là số và lớn hơn 0 !", error.getMessage());
    }

    private EditTransactionInputDTO getMockTransactionError() {
        Calendar calendar = Calendar.getInstance();

        // Đặt ngày, tháng, năm
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // Đặt giờ, phút, giây, mili giây (nếu cần)
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // Tạo đối tượng Date từ Calendar
        Date date = calendar.getTime();

        // Tạo đối tượng AddTransactionInputDTO với địa chỉ để trống
        return new EditTransactionInputDTO(200, date, "", 100, 500, "A", ""); // Địa chỉ để trống
    }
}
