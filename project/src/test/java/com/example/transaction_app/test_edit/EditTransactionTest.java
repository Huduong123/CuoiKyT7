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
import com.example.usecase.EditTransaction.EditTransactionOutputDTO;
import com.example.usecase.EditTransaction.EditTransactionUseCase;

public class EditTransactionTest {
    

    //test edit nhà
    @Test
    public void testEditTransactionHouse(){
        EditTransactionInput editTransactionInput = null;
        EditTransactionViewModel editTransactionViewModel = new EditTransactionViewModel();
        EditTransactionPresenter presenter = new EditTransactionPresenter(editTransactionViewModel);
        EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
        
        editTransactionInput = new EditTransactionUseCase(presenter, editTransactionDAOMySQL);

        editTransactionInput.editExecute(getMockTransactionHouse());
        EditTransactionOutputDTO editTransactionOutputDTO = presenter.getEditTransactionOutputDTO();
    
           // test Mã giao dich
           assertEquals(getMockTransactionHouse().getMaGiaoDich(),editTransactionOutputDTO.getMaGiaoDich());

           // test Ngày giao dich
            Date expectedDate = getMockTransactionHouse().getNgayGiaoDich();
            Date actualDate = editTransactionOutputDTO.getNgayGiaoDich();
            assertEquals(expectedDate,actualDate);
   
            //Test loại giao dich
            assertEquals(getMockTransactionHouse().getLoaiGiaoDich(),editTransactionOutputDTO.getLoaiGiaoDich());
   
           // test đon giá
            assertEquals(getMockTransactionHouse().getDonGia(), editTransactionOutputDTO.getDonGia(), 0.0001);
   
           //Test diện tích
           assertEquals(getMockTransactionHouse().getDienTich(),editTransactionOutputDTO.getDienTich(), 0.0001);
   
           // test loại nhà
            assertEquals(getMockTransactionHouse().getLoaiNha(), editTransactionOutputDTO.getLoaiNha());
   
           // test địa chỉ
           assertEquals(getMockTransactionHouse().getDiaChi(), editTransactionOutputDTO.getDiaChi());
        
    
    
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

        transaction1 = new EditTransactionInputDTO(6, date1, "Nhà", 150, 70, "Cao cấp", "23 Phan Huy Ích");

        return transaction1;
    }

    //test edit nhà
    @Test
    public void testEditTransactionLand(){
        EditTransactionInput editTransactionInput = null;
             EditTransactionViewModel editTransactionViewModel = new EditTransactionViewModel();
        EditTransactionPresenter presenter = new EditTransactionPresenter(editTransactionViewModel);
        EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
        
        editTransactionInput = new EditTransactionUseCase(presenter, editTransactionDAOMySQL);

        editTransactionInput.editExecute(getMockTransactionLand());
        EditTransactionOutputDTO editTransactionOutputDTO = presenter.getEditTransactionOutputDTO();
    
         // test Mã giao dich
         assertEquals(getMockTransactionLand().getMaGiaoDich(),editTransactionOutputDTO.getMaGiaoDich());

        // test Ngày giao dich
         Date expectedDate = getMockTransactionLand().getNgayGiaoDich();
         Date actualDate = editTransactionOutputDTO.getNgayGiaoDich();
         assertEquals(expectedDate,actualDate);

         //Test loại giao dich
         assertEquals(getMockTransactionLand().getLoaiGiaoDich(),editTransactionOutputDTO.getLoaiGiaoDich());

        // test đon giá
         assertEquals(getMockTransactionLand().getDonGia(), editTransactionOutputDTO.getDonGia(), 0.0001);

        //Test diện tích
        assertEquals(getMockTransactionLand().getDienTich(),editTransactionOutputDTO.getDienTich(), 0.0001);

        // test loại nhà
         assertEquals(getMockTransactionLand().getLoaiNha(), editTransactionOutputDTO.getLoaiNha());

        // test địa chỉ
        assertEquals(getMockTransactionLand().getDiaChi(), editTransactionOutputDTO.getDiaChi());
        
    
    
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

        transaction2 = new EditTransactionInputDTO(5, date1, "Đất", 100, 50, "A");

        return transaction2;
    }
    
}
