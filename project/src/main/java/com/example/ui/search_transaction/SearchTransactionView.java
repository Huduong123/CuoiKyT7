package com.example.ui.search_transaction;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.ui.TransactionFormView;
import com.example.usecase.SearchTransaction.SearchTransactionOutputDTO;

public class SearchTransactionView {

    private DefaultTableModel transactionTable;
    private JFrame frame; // Tạo JFrame làm thành viên của lớp
  // Tham chiếu đến TransactionFormView
    private JTextField maHoaDonField;
    private JButton searchButton, backButton; 
    private SearchTransactionController searchTransactionController = null;
    
    private List<SearchTransactionViewModel> listSearchTranViewModel = null;
    
    public SearchTransactionView() {
       
        frame = new JFrame("Tìm Kiếm");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel headerLabel = new JLabel("Tìm Kiếm Hóa Đơn");
        headerLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
        headerLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(headerLabel, gbc);

        JLabel maHoaDonLabel = new JLabel("Nhập Mã Giao Dịch:");
        maHoaDonLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(maHoaDonLabel, gbc);

      maHoaDonField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(maHoaDonField, gbc);

         searchButton = new JButton("Tìm Kiếm");
         backButton = new JButton("Trở lại");

        // Thêm nút tìm kiếm
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(searchButton, gbc);

        // Thêm nút trở lại ngay bên cạnh nút tìm kiếm
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(backButton, gbc);

        String[] columnNames = { "Mã Giao Dịch", "Ngày Giao Dịch", "Đơn Giá", "Diện Tích", "Địa Chỉ", "Loại Giao Dịch",
                "Loại DV", "Thành Tiền" };
        transactionTable = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(transactionTable);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.add(scrollPane, gbc);

    
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearch();
            }
            
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Ẩn SearchTransactionView
             TransactionFormView formView = new TransactionFormView();
             formView.setVisible(true);
            }
        });
    }

    public void searchTransactionList(List<SearchTransactionViewModel> transactions) {
        // Nếu danh sách truyền vào là null hoặc rỗng, xóa hết các hàng trong bảng và trả về ngay lập tức
        if (transactions == null || transactions.isEmpty()) {
            transactionTable.setRowCount(0);
            return;
        }
    
        this.listSearchTranViewModel = transactions;
        transactionTable.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm dữ liệu mới
        
        // Thêm dữ liệu mới vào bảng
        for (SearchTransactionViewModel transaction : transactions) {
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

    public void setVisible(boolean visible) {
        frame.setVisible(visible); // Hiển thị frame
    }

  

    public void handleSearch(){
        String maGiaoDich = maHoaDonField.getText().trim();
        if (maGiaoDich.isEmpty()) {
            displayError("Mã giao dịch không được để trống");
            return;
        }

        searchTransactionController.getMaGiaoDich(maGiaoDich);

        // Hiển thị danh sách sau khi tìm kiếm
        searchTransactionList(listSearchTranViewModel);
   
    }

    public void setSearchTransactionController(SearchTransactionController searchTransactionController) {
        this.searchTransactionController = searchTransactionController;
    }

    



    public void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(null,  errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
