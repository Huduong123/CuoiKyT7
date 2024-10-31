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
import com.example.usecase.AddTransaction.AddTransactionOutputDTO;
import com.example.usecase.AddTransaction.AddTransactionUsecase;

public class AddTransactionTest {

    @SuppressWarnings("deprecation")

    //test add nhà
    @Test
    public void testAddTransactionHouse() {
 
        AddTransactionInput addTransactionInput = null;
      //  AddTransactionDetailForm addTransactionDetailForm = new AddTransactionDetailForm();

      AddTransactionViewModel addViewModel = new AddTransactionViewModel();
    AddTransactionPresenter presenter = new AddTransactionPresenter(addViewModel);
        AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();

        addTransactionInput = new AddTransactionUsecase(presenter, addTransactionDAOMySQL);
        addTransactionInput.addExecute(getMockTransactionHouse());

        AddTransactionOutputDTO addTransactionOutputDTO = presenter.getAddTransactionOutputDTO();

        // test Mã giao dich
         assertEquals(getMockTransactionHouse().getMaGiaoDich(),addTransactionOutputDTO.getMaGiaoDich());

        // test Ngày giao dich
         Date expectedDate = getMockTransactionHouse().getNgayGiaoDich();
         Date actualDate = addTransactionOutputDTO.getNgayGiaoDich();
         assertEquals(expectedDate,actualDate);

         //Test loại giao dich
         assertEquals(getMockTransactionHouse().getLoaiGiaoDich(),addTransactionOutputDTO.getLoaiGiaoDich());

        // test đon giá
         assertEquals(getMockTransactionHouse().getDonGia(), addTransactionOutputDTO.getDonGia(), 0.0001);

        //Test diện tích
        assertEquals(getMockTransactionHouse().getDienTich(),addTransactionOutputDTO.getDienTich(), 0.0001);

        // test loại nhà
         assertEquals(getMockTransactionHouse().getLoaiNha(), addTransactionOutputDTO.getLoaiNha());

        // test địa chỉ
        assertEquals(getMockTransactionHouse().getDiaChi(), addTransactionOutputDTO.getDiaChi());
    }

    private AddTransactionInputDTO getMockTransactionHouse() {
        AddTransactionInputDTO transaction1 = null;
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

        transaction1 = new AddTransactionInputDTO(5, date1, "Nhà", 100, 50, "Cao cấp", "23 Phan Huy Ích");

        return transaction1;
    }


    //test add Đất
    @Test
    public void testAddTransactionLand() {

        AddTransactionInput addTransactionInput = null;
        
        AddTransactionViewModel addViewModel = new AddTransactionViewModel();
        AddTransactionPresenter presenter = new AddTransactionPresenter(addViewModel);
        AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();

        addTransactionInput = new AddTransactionUsecase(presenter, addTransactionDAOMySQL);
        addTransactionInput.addExecute(getMockTransactionLand());

        AddTransactionOutputDTO addTransactionOutputDTO = presenter.getAddTransactionOutputDTO();

        //test Mã giao dich
         assertEquals(getMockTransactionLand().getMaGiaoDich(),addTransactionOutputDTO.getMaGiaoDich());

        // test Ngày giao dich
         Date expectedDate = getMockTransactionHouse().getNgayGiaoDich();
         Date actualDate = addTransactionOutputDTO.getNgayGiaoDich();
         assertEquals(expectedDate,actualDate);

        //test loại giao dịch
        assertEquals(getMockTransactionLand().getLoaiGiaoDich(),addTransactionOutputDTO.getLoaiGiaoDich());

        // test đon giá
         assertEquals(getMockTransactionLand().getDonGia(),addTransactionOutputDTO.getDonGia(), 0.0001);

        //test diện tích
         assertEquals(getMockTransactionLand().getDienTich(),addTransactionOutputDTO.getDienTich(), 0.0001);

         //test loại đất
         assertEquals(getMockTransactionLand().getLoaiDat(),addTransactionOutputDTO.getLoaiDat());
    }

    private AddTransactionInputDTO getMockTransactionLand() {
        AddTransactionInputDTO transaction1 = null;
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

        transaction1 = new AddTransactionInputDTO(140, date1, "Đất", 100, 50, "A");

        return transaction1;
    }
    



}
