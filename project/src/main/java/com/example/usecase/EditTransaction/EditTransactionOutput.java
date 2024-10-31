package com.example.usecase.EditTransaction;

import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public interface  EditTransactionOutput {
    void presenter(EditTransactionOutputDTO editTransactionOutputDTO);

    void outError(ResponseError error);
    void outResult(ResponseData responseData);
}
