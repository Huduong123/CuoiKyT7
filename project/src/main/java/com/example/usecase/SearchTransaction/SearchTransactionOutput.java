package com.example.usecase.SearchTransaction;

import java.util.List;

import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public interface  SearchTransactionOutput {
    
   public  void presenter(List<SearchTransactionOutputDTO> outputDTO);

     void outError(ResponseError error);
    void outResult(ResponseData responseData);
}
