package GUI;

import DTO.*;
import BUS.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class QuanLyKhoaThi_Chitiet extends JFrame {
    KhoaThiBUS khoathiBUS;
    KhoaThiDTO khoaThiDTO;

    JTable tablePhongthi;
    DefaultTableModel modelTable;
    Vector headerOfTable;
    JScrollPane jScrollPane1;
    int press = -1;

    public static int location;
    String phongthiSelected = "";

    public QuanLyKhoaThi_Chitiet(int location) {
        khoathiBUS = new KhoaThiBUS();
        QuanLyKhoaThi_Chitiet.location = location;
        khoaThiDTO = khoathiBUS.arr.get(location);

        setTitle("Chi tiết khóa thi");
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel3.setBackground(Color.lightGray);

        panel1.setPreferredSize(new Dimension(500, 100));
        panel2.setPreferredSize(new Dimension(500, 200));
        panel3.setPreferredSize(new Dimension(500, 150));

        panel1.setLayout(null);
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(null);            

        JLabel label1 = new JLabel();
        label1.setText("Chi tiết khóa thi "+ khoaThiDTO.getKhoaThi());
        label1.setForeground(Color.BLACK);
        label1.setBounds(110, 10, 360, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));

        modelTable = new DefaultTableModel();
        headerOfTable = new Vector();
        headerOfTable.add("Phòng thi");
        headerOfTable.add("Ngày thi");
        headerOfTable.add("Trình độ");
        headerOfTable.add("Số lượng thí sinh");
        if (modelTable.getRowCount() == 0) {
            modelTable = new DefaultTableModel(headerOfTable, 0);
        }

        tablePhongthi = new JTable();
        tablePhongthi.setModel(modelTable);
        tablePhongthi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablePhongthi.setForeground(Color.black);
        tablePhongthi.setFillsViewportHeight(true);
        tablePhongthi.getTableHeader().setBackground(Color.white);
        tablePhongthi.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));

        jScrollPane1 = new JScrollPane(tablePhongthi);
        jScrollPane1.setViewportView(tablePhongthi);
        jScrollPane1.setPreferredSize(new Dimension(470, 200));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(120, 25, 90, 30);

        JButton btnChitiet = new JButton("Chi tiết");
        btnChitiet.setBounds(280, 25, 90, 30);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.red);
        btnThoat.setBounds(200, 75, 90, 30);

        tablePhongthi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {             
                clickTable();
            }
        });


        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themPhongthi();
            }
        });

        btnChitiet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chitietPhongthi();
            }
        });
        
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        panel1.add(label1);
        panel2.add(jScrollPane1);

        panel3.add(btnThem);
        panel3.add(btnChitiet);
        panel3.add(btnThoat);

        add(panel1);
        add(panel2);
        add(panel3);

//        load data
        ArrayList phongThi = khoathiBUS.getPhongthi(khoaThiDTO.khoaThi);
        this.loadDulieuTable(phongThi);
    }

    public void themPhongthi() {
        QuanLyPhongThi_Them a = new QuanLyPhongThi_Them(khoaThiDTO.getKhoaThi());
        a.setVisible(true);
    }

    public void loadDulieuTable(ArrayList newData) {
        if (modelTable !=null) {
            modelTable = new DefaultTableModel(headerOfTable, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }

        ThiSinhBUS thisinhBUS = new ThiSinhBUS();
        for(int i = 0; i < newData.size(); i++) {
            Vector row = new Vector();
            PhongThiDTO phongthi = (PhongThiDTO)newData.get(i);
            row.add(phongthi.getPhongThi());
            row.add(khoaThiDTO.getNgayThi());
            row.add(khoathiBUS.getTrinhdo(phongthi.getPhongThi()));
            row.add(thisinhBUS.countThisinhInPhongthi(phongthi.getPhongThi(), khoaThiDTO.getKhoaThi()));
            modelTable.addRow(row);
        }
        tablePhongthi.setModel(modelTable);
    }
    
    public void clickTable() {
        int i = tablePhongthi.getSelectedRow();
        if(press == -1) {
            ArrayList phongThi = khoathiBUS.getPhongthi(khoaThiDTO.getKhoaThi());
            PhongThiDTO phongThiDTO = (PhongThiDTO) phongThi.get(i);
            phongthiSelected = phongThiDTO.getPhongThi();
            press = i;
        }
        else {
            press = -1;
        }
    }

    public void chitietPhongthi() {
        int i = tablePhongthi.getSelectedRow();
        if(i != -1) {
            PhongThiDTO phongThiDTO = new PhongThiDTO();
            phongThiDTO.setKhoaThi(this.khoaThiDTO.getKhoaThi());
            phongThiDTO.setPhongThi(phongthiSelected);
            QuanLyPhongThi_Chitiet a = new QuanLyPhongThi_Chitiet(phongThiDTO);
            a.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Chưa chọn phòng !","Select an option", JOptionPane.CANCEL_OPTION);
        }
    }
    
//    public static void main(String[] args) {
//        QuanLyKhoaThi_Chitiet quanLyKhoaThiChitiet = new QuanLyKhoaThi_Chitiet(1);
//        quanLyKhoaThiChitiet.setVisible(true);
//    }

}
