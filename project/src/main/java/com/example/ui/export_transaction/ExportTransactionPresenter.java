package com.example.ui.export_transaction;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.usecase.ExportTransaction.ExportTransactionOutput;
import com.example.usecase.ExportTransaction.ExportTransactionOutputDTO;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class ExportTransactionPresenter implements  ExportTransactionOutput{

    private List<ExportTransactionOutputDTO> listOutputDTO = null;
    private List<ExportTransactionViewModel> listViewModel = null;
    private ResponseData resData = null;
    private ResponseError resError =  null;


    @Override
    public void presenter(List<ExportTransactionOutputDTO> listOutputDTO) {
        this.listOutputDTO = listOutputDTO;
     
    }

    @Override
    public void outResult(ResponseData resData) {
          // If there is an error, do not proceed with the success message
       
     this.listOutputDTO = resData.getDataExportList()!= null ? resData.getDataExportList() : new ArrayList<>();
   
     List<ExportTransactionViewModel> viewModelList = new ArrayList<>();
        for (ExportTransactionOutputDTO dto : listOutputDTO) {
            ExportTransactionViewModel viewModel = new ExportTransactionViewModel(
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
           

        }
        if (this.resError != null) {
            return;
        }

        ExportTransactionDetailForm exportTransactionDetailForm = new ExportTransactionDetailForm(viewModelList);
        exportTransactionDetailForm.setVisible(true);
        JOptionPane.showMessageDialog(null, resData.getMessage(), "Thông báo",
        JOptionPane.INFORMATION_MESSAGE);
   
    }

    @Override
    public void outError(ResponseError resError) {
       this.resError = resError;
         JOptionPane.showMessageDialog(null, resError.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    public List<ExportTransactionOutputDTO> getListOutputDTO() {
        return listOutputDTO;
    }

    public List<ExportTransactionViewModel> getListViewModel() {
        return listViewModel;
    }

    public ResponseData getResData() {
        return resData;
    }

    public ResponseError getResError() {
        return resError;
    }
    

    
}
