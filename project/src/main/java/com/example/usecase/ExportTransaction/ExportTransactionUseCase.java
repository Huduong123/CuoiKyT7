package com.example.usecase.ExportTransaction;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class ExportTransactionUseCase implements  ExportTransactionInput{

    private ExportTransactionOutput exportTransactionOutput = null;
    private ExportTransactionDatabase exportTransactionDatabase = null;

    
    public ExportTransactionUseCase(ExportTransactionOutput exportTransactionOutput,
            ExportTransactionDatabase exportTransactionDatabase) {
        this.exportTransactionOutput = exportTransactionOutput;
        this.exportTransactionDatabase = exportTransactionDatabase;
    }


    @Override
    public void ExportData(ExportTransactionInputDTO exInputDTO) {
      ResponseData resData  = new ResponseData();
      ResponseError resError = new ResponseError();


      int month = exInputDTO.getMonth();
      List<RealEstate> realEstatesList = exportTransactionDatabase.getTransactionByMonth(month);
   
      if(realEstatesList == null || realEstatesList.isEmpty()){
        resError.setMessage("Không tìm thấy giao dịch với tháng: " + month);
        exportTransactionOutput.outError(resError);
      }
    
      List<ExportTransactionOutputDTO> outputDTOList = new ArrayList<>();

      for(RealEstate realEstate : realEstatesList){
        if (realEstate instanceof Land) {
                Land land = (Land) realEstate;
                outputDTOList.add(new ExportTransactionOutputDTO(
                        land.getMaGiaoDich(), land.getNgayGiaoDich(), land.getLoaiGiaoDich(),
                        land.getDonGia(), land.getDienTich(), land.getLoaiDat(), land.thanhTien()));
            } else if (realEstate instanceof House) {
                House house = (House) realEstate;
                outputDTOList.add(new ExportTransactionOutputDTO(
                        house.getMaGiaoDich(), house.getNgayGiaoDich(), house.getLoaiGiaoDich(),
                        house.getDonGia(), house.getDienTich(), house.getLoaiNha(), house.getDiaChi(),
                        house.thanhTien()));
            }
      }

      resData.setDataExportList(outputDTOList);
      resData.setMessage("Tìm kiếm thành công giao dịch thành công với tháng là: " + month);
      exportTransactionOutput.outResult(resData);
    }
    
}
