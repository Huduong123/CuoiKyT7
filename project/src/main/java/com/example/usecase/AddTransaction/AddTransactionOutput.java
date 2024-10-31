package com.example.usecase.AddTransaction;

import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public interface AddTransactionOutput {
    
    void presenter(AddTransactionOutputDTO addTransactionOutputDTO);

    void outError(ResponseError error);
    void outResult(ResponseData responseData);
    
}
