package com.example.ui.edit_transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.usecase.EditTransaction.EditTransactionInput;
import com.example.usecase.EditTransaction.EditTransactionInputDTO;


public class EditTransactionController {
    private EditTransactionInput editTransactionInput = null;

    public EditTransactionController(EditTransactionInput editTransactionInput) {
        this.editTransactionInput = editTransactionInput;
    }
    
 public void editTransactionLand(String maGiaoDich, String date, String loaiGiaoDich, String donGia, String dienTich, String loaiDat){
   
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      EditTransactionInputDTO editTransactionInputDTO = null;

      try {
        editTransactionInputDTO = new EditTransactionInputDTO(Integer.parseInt(maGiaoDich),
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
    if (editTransactionInputDTO != null) {
      editTransactionInput.editExecute(editTransactionInputDTO);
  }
    }

    public void editTransactionHouse(String maGiaoDich, String date, String loaiGiaoDich, String donGia, String dienTich, String loaiNha, String diaChi){

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      EditTransactionInputDTO editTransactionInputDTO = null;

      try {
        editTransactionInputDTO = new EditTransactionInputDTO(Integer.parseInt(maGiaoDich), simpleDateFormat.parse(date),
        loaiGiaoDich,
        Double.parseDouble(donGia),
        Double.parseDouble(dienTich),
        loaiNha, diaChi);
      } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    if (editTransactionInputDTO != null) {
        editTransactionInput.editExecute(editTransactionInputDTO);
    }
  }

}
