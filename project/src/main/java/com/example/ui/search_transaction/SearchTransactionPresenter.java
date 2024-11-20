package com.example.ui.search_transaction;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.ui.TransactionFormView;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;
import com.example.usecase.SearchTransaction.SearchTransactionOutput;
import com.example.usecase.SearchTransaction.SearchTransactionOutputDTO;

public class SearchTransactionPresenter implements SearchTransactionOutput {

    private List<SearchTransactionOutputDTO> listOutputDTO = null;
    private List<SearchTransactionViewModel> listViewModel = null;
    private ResponseError resError = null;
    private ResponseData resData = null;
    private TransactionFormView formView = null;

 
    public SearchTransactionPresenter(TransactionFormView formView) {
        this.formView = formView;
    }

    @Override
    public void presenter(List<SearchTransactionOutputDTO> listOutDTO) {
        this.listOutputDTO = listOutDTO;

       

    }

    @Override
    public void outError(ResponseError error) {
        this.resError = error;
        JOptionPane.showMessageDialog(null, error.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void outResult(ResponseData responseData) {
        this.listOutputDTO = responseData.getDataList() != null ? responseData.getDataList() : new ArrayList<>();

        List<SearchTransactionViewModel> viewModelList = new ArrayList<>();
        for (SearchTransactionOutputDTO dto : listOutputDTO) {
            SearchTransactionViewModel viewModel = new SearchTransactionViewModel(
                    String.valueOf(dto.getMaGiaoDich()),
                    dto.getNgayGiaoDich().toString(),
                    dto.getLoaiGiaoDich(),
                    String.valueOf(dto.getDonGia()),
                    String.valueOf(dto.getDienTich()),

                    dto.getLoaiDat(), 
                    dto.getLoaiNha(), 
                    dto.getDiaChi(),

                    String.valueOf(dto.getThanhTien())

            );
            System.out.println("Mã giao dịch: " + dto.getMaGiaoDich());
            System.out.println("Ngày giao dịch: " + dto.getNgayGiaoDich());
            System.out.println("Loại giao dịch: " + dto.getLoaiGiaoDich());
            System.out.println("Đơn giá: " + dto.getDonGia());
            System.out.println("Diện tích: " + dto.getDienTich());
            if (dto.getLoaiDat() != null) {
                System.out.println("Loại đất: " + dto.getLoaiDat());
            }
            if (dto.getLoaiNha() != null) {
                System.out.println("Loại nhà: " + dto.getLoaiNha());
                System.out.println("Địa chỉ: " + dto.getDiaChi());
            }
            System.out.println("Thành tiền: " + dto.getThanhTien());
            System.out.println("----------");
            viewModelList.add(viewModel);
            JOptionPane.showMessageDialog(null, responseData.getMessage(), "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        }
      
      formView.searchTransactionList(viewModelList);
    }

    public List<SearchTransactionViewModel> getListViewModel() {
        return listViewModel;
    }

    public ResponseError getResError() {
        return resError;
    }

    public ResponseData getResData() {
        return resData;
    }

 

    public List<SearchTransactionOutputDTO> getListOutputDTO() {
        return listOutputDTO;
    }

}
