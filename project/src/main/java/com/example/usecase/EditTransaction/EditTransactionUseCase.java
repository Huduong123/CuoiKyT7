package com.example.usecase.EditTransaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;


public class EditTransactionUseCase implements  EditTransactionInput{

    private EditTransactionOutput editTransactionOutput = null;
    private EditTransactionDatabase editTransactionDatabase = null;
    
   

    public EditTransactionUseCase(EditTransactionOutput editTransactionOutput,
            EditTransactionDatabase editTransactionDatabase) {
        this.editTransactionOutput = editTransactionOutput;
        this.editTransactionDatabase = editTransactionDatabase;
    }

    @Override
    public void editExecute(EditTransactionInputDTO editTransactionInputDTO) {
        ResponseError resError = new ResponseError();
        ResponseData resData = new ResponseData();

          // Kiểm tra dữ liệu người dùng
          if (!validateInput(editTransactionInputDTO)) {
            return; 
        }

           RealEstate realEstate = null;
        int maGiaoDich = editTransactionInputDTO.getMaGiaoDich();

        // Kiểm tra xem mã giao dịch đã tồn tại chưa
        if (editTransactionDatabase.existByMaGiaoDich(maGiaoDich)) {
      
                
        Date ngayGiaoDich = editTransactionInputDTO.getNgayGiaoDich();
        String loaiGiaoDich = editTransactionInputDTO.getLoaiGiaoDich();
        double donGia = editTransactionInputDTO.getDonGia();
        double dienTich = editTransactionInputDTO.getDienTich();

        if (loaiGiaoDich.equals("Đất")) {
            realEstate = new Land(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    editTransactionInputDTO.getLoaiDat());
        } else {
            realEstate = new House(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    editTransactionInputDTO.getLoaiNha(), editTransactionInputDTO.getDiaChi());      
        }


   // Add the transaction
    int rowsAffected = editTransactionDatabase.editTransaction(realEstate);
    if (rowsAffected > 0) {
        // Transaction added successfully, now retrieve it
        RealEstate editTransaction = editTransactionDatabase.getTransactionByMaGiaoDich(maGiaoDich);
        if (editTransaction != null) {
            // Create DTO for output
            EditTransactionOutputDTO outputDTO;
            if (editTransaction instanceof House) {
                House house = (House) editTransaction;

               
                outputDTO = new EditTransactionOutputDTO(house.getMaGiaoDich(), house.getNgayGiaoDich(),
                        house.getLoaiGiaoDich(), house.getDonGia(), house.getDienTich(),
                        house.getLoaiNha(),  house.getDiaChi(), house.thanhTien());

                        System.out.println("Sửa thành công! Mã giao dịch: " + house.getMaGiaoDich() 
                        + "\nNgày giao dịch: " + house.getNgayGiaoDich()
                        + "\nLoại giao dịch: " + house.getLoaiGiaoDich()
                        + "\nĐơn giá: " + house.getDonGia()
                        + "\nDiện tích: " + house.getDienTich()
                        + "\nLoại nhà: " + house.getLoaiNha()
                        + "\nĐịa chỉ: " + house.getDiaChi()
                        + "\nThành tiền: " + house.thanhTien());
                    } else {
                Land land = (Land) editTransaction;
                outputDTO = new EditTransactionOutputDTO(land.getMaGiaoDich(), land.getNgayGiaoDich(),
                        land.getLoaiGiaoDich(), land.getDonGia(), land.getDienTich(),
                       land.getLoaiDat(),  land.thanhTien());

                       System.out.println("Sửa thành công! Mã giao dịch: " + land.getMaGiaoDich() 
                       + "\nNgày giao dịch: " + land.getNgayGiaoDich()
                       + "\nLoại giao dịch: " + land.getLoaiGiaoDich()
                       + "\nĐơn giá: " + land.getDonGia()
                       + "\nDiện tích: " + land.getDienTich()
                       + "\nLoại nhà: " + land.getLoaiDat()
                       + "\nThành tiền: " + land.thanhTien());
            }

            resData.message = "Sừa giao dịch thành công!";
            editTransactionOutput.outResult(resData); // Gửi dữ liệu lên Presenter
            editTransactionOutput.presenter(outputDTO); // Pass the DTO to the presenter
          
        }else {
            resError.message = "Sửa giao dịch thất bại!";
            editTransactionOutput.outError(resError);
        }
    }
       
        }

      


    }
        private boolean validateInput(EditTransactionInputDTO inputDTO) {
        ResponseError resError = new ResponseError();
        // Kiểm tra ngày giao dịch
        if (inputDTO.getNgayGiaoDich() == null) {
            resError.message = "";
            resError.setStoreValue("Bạn chưa nhập ngày");
            editTransactionOutput.outError(resError);
            
            return false;
        }

        // Chuyển đổi ngày giao dịch thành chuỗi theo định dạng
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format.format(inputDTO.getNgayGiaoDich());

        // Kiểm tra tính hợp lệ của ngày
        if (!isValidDate(dateString)) {
            resError.message = "Ngày giao dich không hợp lệ !";
            resError.setStoreValue(dateString);
            editTransactionOutput.outError(resError);
            return false;
        }

        if (inputDTO.getLoaiGiaoDich() == null || inputDTO.getLoaiGiaoDich().isEmpty()) {
            resError.message = "";
            resError.setStoreValue("Bạn chưa nhập loại giao dịch");
            editTransactionOutput.outError(resError);
            return false;
        }

        if (!isValidNumber(inputDTO.getDonGia())) {
            resError.message = "Đơn giá phải là số và lớn hơn 0 !";
            resError.setStoreValue(String.valueOf(inputDTO.getDonGia()));
            editTransactionOutput.outError(resError);
            return false;
        }

        if (!isValidNumber(inputDTO.getDienTich())) {
            resError.message = "Diện tích phải là số và lớn hơn 0 !";
            resError.setStoreValue(String.valueOf(inputDTO.getDienTich()));
            editTransactionOutput.outError(resError);
            return false;
        }


        //kiểm tra loại nhà và loại đất
        if ("Đất".equals(inputDTO.getLoaiGiaoDich())) {
            if (inputDTO.getLoaiDat() == null || inputDTO.getLoaiDat().isEmpty()) {
                resError.message = "";
                resError.setStoreValue("Bạn chưa nhập loại đất");
                editTransactionOutput.outError(resError);
                return false;
            }
        } else if ("Nhà".equals(inputDTO.getLoaiGiaoDich())) {
            if (inputDTO.getLoaiNha() == null || inputDTO.getLoaiNha().isEmpty()) {
                resError.message = "";
                resError.setStoreValue("Bạn chưa nhập loại nhà");
                editTransactionOutput.outError(resError);
                return false;
            }
            if (inputDTO.getDiaChi() == null || inputDTO.getDiaChi().isEmpty()) {
                resError.message = "";
                resError.setStoreValue("Bạn chưa nhập địa chỉ");
                editTransactionOutput.outError(resError);
                return false;
            }
        }
        return true;
    }

    private boolean isValidNumber(double value) {
        return value > 0;
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
