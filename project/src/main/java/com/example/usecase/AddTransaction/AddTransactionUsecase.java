package com.example.usecase.AddTransaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class AddTransactionUsecase implements AddTransactionInput {

    private AddTransactionOutput addTransactionOutput = null;
    private AddtransactionDatabase addtransactionDatabase = null;

    public AddTransactionUsecase(AddTransactionOutput addTransactionOutput,
            AddtransactionDatabase addtransactionDatabase) {
        this.addTransactionOutput = addTransactionOutput;
        this.addtransactionDatabase = addtransactionDatabase;
    }

    @Override
    public void addExecute(AddTransactionInputDTO addTransactionInputDTO) {
        ResponseError resError = new ResponseError();
        ResponseData resData = new ResponseData();
        // Kiểm tra dữ liệu người dùng
        if (!validateInput(addTransactionInputDTO)) {
            return; 
        }

        RealEstate realEstate = null;
        int maGiaoDich = addTransactionInputDTO.getMaGiaoDich();

        // Kiểm tra xem mã giao dịch đã tồn tại chưa
        if (addtransactionDatabase.existByMaGiaoDich(maGiaoDich)) {
            resError.message = "Mã giao dich đã tồn tại !";
            resError.setStoreValue(String.valueOf(addTransactionInputDTO.getMaGiaoDich()));
            addTransactionOutput.outError(resError);
          
            return; 
        }

        
        Date ngayGiaoDich = addTransactionInputDTO.getNgayGiaoDich();
        String loaiGiaoDich = addTransactionInputDTO.getLoaiGiaoDich();
        double donGia = addTransactionInputDTO.getDonGia();
        double dienTich = addTransactionInputDTO.getDienTich();

        if (loaiGiaoDich.equals("Đất")) {
            realEstate = new Land(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    addTransactionInputDTO.getLoaiDat());
        } else {
            realEstate = new House(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    addTransactionInputDTO.getLoaiNha(), addTransactionInputDTO.getDiaChi());      
        }

    // Add the transaction
    int rowsAffected = addtransactionDatabase.addTransaction(realEstate);
    if (rowsAffected > 0) {
        // Transaction added successfully, now retrieve it
        RealEstate addedTransaction = addtransactionDatabase.getTransactionByMaGiaoDich(maGiaoDich);
        if (addedTransaction != null) {
            // Create DTO for output
            AddTransactionOutputDTO outputDTO;
            if (addedTransaction instanceof House) {
                House house = (House) addedTransaction;
                outputDTO = new AddTransactionOutputDTO(house.getMaGiaoDich(), house.getNgayGiaoDich(),
                        house.getLoaiGiaoDich(), house.getDonGia(), house.getDienTich(),
                        house.getLoaiNha(),  house.getDiaChi(), house.thanhTien());

                        System.out.println("Thêm thành công! Mã giao dịch: " + house.getMaGiaoDich() 
                        + "\nNgày giao dịch: " + house.getNgayGiaoDich()
                        + "\nLoại giao dịch: " + house.getLoaiGiaoDich()
                        + "\nĐơn giá: " + house.getDonGia()
                        + "\nDiện tích: " + house.getDienTich()
                        + "\nLoại nhà: " + house.getLoaiNha()
                        + "\nĐịa chỉ: " + house.getDiaChi()
                        + "\nThành tiền: " + house.thanhTien());
                    } else {
                Land land = (Land) addedTransaction;
                outputDTO = new AddTransactionOutputDTO(land.getMaGiaoDich(), land.getNgayGiaoDich(),
                        land.getLoaiGiaoDich(), land.getDonGia(), land.getDienTich(),
                       land.getLoaiDat(),  land.thanhTien());

                       System.out.println("Thêm thành công! Mã giao dịch: " + land.getMaGiaoDich() 
                       + "\nNgày giao dịch: " + land.getNgayGiaoDich()
                       + "\nLoại giao dịch: " + land.getLoaiGiaoDich()
                       + "\nĐơn giá: " + land.getDonGia()
                       + "\nDiện tích: " + land.getDienTich()
                       + "\nLoại nhà: " + land.getLoaiDat()
                       + "\nThành tiền: " + land.thanhTien());
            }

            resData.message = "Thêm giao dịch thành công!";
            addTransactionOutput.outResult(resData); // Gửi dữ liệu lên Presenter
            addTransactionOutput.presenter(outputDTO); // Pass the DTO to the presenter
          
        }else {
            resError.message = "Thêm giao dịch thất bại!";
            addTransactionOutput.outError(resError);
        }
    }

     

       
    }

    private boolean validateInput(AddTransactionInputDTO inputDTO) {
        ResponseError resError = new ResponseError();
        // Kiểm tra ngày giao dịch
        if (inputDTO.getNgayGiaoDich() == null) {
            resError.message = "";
            resError.setStoreValue("Bạn chưa nhập ngày");
            addTransactionOutput.outError(resError);
            
            return false;
        }

        // Chuyển đổi ngày giao dịch thành chuỗi theo định dạng
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format.format(inputDTO.getNgayGiaoDich());

        // Kiểm tra tính hợp lệ của ngày
        if (!isValidDate(dateString)) {
            resError.message = "Ngày giao dich không hợp lệ !";
            resError.setStoreValue(dateString);
            addTransactionOutput.outError(resError);
            return false;
        }

        if (inputDTO.getLoaiGiaoDich() == null || inputDTO.getLoaiGiaoDich().isEmpty()) {
            resError.message = "";
            resError.setStoreValue("Bạn chưa nhập loại giao dịch");
            addTransactionOutput.outError(resError);
            return false;
        }

        if (!isValidNumber(inputDTO.getDonGia())) {
            resError.message = "Đơn giá phải là số và lớn hơn 0 !";
            resError.setStoreValue(String.valueOf(inputDTO.getDonGia()));
            addTransactionOutput.outError(resError);
            return false;
        }

        if (!isValidNumber(inputDTO.getDienTich())) {
            resError.message = "Diện tích phải là số và lớn hơn 0 !";
            resError.setStoreValue(String.valueOf(inputDTO.getDienTich()));
            addTransactionOutput.outError(resError);
            return false;
        }


        //kiểm tra loại nhà và loại đất
        if ("Đất".equals(inputDTO.getLoaiGiaoDich())) {
            if (inputDTO.getLoaiDat() == null || inputDTO.getLoaiDat().isEmpty()) {
                resError.message = "";
                resError.setStoreValue("Bạn chưa nhập loại đất");
                addTransactionOutput.outError(resError);
                return false;
            }
        } else if ("Nhà".equals(inputDTO.getLoaiGiaoDich())) {
            if (inputDTO.getLoaiNha() == null || inputDTO.getLoaiNha().isEmpty()) {
                resError.message = "";
                resError.setStoreValue("Bạn chưa nhập loại nhà");
                addTransactionOutput.outError(resError);
                return false;
            }
            if (inputDTO.getDiaChi() == null || inputDTO.getDiaChi().isEmpty()) {
                resError.message = "";
                resError.setStoreValue("Bạn chưa nhập địa chỉ");
                addTransactionOutput.outError(resError);
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
