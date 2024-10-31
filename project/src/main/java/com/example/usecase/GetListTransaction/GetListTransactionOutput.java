package com.example.usecase.GetListTransaction;

import java.util.List;

import com.example.usecase.ResponseData;

public interface  GetListTransactionOutput {
    public void presenter(List<GetListTransactionOutputDTO> outputDTO);

    void exportResult(ResponseData responseData);


}
