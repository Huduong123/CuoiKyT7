package com.example.usecase.SearchTransaction;

import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public interface  SearchTransactionOutput {
    
    void presenter(SearchTransactionOutputDTO searchTransactionOutputDTO);

     void outError(ResponseError error);
    void outResult(ResponseData responseData);
}
