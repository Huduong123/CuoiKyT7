package com.example.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.example.ui.add_transaction.AddTransactionController;
import com.example.ui.add_transaction.AddTransactionDetailForm;
import com.example.ui.add_transaction.AddTransactionViewModel;
import com.example.ui.calAverage_transaction.CalAverageTranController;
import com.example.ui.calAverage_transaction.CalAverageTranViewModel;
import com.example.ui.calTotal_transaction.CalTotalTransactionController;
import com.example.ui.calTotal_transaction.CalTotalTransactionViewModel;
import com.example.ui.delete_transaction.DeleteTransactionController;
import com.example.ui.delete_transaction.DeleteTransactionViewModel;
import com.example.ui.edit_transaction.EditTransactionController;
import com.example.ui.edit_transaction.EditTransactionViewModel;
import com.example.ui.export_transaction.ExportTransactionController;
import com.example.ui.export_transaction.ExportTransactionViewModel;
import com.example.ui.get_listTransaction.GetListTransactionController;
import com.example.ui.get_listTransaction.GetListTransactionViewModel;
import com.example.ui.search_transaction.SearchTransactionController;
import com.example.ui.search_transaction.SearchTransactionViewModel;

public class TransactionFormView extends JFrame implements ActionListener {
    private JComboBox<String> cboTransactionType, cboExportMonth;
    private JComboBox<String> cboLandType;
    private JComboBox<String> cboHouseType;
    private JTextField txtSearch;
    private JTextField txtTransactionCode, txtUnitPrice, txtArea, txtAddress, txtTransactionDate, maHoaDonTimKiem;
    private JButton btnReset, btnAddTransaction, btnEditTransaction, btnDeleteTransaction, btnSumQuantity,
            btnAverage, btnPrint, btnSearch, btnExport;
    private DefaultTableModel transactionTable;
    private boolean isTableChanged = false; // Cờ để kiểm tra thay đổi dữ liệu bảng

    //view 
    private AddTransactionDetailForm addTransactionDetailForm = null;
  
    
    // view model
    private List<GetListTransactionViewModel> transactions = null;
    private GetListTransactionViewModel viewModel = null;
    private AddTransactionViewModel addViewModel = null;
    private EditTransactionViewModel editViewModel = null;
    private DeleteTransactionViewModel deleteViewModel = null;
    private List<SearchTransactionViewModel> listSearchTranViewModel = null;
    private CalTotalTransactionViewModel calTotalViewModel = null;
    private CalAverageTranViewModel calAverageTranViewModel = null;
    private List<ExportTransactionViewModel> listExportViewModel = null;
    // controller
    private GetListTransactionController getListTransactionController = null;
    private AddTransactionController addTransactionController = null;
    private EditTransactionController editTransactionController = null;
    private DeleteTransactionController deleteTransactionController = null;
    private SearchTransactionController searchTransactionController = null;
    private CalTotalTransactionController calTotalController = null;
    private CalAverageTranController calAverageTranController = null;
    private ExportTransactionController exportTransactionController = null;
    
    public void setAddTransactionDetailForm(AddTransactionDetailForm addTransactionDetailForm) {
        this.addTransactionDetailForm = addTransactionDetailForm;
    }





