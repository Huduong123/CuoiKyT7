package com.example.ui.export_transaction;

import com.example.usecase.ExportTransaction.ExportTransactionInput;
import com.example.usecase.ExportTransaction.ExportTransactionInputDTO;

public class ExportTransactionController {
    private ExportTransactionInput exportTransactionInput = null;

    public ExportTransactionController(ExportTransactionInput exportTransactionInput) {
        this.exportTransactionInput = exportTransactionInput;
    }

    public ExportTransactionInput getExportTransactionInput() {
        return exportTransactionInput;
    }

    public void getMonth(String month){
        try {
            int monthInt = Integer.parseInt(month);
            ExportTransactionInputDTO sExportTransactionInputDTO = new ExportTransactionInputDTO(monthInt);
            exportTransactionInput.ExportData(sExportTransactionInputDTO);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Không thể chuyển đổi tháng sang kiểu số.");
        }
    }


}
