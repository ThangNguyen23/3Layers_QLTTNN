package GUI;

import DTO.*;
import BUS.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class QuanLyKhoaThi_Them extends JFrame {
    KhoaThiBUS khoathiBUS;
    JTextField ngaythi, khoathi;

    public QuanLyKhoaThi_Them() {
        khoathiBUS = new KhoaThiBUS();

        setTitle("Thêm Khóa Thi");
        setSize(250, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(250,100));
        panel2.setPreferredSize(new Dimension(250,250));

        panel1.setLayout(null);
        panel2.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Thêm khóa thi");
        label1.setForeground(Color.BLACK);
        label1.setBounds(50, 30, 250, 30);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));

        JLabel lblKhoathi = new JLabel();
        lblKhoathi.setText("Khóa thi");
        lblKhoathi.setForeground(Color.BLACK);
        lblKhoathi.setBounds(20, 15, 90, 15);
        lblKhoathi.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNgaythi = new JLabel();
        lblNgaythi.setText("Ngày thi");
        lblNgaythi.setForeground(Color.BLACK);
        lblNgaythi.setBounds(20, 55, 90, 15);
        lblNgaythi.setFont(new Font("Arial", Font.PLAIN, 15));

        String khoaThi = khoathiBUS.getMakhoathi();
        khoathi = new JTextField();
        khoathi.setText(khoaThi);
        khoathi.setEditable(false);
        khoathi.setBounds(95, 10, 120, 30);
        khoathi.setBackground(Color.white);

        ngaythi = new JTextField();
        ngaythi.setText(null);
        ngaythi.setBounds(95, 50, 120, 30);
        ngaythi.setBackground(Color.white);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(80, 100, 90, 30);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.red);
        btnThoat.setBounds(80, 150, 90, 30);

        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themKhoathi();
            }
        });

        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });

        panel1.add(label1);

        panel2.add(lblKhoathi);
        panel2.add(lblNgaythi);
        panel2.add(khoathi);
        panel2.add(ngaythi);
        panel2.add(btnThem);
        panel2.add(btnThoat);

        add(panel1);
        add(panel2);
    }

    public void themKhoathi() {
        KhoaThiDTO khoaThiDTO = new KhoaThiDTO(khoathi.getText(), ngaythi.getText());
        khoathiBUS.insert(khoaThiDTO);
        this.dispose();
    }
    
//    public static void main(String[] args) {
//        QuanLyKhoaThi_Them quanLyKhoaThiThem = new QuanLyKhoaThi_Them();
//        quanLyKhoaThiThem.setVisible(true);
//    }

}
