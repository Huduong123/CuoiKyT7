package com.example.transaction_app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.database.Test.GetListTransactionDAOMemory;
import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.ui.TransactionFormView;
import com.example.ui.get_listTransaction.GetListTransactionPresenter;
import com.example.usecase.GetListTransaction.GetListTransactionInput;
import com.example.usecase.GetListTransaction.GetListTransactionOutputDTO;
import com.example.usecase.GetListTransaction.GetListTransactionUseCase;

public class GetListTransactionTest {
    
    @Test
    public void getListTransaction(){
        TransactionFormView transactionFormView = new TransactionFormView();
       // GetListTransactionDAOMySQL daoMySQL = new GetListTransactionDAOMySQL();
       
        GetListTransactionDAOMemory getListTransactionDAOMemory = new GetListTransactionDAOMemory(getData());
        GetListTransactionPresenter getListTransactionPresenter = new GetListTransactionPresenter(transactionFormView);

        GetListTransactionInput input = new GetListTransactionUseCase(getListTransactionPresenter, getListTransactionDAOMemory);
    
        input.getListExecute();
        
        

        List<GetListTransactionOutputDTO> listOutDTO = getListTransactionPresenter.getListOutputDTO();
        

        assertEquals(7, listOutDTO.size());
    }

      private List<RealEstate> getData(){
        List<RealEstate> list = new ArrayList<>();
        Calendar calendar1 = Calendar.getInstance();
        
        // Đặt ngày, tháng, năm
        calendar1.set(Calendar.YEAR, 1984);
        calendar1.set(Calendar.MONTH, Calendar.NOVEMBER); // Tháng 11 (0 là tháng 1)
        calendar1.set(Calendar.DAY_OF_MONTH, 13);
        
        // Tạo đối tượng Date từ Calendar
        Date date1 = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        
        // Đặt ngày, tháng, năm
        calendar2.set(Calendar.YEAR, 2000);
        calendar2.set(Calendar.MONTH, Calendar.SEPTEMBER); // Tháng 11 (0 là tháng 1)
        calendar2.set(Calendar.DAY_OF_MONTH, 9);
        
        // Tạo đối tượng Date từ Calendar
        Date date2 = calendar2.getTime();

        Calendar calendar3 = Calendar.getInstance();
        
        // Đặt ngày, tháng, năm
        calendar3.set(Calendar.YEAR, 2001);
        calendar3.set(Calendar.MONTH, Calendar.AUGUST); // Tháng 11 (0 là tháng 1)
        calendar3.set(Calendar.DAY_OF_MONTH, 8);
        
        // Tạo đối tượng Date từ Calendar
        Date date3 = calendar1.getTime();

        Calendar calendar4 = Calendar.getInstance();
        
        // Đặt ngày, tháng, năm
        calendar4.set(Calendar.YEAR, 2002);
        calendar4.set(Calendar.MONTH, Calendar.JANUARY); // Tháng 11 (0 là tháng 1)
        calendar4.set(Calendar.DAY_OF_MONTH, 1);
        
        // Tạo đối tượng Date từ Calendar
        Date date4 = calendar1.getTime();

        
        list.add(new House(10, date1, "Nhà", 100, 50, "Cao cấp", "123 Nguyễn Kiệm"));
        list.add(new Land(11, date2, "Đất", 150, 70, "A"));
        list.add(new House(12, date3, "Nhà", 200, 100, "Thường", "345 Phan Huy Ích"));
        list.add(new Land(13, date4, "Đất", 250, 150, "B"));
        list.add(new House(14, date3, "Nhà", 200, 100, "Thường", "345 Phan Huy Ích"));
        list.add(new Land(15, date4, "Đất", 250, 150, "B"));
        list.add(new Land(16, date4, "Đất", 250, 150, "B"));
        return list;
    }
}
