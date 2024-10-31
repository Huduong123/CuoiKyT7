package com.example.usecase.DeleteTransaction;

public class DeleteTransactionOutputDTO {
    protected int maGiaoDich;

   

    public DeleteTransactionOutputDTO(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;

    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }
}
