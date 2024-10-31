package com.example.transaction_app.test_add;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Main.AddTransactionDAOMySQL;
import com.example.ui.add_transaction.AddTransactionPresenter;
import com.example.ui.add_transaction.AddTransactionViewModel;
import com.example.usecase.AddTransaction.AddTransactionInput;
import com.example.usecase.AddTransaction.AddTransactionInputDTO;
import com.example.usecase.AddTransaction.AddTransactionUsecase;
import com.example.usecase.ResponseError;

public class AddTransactionErrorTest {

    // test mã giao dịch
    @Test
    public void testAddTransactionMaGD() {
        AddTransactionInput addTransactionInput = null;

        AddTransactionViewModel addViewModel = new AddTransactionViewModel();
        AddTransactionPresenter presenter = new AddTransactionPresenter(addViewModel);
        AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();

        addTransactionInput = new AddTransactionUsecase(presenter, addTransactionDAOMySQL);
        AddTransactionInputDTO invalidTransaction = new AddTransactionInputDTO(1, new Date(), "Nhà", 100, 50, "Cao cấp",
                "23 Phan Huy Ích");

        addTransactionInput.addExecute(invalidTransaction);
        ResponseError error = presenter.getResError();

        assertEquals("Mã giao dich đã tồn tại !", error.getMessage());
    }

    @Test
    public void testAddTransactionError() {

        AddTransactionInput addTransactionInput = null;
        AddTransactionViewModel addViewModel = new AddTransactionViewModel();
        AddTransactionPresenter presenter = new AddTransactionPresenter(addViewModel);
        AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();
        addTransactionInput = new AddTransactionUsecase(presenter, addTransactionDAOMySQL);

        // Test Ngày giao dich
        AddTransactionInputDTO invalidTransactionDate = new AddTransactionInputDTO(108, null, "Nhà", 100, 50, "Cao cấp","23 Phan Huy Ích");
        // test Loại giao dịch
        AddTransactionInputDTO invalidTransactionGD = new AddTransactionInputDTO(108, new Date(), "", 100, 50,"Cao Cấp", "23 Phan Huy Ích");
        // test Loại đất
        AddTransactionInputDTO invalidTransactionLand = new AddTransactionInputDTO(108, new Date(), "Đất", 100, 50, "");
        // test Loại nhà
        AddTransactionInputDTO invalidTransactionHouse = new AddTransactionInputDTO(108, new Date(), "Nhà", 100, 50, "","23 Phan Huy Ích");
        // test địa chỉ
        AddTransactionInputDTO invalidTransactionAddress = new AddTransactionInputDTO(108, new Date(), "Nhà", 100, 50, "Cap cấp", "");
        addTransactionInput.addExecute(invalidTransactionDate);
        ResponseError error = presenter.getResError();
        assertEquals("", error.getMessage());
    }

    // test dơn giá
    @Test
    public void testAddTransactionDonGia() {

        AddTransactionInput addTransactionInput = null;
        AddTransactionViewModel addViewModel = new AddTransactionViewModel();
        AddTransactionPresenter presenter = new AddTransactionPresenter(addViewModel);
        AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();
        addTransactionInput = new AddTransactionUsecase(presenter, addTransactionDAOMySQL);

        AddTransactionInputDTO invalidTransaction = new AddTransactionInputDTO(108, new Date(), "Nhà", -1, 50,"Cao cấp", "23 Phan Huy Ích");

        addTransactionInput.addExecute(invalidTransaction);
        ResponseError error = presenter.getResError();
        assertEquals("Đơn giá phải là số và lớn hơn 0 !", error.getMessage());
    }

    // test diện tích
    @Test
    public void testAddTransactionDienTich() {

        AddTransactionInput addTransactionInput = null;
        AddTransactionViewModel addViewModel = new AddTransactionViewModel();
        AddTransactionPresenter presenter = new AddTransactionPresenter(addViewModel);
        AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();
        addTransactionInput = new AddTransactionUsecase(presenter, addTransactionDAOMySQL);

        AddTransactionInputDTO invalidTransaction = new AddTransactionInputDTO(108, new Date(), "Nhà", 100, -2,"Cao cấp", "23 Phan Huy Ích");

        addTransactionInput.addExecute(invalidTransaction);
        ResponseError error = presenter.getResError();
        assertEquals("Diện tích phải là số và lớn hơn 0 !", error.getMessage());
    }

    private AddTransactionInputDTO getMockTransactionError() {
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
        return new AddTransactionInputDTO(200, date, "", 100, 500, "A", ""); // Địa chỉ để trống
    }
}
