package com.example.usecase.DeleteTransaction;

import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public interface  DeleteTransactionOutput {
    
    void presenter(DeleteTransactionOutputDTO deleteTransactionOutputDTO);

    void outError(ResponseError error);
    void outResult(ResponseData responseData);
}
