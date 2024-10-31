package com.example.ui.get_listTransaction;

import java.util.ArrayList;
import java.util.List;

import com.example.ui.TransactionFormView;
import com.example.usecase.DataExport;
import com.example.usecase.GetListTransaction.GetListTransactionOutput;
import com.example.usecase.GetListTransaction.GetListTransactionOutputDTO;
import com.example.usecase.ResponseData;

public class GetListTransactionPresenter implements GetListTransactionOutput {
    private DataExport dataExport = null;
    private List<GetListTransactionOutputDTO> listOutputDTO = null;
    private List<GetListTransactionViewModel> listViewModel = null;;
    private TransactionFormView form;

    public GetListTransactionPresenter(TransactionFormView form) {
        this.form = form;
    }

    @Override
    public void exportResult(ResponseData responseData) {

    }

    public DataExport getDataExport() {
        return dataExport;
    }

    @Override
    public void presenter(List<GetListTransactionOutputDTO> listOutDTO) {
        this.listOutputDTO = listOutDTO;
        listViewModel = new ArrayList<>();

        for (GetListTransactionOutputDTO transactionDTO : listOutputDTO) {
            // Tạo và thêm vào view model
        }
        for (GetListTransactionOutputDTO transactionDTO : listOutDTO) {
            GetListTransactionViewModel viewModel = new GetListTransactionViewModel(
                    String.valueOf(transactionDTO.getMaGiaoDich()),
                    String.valueOf(transactionDTO.getNgayGiaoDich()),
                    String.valueOf(transactionDTO.getLoaiGiaoDich()),
                    String.valueOf(transactionDTO.getDonGia()),
                    String.valueOf(transactionDTO.getDienTich()),
                    transactionDTO.getLoaiDat(), // Loại đất
                    transactionDTO.getLoaiNha(), // Loại nhà
                    transactionDTO.getDiaChi(),
                    String.valueOf(transactionDTO.getThanhTien()));
            listViewModel.add(viewModel);
        }

        // Pass the view model list to the form for displaying
        form.getListTransactionFormView(listViewModel);
    }
    
 
    public List<GetListTransactionOutputDTO> getListOutputDTO() {
        return listOutputDTO;
    }

    public List<GetListTransactionViewModel> getListViewModel() {
        return listViewModel;
    }

}
