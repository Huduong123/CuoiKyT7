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
import com.example.ui.get_listTransaction.GetListTransactionController;
import com.example.ui.get_listTransaction.GetListTransactionViewModel;

public class TransactionFormView extends JFrame implements ActionListener {
    private JComboBox<String> cboTransactionType;
    private JComboBox<String> cboLandType;
    private JComboBox<String> cboHouseType;
    private JTextField txtSearch;
    private JTextField txtTransactionCode, txtUnitPrice, txtArea, txtAddress, txtTransactionDate;
    private JButton btnCalculate, btnAddTransaction, btnEditTransaction, btnDeleteTransaction, btnSumQuantity,
            btnAverage, btnPrint, btnSearch;
    private DefaultTableModel transactionTable;


    //view 
    private AddTransactionDetailForm addTransactionDetailForm = null;

    // view model
    private List<GetListTransactionViewModel> transactions = null;
    private GetListTransactionViewModel viewModel = null;
    private AddTransactionViewModel addViewModel = null;

    // controller
    private GetListTransactionController getListTransactionController = null;
    private AddTransactionController addTransactionController = null;



    public void setAddTransactionDetailForm(AddTransactionDetailForm addTransactionDetailForm) {
        this.addTransactionDetailForm = addTransactionDetailForm;
    }

    public TransactionFormView() {
        setTitle("Quản Lí ");
        setSize(900, 600);
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

        txtTransactionCode = new JTextField(20);
        txtUnitPrice = new JTextField(20);
        txtArea = new JTextField(20);
        txtAddress = new JTextField(20);
  

        txtTransactionDate = new JTextField(20);
        txtTransactionDate.setToolTipText("Nhập ngày theo định dạng dd/MM/yyyy");

        cboTransactionType = new JComboBox<>(new String[] { "Đất", "Nhà" });
        cboLandType = new JComboBox<>(new String[] { "Loại A", "Loại B", "Loại C" });
        cboHouseType = new JComboBox<>(new String[] { "Cao Cấp", "Nhà Thường" });
        cboHouseType.setEnabled(false);

        btnSearch = new JButton("Tìm Kiếm");
        btnCalculate = new JButton("Tạm Tính");
        btnAddTransaction = new JButton("Thêm Hóa Đơn");
        btnEditTransaction = new JButton("Sửa Hóa Đơn");
        btnDeleteTransaction = new JButton("Xóa Hóa Đơn");
        btnSumQuantity = new JButton("Tính Tổng Số Lượng");
        btnAverage = new JButton("Tính Trung Bình");
        btnPrint = new JButton("In Giao Dịch");

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

        // gbc.gridx = 0;
        // gbc.gridy = 9;
        // add(lblTotalPrice, gbc);
        // gbc.gridx = 1;
        // add(txtTotalPrice, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(btnSearch, gbc);
        gbc.gridy = 2;
        add(btnCalculate, gbc);
        gbc.gridy = 3;
        add(btnSumQuantity, gbc);
        gbc.gridy = 4;
        add(btnAverage, gbc);
        gbc.gridy = 5;
        add(btnPrint, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        add(btnAddTransaction, gbc);
        gbc.gridx = 1;
        add(btnEditTransaction, gbc);
        gbc.gridx = 2;
        add(btnDeleteTransaction, gbc);

        setVisible(true);

        /////////////////////////

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

        btnAddTransaction.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddStudent();
                showErrorMessage();
            }

        });
        txtAddress.setEnabled(false);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
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
                }
            }
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
    private void handleAddStudent() {
      

        String maGiaoDich = txtTransactionCode.getText().trim();
        String ngayGiaoDich = txtTransactionDate.getText().trim();
        String loaiGiaoDich = (String) cboTransactionType.getSelectedItem();
        String donGia = txtUnitPrice.getText().trim();
        String dienTich = txtArea.getText().trim();
 
        boolean hasError = false;

        if (maGiaoDich.isEmpty()) {
            txtTransactionCode.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã Giao Dịch.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            hasError = true;
            // txtTransactionCode.setText("");
        } else if (ngayGiaoDich.isEmpty()) {
            txtTransactionDate.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Ngày Giao Dịch.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            hasError = true;
            // txtTransactionDate.setText("");
        } else if (donGia.isEmpty()) {
            txtUnitPrice.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Đơn Giá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            hasError = true;
        } else if (!isNumeric(donGia)) {
            txtUnitPrice.requestFocus();
            JOptionPane.showMessageDialog(this, "Đơn Giá phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            hasError = true;
        } else if (dienTich.isEmpty()) {
            txtArea.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Diện Tích.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            hasError = true;
        } else if (!isNumeric(dienTich)) {
            txtArea.requestFocus();
            JOptionPane.showMessageDialog(this, "Diện Tích phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            hasError = true;
        }

        if (hasError) {
            
            return;
        }

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
      
        resetForm();
      
    }

    private void resetForm() {
        txtTransactionCode.setText("");
        txtTransactionDate.setText("");
        txtUnitPrice.setText("");
        txtAddress.setText("");
        txtArea.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Thêm hóa đơn")) {
            /*
             * if (addTransactionView != null) {
             * addTransactionView.show();
             * }
             */
        }
    }

    //set Controller
    public void setGetListTransactionController(GetListTransactionController getListTransactionController) {
        this.getListTransactionController = getListTransactionController;
    }

    public void setAddTransactionController(AddTransactionController addTransactionController) {
        this.addTransactionController = addTransactionController;
    }


   // phương thức báo lỗi
    public void showErrorMessage() {
  
        String errorMessage = addViewModel.getMessageError();
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            addViewModel.setMessageError(null); // Reset lỗi sau khi hiển thị
        }

        
    }

    public void setAddViewModel(AddTransactionViewModel addViewModel) {
        this.addViewModel = addViewModel;
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
}