    public TransactionFormView() {
        setTitle("Quản Lí ");
        setSize(900, 700);
        setLocationRelativeTo(null); // Đặt JFrame ở giữa màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTransactionCode = new JLabel("Mã Giao Dịch:");
        JLabel lblTransactionDate = new JLabel("Ngày Giao Dịch:");
        JLabel lblUnitPrice = new JLabel("Đơn Giá:");
        JLabel lblArea = new JLabel("Diện Tích:");
        JLabel lblAddress = new JLabel("Địa Chỉ:");
        // JLabel lblTotalPrice = new JLabel("Thành Tiền:");
        JLabel lblTransactionType = new JLabel("Loại Giao Dịch:");
        JLabel lbTimKiem = new JLabel("Tìm kiếm");
        JLabel lbExport = new JLabel("Xuất hóa đơn theo tháng");
        txtTransactionCode = new JTextField(20);
        txtUnitPrice = new JTextField(20);
        txtArea = new JTextField(20);
        txtAddress = new JTextField(20);
        maHoaDonTimKiem = new JTextField(20);

        txtTransactionDate = new JTextField(20);
        txtTransactionDate.setToolTipText("Nhập ngày theo định dạng dd/MM/yyyy");

        cboTransactionType = new JComboBox<>(new String[] { "Đất", "Nhà" });
        cboLandType = new JComboBox<>(new String[] { "Loại A", "Loại B", "Loại C" });
        cboHouseType = new JComboBox<>(new String[] { "Cao Cấp", "Nhà Thường" });
        cboHouseType.setEnabled(false);
        cboExportMonth = new JComboBox<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9" , "10", "11", "12"});

        btnSearch = new JButton("Tìm Kiếm");
        btnReset = new JButton("Reset");
        btnAddTransaction = new JButton("Thêm Giao Dịch");
        btnEditTransaction = new JButton("Sửa Giao Dịch");
        btnDeleteTransaction = new JButton("Xóa Giao Dịch");
        btnSumQuantity = new JButton("Tính Tổng Số Lượng");
        btnAverage = new JButton("Tính Trung Bình");
        btnPrint = new JButton("In Giao Dịch");
        btnExport = new JButton("Xuất hóa đơn");
        String[] columnNames = { "Mã Giao Dịch", "Ngày Giao Dịch", "Đơn Giá", "Diện Tích", "Địa Chỉ", "Loại Giao Dịch",
                "Loại DV", "Thành Tiền" };
        transactionTable = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(transactionTable);
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        JLabel headerLabel = new JLabel("Quản Lý Giao Dịch Đất Đai");
        headerLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
        headerLabel.setForeground(Color.BLUE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 20, 0);
        add(headerLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        add(scrollPane, gbc);

        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblTransactionCode, gbc);
        gbc.gridx = 1;
        add(txtTransactionCode, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblTransactionDate, gbc);
        gbc.gridx = 1;
        add(txtTransactionDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblUnitPrice, gbc);
        gbc.gridx = 1;
        add(txtUnitPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(lblArea, gbc);
        gbc.gridx = 1;
        add(txtArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lblAddress, gbc);
        gbc.gridx = 1;
        add(txtAddress, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(lblTransactionType, gbc);
        gbc.gridx = 1;
        add(cboTransactionType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(cboLandType, gbc);
        gbc.gridx = 1;
        add(cboHouseType, gbc);

      // Add search label and text field on a new row below the comboboxes
      gbc.gridx = 0;
      gbc.gridy = 9;
      add(lbTimKiem, gbc);
      gbc.gridx = 1;
      add(maHoaDonTimKiem, gbc);

      gbc.gridx = 0;
      gbc.gridy = 10;
      add(lbExport, gbc);
      gbc.gridx = 1;
      add(cboExportMonth, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.gridy = 2;
        add(btnReset, gbc);
        gbc.gridy = 3;
        add(btnSumQuantity, gbc);
        gbc.gridy = 4;
        add(btnAverage, gbc);
        gbc.gridy = 5;
        add(btnPrint, gbc);
        gbc.gridy = 9;
        add(btnSearch, gbc);
        gbc.gridy = 10;
        add(btnExport, gbc);
           // Add transaction buttons on a new row
           gbc.gridx = 0;
           gbc.gridy = 11;
           gbc.gridwidth = 1;
           add(btnAddTransaction, gbc);
           gbc.gridx = 1;
           add(btnEditTransaction, gbc);
           gbc.gridx = 2;
           add(btnDeleteTransaction, gbc);

        setVisible(true);

        /////////////////////////
       //set Enabled
        btnEditTransaction.setEnabled(false);
        btnDeleteTransaction.setEnabled(false);

        btnPrint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                demo();
            }

        });
        //////////////////////////////////////////// ham check ngày nhé
        txtTransactionDate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String date = txtTransactionDate.getText();
                if (!date.isEmpty() && !isValidDate(date)) {

                }
            }
        });

        // Thêm sự kiện khi thay đổi loại giao dịch
        cboTransactionType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = getSelectedTransactionType();
                if (selectedType.equals("Đất")) {
                    setComboBoxLandEnabled(true);
                    setComboBoxHouseEnabled(false);
                    txtAddress.setEnabled(false);
                } else if (selectedType.equals("Nhà")) {
                    setComboBoxLandEnabled(false);
                    setComboBoxHouseEnabled(true);
                    txtAddress.setEnabled(true);
                }
            }
        });
        
    
        btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             resetForm();
             btnEditTransaction.setEnabled(false);
             btnDeleteTransaction.setEnabled(false);
            }
            
        });

        btnAddTransaction.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               handleAddTransaction();
            
            }

        });
        txtAddress.setEnabled(false);

        btnEditTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    handleEditTransaction();
                    txtTransactionCode.setEnabled(true);
                 
            }
        });

        btnDeleteTransaction.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
          
                    handleDeleteTransaction();
                    txtTransactionCode.setEnabled(true);
                
            }
            
        });

        
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearch();
            }
            
        });

        btnExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               handleExport();
            }
            
        });
        btnSumQuantity.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calTotalController.execute();
            }
        });

        btnAverage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               calAverageTranController.execute();
            }
            
        });

        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {


                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    btnEditTransaction.setEnabled(true);
                    btnDeleteTransaction.setEnabled(true);
    
                    // Lấy dữ liệu từ hàng đã chọn
                    Object transactionCode = table.getValueAt(selectedRow, 0);
                    Object transactionDate = table.getValueAt(selectedRow, 1);
                    Object unitPrice = table.getValueAt(selectedRow, 2);
                    Object area = table.getValueAt(selectedRow, 3);
                    Object address = table.getValueAt(selectedRow, 4);
                    Object transactionType = table.getValueAt(selectedRow, 5); // lấy dữ liệu "Nhà" hoặc "Đất"
                    Object landOrHouseType = table.getValueAt(selectedRow, 6);
        
                    // Kiểm tra null trước khi gọi toString()
                    txtTransactionCode.setText(transactionCode != null ? transactionCode.toString() : "");
                    txtTransactionCode.setEditable(false); // Vô hiệu hóa trường văn bản
                    txtTransactionDate.setText(transactionDate != null ? transactionDate.toString() : "");
                    txtUnitPrice.setText(unitPrice != null ? unitPrice.toString() : "");
                    txtArea.setText(area != null ? area.toString() : "");
                    txtAddress.setText(address != null ? address.toString() : "");
        
                    // Cập nhật cboTransactionType thành "Nhà" hoặc "Đất" từ bảng
                    if (transactionType != null) {
                        cboTransactionType.setSelectedItem(transactionType.toString());
                    }
        
                    // Kiểm tra loại giao dịch và cập nhật ComboBox tương ứng
                    if ("Đất".equals(transactionType)) {
                        setComboBoxLandEnabled(true);
                        setComboBoxHouseEnabled(false);
                        cboLandType.setSelectedItem(landOrHouseType != null ? landOrHouseType.toString() : "");
                    } else if ("Nhà".equals(transactionType)) {
                        setComboBoxLandEnabled(false);
                        setComboBoxHouseEnabled(true);
                        cboHouseType.setSelectedItem(landOrHouseType != null ? landOrHouseType.toString() : "");
                    }

                }else {
                    btnEditTransaction.setEnabled(false);
                    btnDeleteTransaction.setEnabled(false);
                }
            }
        });

        transactionTable.addTableModelListener(e -> {
            isTableChanged = true;
            btnEditTransaction.setEnabled(false);
            btnDeleteTransaction.setEnabled(false);
        });
    }



    //load bảng
    public void getListTransactionFormView(List<GetListTransactionViewModel> transactions) {
        this.transactions = transactions;
        transactionTable.setRowCount(0); // Xóa tất cả các hàng trước khi thêm mới.
        for (GetListTransactionViewModel transaction : transactions) {
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

    private void demo() {
        JOptionPane.showMessageDialog(this, "In Hóa Đơn Thành Công .");
    }

    public String getSelectedTransactionType() {
        return (String) cboTransactionType.getSelectedItem();
    }

    public void setComboBoxLandEnabled(boolean enabled) {
        cboLandType.setEnabled(enabled);
    }

    public void setComboBoxHouseEnabled(boolean enabled) {
        cboHouseType.setEnabled(enabled);
    }

    public void addTransactionTypeListener(ActionListener listener) {
        cboTransactionType.addActionListener(listener);
    }


    // kiem tra ngay
    public boolean isValidDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(date);
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Vui lòng nhập theo định dạng Ngày/Tháng/Năm.",
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtTransactionDate.setText("");
            return false;
        }
    }

    // sự kiên thêm 
    private void handleAddTransaction() {
      
        if (!validateInputFields()) return;
        String maGiaoDich = txtTransactionCode.getText().trim();
        String ngayGiaoDich = txtTransactionDate.getText().trim();
        String loaiGiaoDich = (String) cboTransactionType.getSelectedItem();
        String donGia = txtUnitPrice.getText().trim();
        String dienTich = txtArea.getText().trim();

        if (loaiGiaoDich.equals("Đất")) {
            String loaiDat = (String) cboLandType.getSelectedItem();
            addTransactionController.addTransactionLand(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    loaiDat);
        } else if (loaiGiaoDich.equals("Nhà")) {
            String loaiNha = (String) cboHouseType.getSelectedItem();
            String diaChi = txtAddress.getText().trim();
            if (diaChi.isEmpty()) {
                txtAddress.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Địa Chỉ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            addTransactionController.addTransactionHouse(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    loaiNha, diaChi);
        }

        getListTransactionController.execute();
        showErrorMessageAdd();
        resetForm();
      
    }


    private void handleEditTransaction(){
        if (!validateInputFields()) return;
        String maGiaoDich = txtTransactionCode.getText().trim();
        String ngayGiaoDich = txtTransactionDate.getText().trim();
        String loaiGiaoDich = (String) cboTransactionType.getSelectedItem();
        String donGia = txtUnitPrice.getText().trim();
        String dienTich = txtArea.getText().trim();

        if (loaiGiaoDich.equals("Đất")) {
            String loaiDat = (String) cboLandType.getSelectedItem();
            editTransactionController.editTransactionLand(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    loaiDat);
        } else if (loaiGiaoDich.equals("Nhà")) {
            String loaiNha = (String) cboHouseType.getSelectedItem();
            String diaChi = txtAddress.getText().trim();
            if (diaChi.isEmpty()) {
                txtAddress.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Địa Chỉ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            editTransactionController.editTransactionHouse(maGiaoDich, ngayGiaoDich, loaiGiaoDich, donGia, dienTich,
                    loaiNha, diaChi);
        }

        getListTransactionController.execute();
        showErrorMessageEdit();
        resetForm();
    }

    public void handleDeleteTransaction(){
        String maGiaoDich = txtTransactionCode.getText().trim();
        deleteTransactionController.getMaGiaoDich(maGiaoDich);
    
        getListTransactionController.execute();
        showErrorMessageDelete();
        resetForm();
    }

    public void handleSearch(){
        String maGiaoDich = maHoaDonTimKiem.getText().trim();
        if (maGiaoDich.isEmpty()) {
            displayError("Mã giao dịch không được để trống");
            return;
        }

        searchTransactionController.getMaGiaoDich(maGiaoDich);

        // Hiển thị danh sách sau khi tìm kiếm
        searchTransactionList(listSearchTranViewModel);
   
    }

    public void handleExport(){
        String month = (String) cboExportMonth.getSelectedItem();

        exportTransactionController.getMonth(month);

        
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
    private boolean validateInputFields() {
        if (txtTransactionCode.getText().trim().isEmpty()) {
            showError("Vui lòng nhập Mã Giao Dịch.", txtTransactionCode);
            return false;
        } else if (txtTransactionDate.getText().trim().isEmpty()) {
            showError("Vui lòng nhập Ngày Giao Dịch.", txtTransactionDate);
            return false;
        } else if (!isValidDate(txtTransactionDate.getText().trim())) {
            return false; // Lỗi đã được xử lý trong isValidDate()
        } else if (txtUnitPrice.getText().trim().isEmpty() || !isNumeric(txtUnitPrice.getText().trim())) {
            showError("Đơn Giá phải là số và không được bỏ trống.", txtUnitPrice);
            return false;
        } else if (txtArea.getText().trim().isEmpty() || !isNumeric(txtArea.getText().trim())) {
            showError("Diện Tích phải là số và không được bỏ trống.", txtArea);
            return false;
        } else if (getSelectedTransactionType().equals("Nhà") && txtAddress.getText().trim().isEmpty()) {
            showError("Vui lòng nhập Địa Chỉ cho giao dịch Nhà.", txtAddress);
            return false;
        }
        return true;
    }

    private void showError(String message, JTextField field) {
        JOptionPane.showMessageDialog(this, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
        field.requestFocus();
    }

    private void resetForm() {
        txtTransactionCode.setText("");
        txtTransactionDate.setText("");
        txtUnitPrice.setText("");
        txtAddress.setText("");
        txtArea.setText("");
        txtTransactionCode.setEnabled(true);
        getListTransactionFormView(transactions);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    //set Controller
    public void setGetListTransactionController(GetListTransactionController getListTransactionController) {
        this.getListTransactionController = getListTransactionController;
    }

    public void setAddTransactionController(AddTransactionController addTransactionController) {
        this.addTransactionController = addTransactionController;
    }


   public void setEditTransactionController(EditTransactionController editTransactionController) {
        this.editTransactionController = editTransactionController;
    }

    
    public void setDeleteTransactionController(DeleteTransactionController deleteTransactionController) {
    this.deleteTransactionController = deleteTransactionController;
}


public void setSearchTransactionController(SearchTransactionController searchTransactionController) {
    this.searchTransactionController = searchTransactionController;
}


    public void setCalTotalController(CalTotalTransactionController calTotalController) {
        this.calTotalController = calTotalController;
    }

    public void setCalAverageTranController(CalAverageTranController calAverageTranController) {
        this.calAverageTranController = calAverageTranController;
    }


    public void setExportTransactionController(ExportTransactionController exportTransactionController) {
        this.exportTransactionController = exportTransactionController;
    }

    //set ViewModel
    public void setAddViewModel(AddTransactionViewModel addViewModel) {
        this.addViewModel = addViewModel;
    }

    public void setEditViewModel(EditTransactionViewModel editViewModel) {
        this.editViewModel = editViewModel;
    }

    public void setDeleteViewModel(DeleteTransactionViewModel deleteViewModel) {
        this.deleteViewModel = deleteViewModel;
    }

    
    public void setCalTotalViewModel(CalTotalTransactionViewModel calTotalViewModel) {
        this.calTotalViewModel = calTotalViewModel;
    }

    public void setCalAverageTranViewModel(CalAverageTranViewModel calAverageTranViewModel) {
        this.calAverageTranViewModel = calAverageTranViewModel;
    }
    
    // phương thức báo lỗi
    public void showErrorMessageAdd() {
  
        String errorMessage = addViewModel.getMessageError();
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            addViewModel.setMessageError(null); // Reset lỗi sau khi hiển thị
        }   
    }
    public void showErrorMessageEdit() {
  
        String errorMessage = editViewModel.getMessageError();
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            editViewModel.setMessageError(null); // Reset lỗi sau khi hiển thị
        }   
    }

    public void showErrorMessageDelete() {
  
        String errorMessage = deleteViewModel.getMessageError();
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            deleteViewModel.setMessageError(null); // Reset lỗi sau khi hiển thị
        }   
    }

    
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


  

    public void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(null,  errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    
}
