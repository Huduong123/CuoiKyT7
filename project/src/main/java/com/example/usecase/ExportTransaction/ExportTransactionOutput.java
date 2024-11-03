package com.example.usecase.ExportTransaction;

import java.util.List;

import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public interface  ExportTransactionOutput {
    

    public void presenter(List<ExportTransactionOutputDTO> listOutputDTO);
    public void outResult(ResponseData resData);
    public void outError(ResponseError resError);
}
