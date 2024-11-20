package com.example.ui.export_transaction;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExportTransactionDetailForm extends  JFrame{
    private ExportTransactionController exportTransactionController = null;
   private DefaultTableModel transactionTable;
    private JTable table;
 
    private List<ExportTransactionViewModel> listExportTranViewModel;

    public List<ExportTransactionViewModel> getListExportTranViewModel() {
        return listExportTranViewModel;
    }
    public void setListExportTranViewModel(List<ExportTransactionViewModel> listExportTranViewModel) {
        this.listExportTranViewModel = listExportTranViewModel;
    }
    public void setExportTransactionController(ExportTransactionController exportTransactionController) {
        this.exportTransactionController = exportTransactionController;
    }
    public ExportTransactionDetailForm(List<ExportTransactionViewModel> exportOutputDTO){
        setTitle("Thông tin xuất hóa đơn");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
     // Tạo tiêu đề
        JLabel titleLabel = new JLabel("Thông tin giao dịch", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
   
         // Tạo bảng và thêm các cột
        String[] columnNames = {"Mã Giao Dịch", "Ngày Giao Dịch", "Đơn Giá", "Diện Tích", "Địa Chỉ", "Loại Giao Dịch", "Loại DV", "Thành Tiền"};
        transactionTable = new DefaultTableModel(columnNames, 0);
        table = new JTable(transactionTable);
        table.setFillsViewportHeight(true); // Để bảng tự động điều chỉnh chiều cao

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(750, 300));

        // Tạo nút OK
        JButton okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 30));
        okButton.addActionListener(e -> dispose());

        // Panel để chứa tiêu đề và nút
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(okButton);

        // Thêm các thành phần vào JFrame
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Hiển thị dữ liệu từ danh sách giao dịch
        displayTransactionList(exportOutputDTO);

        setVisible(true);
    }
    public void displayTransactionList(List<ExportTransactionViewModel> transactions) {
        // Nếu danh sách truyền vào là null hoặc rỗng, xóa hết các hàng trong bảng và trả về ngay lập tức
     if (transactions == null || transactions.isEmpty()) {
        transactionTable.setRowCount(0);
        JOptionPane.showMessageDialog(this, "No transactions to display.", "Information", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

        this.listExportTranViewModel = transactions;
        transactionTable.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm dữ liệu mới

        // Thêm dữ liệu mới vào bảng
        for (ExportTransactionViewModel transaction : transactions) {
            Object[] row = {
                    transaction.maGiaoDich,
                    transaction.ngayGiaoDich,
                    transaction.donGia,
                    transaction.dienTich,
                    transaction.diaChi,
                    transaction.loaiGiaoDich,
                    transaction.loaiDat != null ? transaction.loaiDat : transaction.loaiNha,
                    transaction.thanhTien
            };
            transactionTable.addRow(row);
        }
    }
       // Thêm phương thức để hiển thị form khi có kết quả giao dịch
   //    public void showExportTransactionDetailForm(List<ExportTransactionViewModel> transactions) {
 //       displayTransactionList(transactions);
   //     setVisible(true);
   // }
}
