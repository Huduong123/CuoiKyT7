package com.example.ui.search_transaction;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchTransactionView {

    private DefaultTableModel transactionTable;

    public SearchTransactionView() {
        // Tạo frame chính
        JFrame frame = new JFrame("Tìm Kiếm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridBagLayout());

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

        JLabel maHoaDonLabel = new JLabel("Nhập Mã Hóa Đơn:");
        maHoaDonLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(maHoaDonLabel, gbc);

        JTextField maHoaDonField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(maHoaDonField, gbc);

        JButton searchButton = new JButton("Tìm Kiếm");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(searchButton, gbc);

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

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new SearchTransactionView();
    }
}
