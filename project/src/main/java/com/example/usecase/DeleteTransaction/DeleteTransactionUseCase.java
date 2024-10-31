package com.example.usecase.DeleteTransaction;

import com.example.entity.RealEstate;
import com.example.usecase.ResponseData;
import com.example.usecase.ResponseError;

public class DeleteTransactionUseCase implements DeleteTransactionInput {

    private DeleteTransactionOutput deleteTransactionOutput = null;
    private DeleteTransactionDatabase deleteTransactionDatabase = null;

    public DeleteTransactionUseCase(DeleteTransactionOutput deleteTransactionOutput,
            DeleteTransactionDatabase deleteTransactionDatabase) {
        this.deleteTransactionOutput = deleteTransactionOutput;
        this.deleteTransactionDatabase = deleteTransactionDatabase;
    }

    @Override
    public void deleteExecute(DeleteTransactionInputDTO deleteTransactionInputDTO) {
        ResponseError resError = new ResponseError();
        ResponseData resData = new ResponseData();

  
        int maGiaoDich = deleteTransactionInputDTO.getMaGiaoDich();
   
      
        RealEstate realEstate = new RealEstate(maGiaoDich, null, null, 0, 0) {
            @Override
            public double thanhTien() {
                return 0; // Không cần thiết cho việc xóa
            }
        };
    
        int rowsAffected = deleteTransactionDatabase.deleteTransaction(realEstate);
        
        DeleteTransactionOutputDTO deleteTransactionOutputDTO = new DeleteTransactionOutputDTO(maGiaoDich);
        if (rowsAffected > 0) {
            // Xóa thành công
            resData.setMessage("Xóa thành công giao dịch có mã là : " + maGiaoDich  + " !");
        } else {
            // Không tìm thấy giao dịch
            resError.setMessage("Không tìm thấy giao dịch với mã: " + maGiaoDich);
        }
        deleteTransactionOutput.presenter(deleteTransactionOutputDTO);
        deleteTransactionOutput.outError(resError);
        deleteTransactionOutput.outResult(resData);
    }

}
