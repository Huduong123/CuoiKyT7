package com.example.ui.add_transaction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.usecase.AddTransaction.AddTransactionOutputDTO;

public class AddTransactionDetailForm extends  JFrame{
    private AddTransactionController addTransactionController = null;
    
    public AddTransactionController getAddTransactionController() {
        return addTransactionController;
    }

    public void setAddTransactionController(AddTransactionController addTransactionController) {
        this.addTransactionController = addTransactionController;
    }
 public AddTransactionDetailForm(AddTransactionOutputDTO addOutputDTO) {
    
        setTitle("Thông tin giao dịch");
        setSize(500, 400);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //  SuccessDialog successDialog = new SuccessDialog(this);
     //   successDialog.setVisible(true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Tạo panel chính với khoảng trống và viền
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Cài đặt font và màu cho nhãn tiêu đề
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Color labelColor = new Color(50, 50, 50);

        // GridBagLayout để bố trí thông tin
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Hàm tiện ích để thêm các nhãn và dữ liệu
        addLabelAndData("Mã giao dịch:", String.valueOf(addOutputDTO.getMaGiaoDich()), mainPanel, labelFont, labelColor, gbc, 0);
        addLabelAndData("Ngày giao dịch:", dateFormat.format(addOutputDTO.getNgayGiaoDich()), mainPanel, labelFont, labelColor, gbc, 1);
        addLabelAndData("Loại giao dịch:", addOutputDTO.getLoaiGiaoDich(), mainPanel, labelFont, labelColor, gbc, 2);
        addLabelAndData("Đơn giá:", String.valueOf(addOutputDTO.getDonGia()), mainPanel, labelFont, labelColor, gbc, 3);
        addLabelAndData("Diện tích:", String.valueOf(addOutputDTO.getDienTich()), mainPanel, labelFont, labelColor, gbc, 4);
        addLabelAndData("Địa chỉ:", addOutputDTO.getDiaChi(), mainPanel, labelFont, labelColor, gbc, 5);
        addLabelAndData("Loại dịch vụ:", addOutputDTO.getLoaiDat() != null ? addOutputDTO.getLoaiDat() : addOutputDTO.getLoaiNha(), mainPanel, labelFont, labelColor, gbc, 6);
        addLabelAndData("Thành tiền:", String.valueOf(addOutputDTO.getThanhTien()), mainPanel, labelFont, labelColor, gbc, 7);

        // Thêm nút đóng
        JButton closeButton = new JButton("Đóng");
        closeButton.addActionListener(e -> dispose());
        closeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        closeButton.setBackground(new Color(220, 220, 220));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        buttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        // Thêm panel chính và panel nút vào JFrame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addLabelAndData(String label, String data, JPanel panel, Font font, Color color, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(font);
        labelComponent.setForeground(color);
        panel.add(labelComponent, gbc);

        gbc.gridx = 1;
        JLabel dataComponent = new JLabel(data);
        dataComponent.setFont(new Font("Arial", Font.PLAIN, 14));
        dataComponent.setForeground(Color.DARK_GRAY);
        panel.add(dataComponent, gbc);
    }
    /*public AddTransactionDetailForm(AddTransactionOutputDTO addOutputDTO){
        
    setTitle("Thông tin sinh viên");
    setLayout(new GridLayout(6, 2));
    setSize(400, 300);

    SuccessDialog successDialog = new SuccessDialog(this);
    successDialog.setVisible(true);

  // Định dạng ngày
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    add(new JLabel("Mã giao dịch:"));
    add(new JLabel(""+addOutputDTO.getMaGiaoDich()));

    add(new JLabel("Ngày giao dịch:"));
    add(new JLabel(""+dateFormat.format(addOutputDTO.getNgayGiaoDich()))); // Định dạng ngày thành chuỗi

    add(new JLabel("Loại giao dich:"));
    add(new JLabel(addOutputDTO.getLoaiGiaoDich()));

    add(new JLabel("Đơn giá:"));
    add(new JLabel(String.valueOf(addOutputDTO.getDonGia())));

    add(new JLabel("Diện tích:"));
    add(new JLabel(String.valueOf(addOutputDTO.getDienTich())));

    add(new JLabel("Địa chỉ:"));
    add(new JLabel(String.valueOf(addOutputDTO.getDiaChi())));

    add(new JLabel("Loại dịch vụ:"));
    add(new JLabel(String.valueOf(addOutputDTO.getLoaiDat() != null ? addOutputDTO.getLoaiDat() : addOutputDTO.getLoaiNha())));


    add(new JLabel("Thành tiền:"));
    add(new JLabel(String.valueOf(addOutputDTO.getThanhTien())));

 

    // Button to close the form
    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> dispose());

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(closeButton);

    add(buttonPanel);

    setVisible(true);

    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
