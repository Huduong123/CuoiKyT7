package com.example.ui.add_transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.usecase.AddTransaction.AddTransactionInput;
import com.example.usecase.AddTransaction.AddTransactionInputDTO;

public class AddTransactionController {
    private AddTransactionInput addTransactionInput = null;

    public AddTransactionController(AddTransactionInput addTransactionInput) {
        this.addTransactionInput = addTransactionInput;
    }

    public void addTransactionLand(String maGiaoDich, String date, String loaiGiaoDich, String donGia, String dienTich, String loaiDat){
   
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      AddTransactionInputDTO addTransactionInputDTO = null;

      try {
        addTransactionInputDTO = new AddTransactionInputDTO(Integer.parseInt(maGiaoDich),
          simpleDateFormat.parse(date),
        loaiGiaoDich,
        Double.parseDouble(donGia),
        Double.parseDouble(dienTich),
        loaiDat);
      } catch (NumberFormatException e) {
       
        return;
    } catch (ParseException e) {
      
        return;
    }
    if (addTransactionInputDTO != null) {
      addTransactionInput.addExecute(addTransactionInputDTO);
  }
    }

    public void addTransactionHouse(String maGiaoDich, String date, String loaiGiaoDich, String donGia, String dienTich, String loaiNha, String diaChi){

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      AddTransactionInputDTO addTransactionInputDTO = null;

      try {
        addTransactionInputDTO = new AddTransactionInputDTO(Integer.parseInt(maGiaoDich), simpleDateFormat.parse(date),
        loaiGiaoDich,
        Double.parseDouble(donGia),
        Double.parseDouble(dienTich),
        loaiNha, diaChi);
      } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    if (addTransactionInputDTO != null) {
      addTransactionInput.addExecute(addTransactionInputDTO);
    }
  }
}
