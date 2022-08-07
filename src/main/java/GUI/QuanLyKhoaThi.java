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

public class QuanLyKhoaThi extends JFrame {
    KhoaThiBUS khoathiBUS;

    DefaultTableModel modelTS;
    JTable jTableTS;
    Vector headerOfTable;
    JButton btnTimkiem;
    JTextField txtTimkiem;
    JScrollPane jScrollPane1;
    int press=-1;

    public QuanLyKhoaThi() {
        setTitle("Danh sach khoa thi");
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

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
        label1.setText("Danh sách khóa thi");
        label1.setForeground(Color.BLACK);
        label1.setBounds(150, 10, 360, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));

        modelTS = new DefaultTableModel();
        headerOfTable = new Vector();
        headerOfTable.add("Khóa thi");
        headerOfTable.add("Ngày thi");
        if (modelTS.getRowCount() == 0) {
            modelTS = new DefaultTableModel(headerOfTable, 0);
        }

        jTableTS = new JTable();
        jTableTS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableTS.setModel(modelTS);
        jTableTS.setForeground(Color.black);
        jTableTS.setFillsViewportHeight(true);
        jTableTS.getTableHeader().setBackground(Color.white);
        jTableTS.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));

        jScrollPane1 = new JScrollPane(jTableTS);
        jScrollPane1.setViewportView(jTableTS);
        jScrollPane1.setPreferredSize(new Dimension(470, 200));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtTimkiem = new JTextField();
        txtTimkiem.setBounds(25, 75, 350, 25);

        btnTimkiem = new JButton();
        btnTimkiem.setText("Tìm");
        btnTimkiem.setForeground(Color.black);
        btnTimkiem.setBounds(390, 75, 80, 25);
        btnTimkiem.setFont(new Font("Arial", Font.PLAIN, 15));

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(120, 25, 90, 25);

        JButton btnChitiet = new JButton("Chi tiết");
        btnChitiet.setBounds(280, 25, 90, 25);
        
        JButton btnCapnhat = new JButton("Cập nhật");
        btnCapnhat.setBounds(120, 75, 90, 25);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.red);
        btnThoat.setBounds(280, 75, 90, 25);

        btnTimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timKiem();
            }
        });

        jTableTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = jTableTS.getSelectedRow();
                if (i == press) {
                    clickTable(i);
                    press = i;
                }
            }});

        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themKhoathiMoi();
            }
        });
        
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        
        btnChitiet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chitietPhongthi();
            }
        });
        
        btnCapnhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                capnhatDulieu();
            }
        });

        panel1.add(label1);
        panel1.add(txtTimkiem);
        panel1.add(btnTimkiem);

        panel2.add(jScrollPane1);

        panel3.add(btnThem);
        panel3.add(btnChitiet);
        panel3.add(btnCapnhat);
        panel3.add(btnThoat);

        add(panel1);
        add(panel2);
        add(panel3);
    }

    public void run() {
        this.setVisible(true);
    }

    public void capnhatDulieu() {
        khoathiBUS = new KhoaThiBUS();
        ArrayList<KhoaThiDTO> result = khoathiBUS.arr;
        this.loadDulieuTable(result);
    }

    public void themKhoathiMoi() {
        QuanLyKhoaThi_Them them = new QuanLyKhoaThi_Them();
        them.setVisible(true);
    }

    public void clickTable(int i) {
        KhoaThiDTO temp = khoathiBUS.arr.get(i);
    }

    public void timKiem() {
        String khoa = this.txtTimkiem.getText();
        ArrayList result = khoathiBUS.timKhoathi(khoa);
        this.loadDulieuTable(result);
    }

    public void chitietPhongthi() {
        int i = jTableTS.getSelectedRow();
        if(i != -1) {
            QuanLyKhoaThi_Chitiet chitiet = new QuanLyKhoaThi_Chitiet(i);
            chitiet.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this,"Chưa chọn khóa thi !","Select an option", JOptionPane.CANCEL_OPTION);
        }
    }

    public void loadDulieuTable(ArrayList newData) {
        if (modelTS !=null) {
            modelTS = new DefaultTableModel(headerOfTable, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }

        for(int i = 0; i < newData.size(); i++) {
            Vector row = new Vector();
            KhoaThiDTO khoaThiDTO = (KhoaThiDTO) newData.get(i);
            row.add(khoaThiDTO.getKhoaThi());
            row.add(khoaThiDTO.getNgayThi());
            modelTS.addRow(row);
        }
        jTableTS.setModel(modelTS);
    }

//    public static void main(String[] args){
//        QuanLyKhoaThi quanLyKhoaThi = new QuanLyKhoaThi();
//        quanLyKhoaThi.run();
//    }

}
