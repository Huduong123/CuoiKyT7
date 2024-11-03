package com.example.ui.export_transaction;

import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void outResult(ResponseData resData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void outError(ResponseError resError) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
