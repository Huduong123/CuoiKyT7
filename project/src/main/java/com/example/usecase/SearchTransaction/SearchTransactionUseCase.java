package com.example.usecase.SearchTransaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class SearchTransactionUseCase implements SearchTransactionInput {

    private SearchTransactionDatabase searchTransactionDatabase = null;
    private SearchTransactionOutput searchTransactionOutput = null;

    public SearchTransactionUseCase(SearchTransactionDatabase searchTransactionDatabase,
            SearchTransactionOutput searchTransactionOutput) {
        this.searchTransactionDatabase = searchTransactionDatabase;
        this.searchTransactionOutput = searchTransactionOutput;
    }

    @Override
    public void searchExecute(SearchTransactionInputDTO searchTransactionInputDTO) {
        ResponseError resError = new ResponseError();
        ResponseData resData = new ResponseData();

        if (!validateInput(searchTransactionInputDTO)) {
            return;
        }

        int maGiaoDich = searchTransactionInputDTO.getMaGiaoDich();

        if (!searchTransactionDatabase.existByMaGiaoDich(maGiaoDich)) {
            resError.setMessage("Mã giao dịch: " + maGiaoDich + " không tồn tại!");
            searchTransactionOutput.outError(resError);
            return;
        }

        List<RealEstate> realEstatesList = searchTransactionDatabase.searchTransactionByID(maGiaoDich);

        if (realEstatesList == null || realEstatesList.isEmpty()) {
            resError.setMessage("Không tìm thấy giao dịch với mã: " + maGiaoDich);
            searchTransactionOutput.outError(resError);
            return;
        }

        List<SearchTransactionOutputDTO> outputDTOList = new ArrayList<>();
        for (RealEstate realEstate : realEstatesList) {
            if (realEstate instanceof Land) {
                Land land = (Land) realEstate;
                outputDTOList.add(new SearchTransactionOutputDTO(
                        land.getMaGiaoDich(), land.getNgayGiaoDich(), land.getLoaiGiaoDich(),
                        land.getDonGia(), land.getDienTich(), land.getLoaiDat(), land.thanhTien()));
            } else if (realEstate instanceof House) {
                House house = (House) realEstate;
                outputDTOList.add(new SearchTransactionOutputDTO(
                        house.getMaGiaoDich(), house.getNgayGiaoDich(), house.getLoaiGiaoDich(),
                        house.getDonGia(), house.getDienTich(), house.getLoaiNha(), house.getDiaChi(),
                        house.thanhTien()));
            }
        }
        resData.setDataList(outputDTOList);
        resData.setMessage("Tìm kiếm thành công với mã giao dịch là: " + maGiaoDich + "!");
        searchTransactionOutput.outResult(resData);

    }

    private boolean validateInput(SearchTransactionInputDTO inputDTO) {
        ResponseError resError = new ResponseError();

        // Kiểm tra ngày giao dịch
        if (inputDTO.getMaGiaoDich() <= 0) {
            resError.setMessage("Mã giao dịch không hợp lệ.");
            searchTransactionOutput.outError(resError);
            return false;
        }
        return true;

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
