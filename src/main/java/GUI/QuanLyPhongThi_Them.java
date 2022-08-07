package GUI;

import DTO.*;
import BUS.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class QuanLyPhongThi_Them extends JFrame {
    PhongThiBUS phongthiBUS;

    String khoathi = "";
    JComboBox trinhdo;
    JTextField ngaythi,phongthi;

    public QuanLyPhongThi_Them(String khoathi) {
        phongthiBUS = new PhongThiBUS();
        this.khoathi = khoathi;

        setTitle("Thêm phòng thi");
        setSize(250, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(250,70));
        panel2.setPreferredSize(new Dimension(250,280));

        panel1.setLayout(null);
        panel2.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Thêm phòng thi");
        label1.setForeground(Color.BLACK);
        label1.setBounds(40, 20, 250, 30);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));

        JLabel lblTrinhdo = new JLabel();
        lblTrinhdo.setText("Trình độ");
        lblTrinhdo.setForeground(Color.BLACK);
        lblTrinhdo.setBounds(20, 15, 90, 15);
        lblTrinhdo.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNgaythi = new JLabel();
        lblNgaythi.setText("Ngày thi");
        lblNgaythi.setForeground(Color.BLACK);
        lblNgaythi.setBounds(20, 55, 90, 15);
        lblNgaythi.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblPhongthi = new JLabel();
        lblPhongthi.setText("Phòng thi");
        lblPhongthi.setForeground(Color.BLACK);
        lblPhongthi.setBounds(20, 95, 90, 15);
        lblPhongthi.setFont(new Font("Arial", Font.PLAIN, 15));

        String[] choose = {"A2", "B1"};
        trinhdo = new JComboBox(choose);
        trinhdo.setEditable(false);
        trinhdo.setBounds(95, 10, 120, 30);
        trinhdo.setBackground(Color.white);

        ngaythi = new JTextField();
        ngaythi.setText(null);
        ngaythi.setBounds(95, 50, 120, 30);
        ngaythi.setBackground(Color.white);

        phongthi = new JTextField();
        phongthi.setText(null);
        phongthi.setEditable(false);
        phongthi.setBounds(95, 90, 120, 30);
        phongthi.setBackground(Color.white);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(80, 140, 90, 30);

        JButton btnThoat = new JButton("Thoát ");
        btnThoat.setBackground(Color.red);
        btnThoat.setBounds(80, 180, 90, 30);

        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themPhongthi();
            }
        });

        trinhdo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String trinhdoSelected = (String) trinhdo.getSelectedItem();
                trinhdoSelected = trinhdoSelected.trim();
                phongthi.setText(phongthiBUS.getMaphongthi(trinhdoSelected, khoathi));
            }
        });

        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });

        panel1.add(label1);

        panel2.add(lblTrinhdo);
        panel2.add(lblNgaythi);
        panel2.add(lblPhongthi);
        panel2.add(trinhdo);
        panel2.add(ngaythi);
        panel2.add(phongthi);
        panel2.add(btnThem);
        panel2.add(btnThoat);

        add(panel1);
        add(panel2);
    }

    public void themPhongthi() {
        PhongThiDTO phongThiDTO = new PhongThiDTO();
        phongThiDTO.setKhoaThi(this.khoathi);
        phongThiDTO.setPhongThi(phongthi.getText());
        phongthiBUS.insert(phongThiDTO);
        this.dispose();

        QuanLyKhoaThi_Chitiet chitiet = new QuanLyKhoaThi_Chitiet(QuanLyKhoaThi_Chitiet.location);
        chitiet.setVisible(true);
    }

//    public static void main(String[] args) {
//        QuanLyPhongThi_Them quanLyPhongThiThem = new QuanLyPhongThi_Them("Khoa003");
//        quanLyPhongThiThem.setVisible(true);
//    }

}
