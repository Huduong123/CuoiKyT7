package com.example.usecase;

import java.util.List;

import com.example.usecase.SearchTransaction.SearchTransactionOutputDTO;

public class ResponseData {
    public String message;
    String error ;
    public double result;   
public int resultDelelte;
 public  List<SearchTransactionOutputDTO> dataList;
 
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public List<SearchTransactionOutputDTO> getDataList() {
        return dataList;
    }

    public void setDataList(List<SearchTransactionOutputDTO> dataList) {
        this.dataList = dataList;
    }

}
