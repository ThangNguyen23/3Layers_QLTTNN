package GUI;

import BUS.*;
import DTO.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {
    JTable jTableTS;
    DefaultTableModel modelTableTS;

    JComboBox jComboBoxTimKiem;
    JButton jButtonTimKiem;
    JTextField jTextFieldTimKiem;
    Vector vectorHeaderTable;
    JScrollPane jScrollPaneTable;

    ThiSinhBUS thisinhBus;
    int press=-1;
   
   public MainGUI() {
        setTitle("Danh sach thi sinh");
        setSize(750, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel3.setBackground(Color.lightGray);

        panel1.setPreferredSize(new Dimension(750, 120));
        panel2.setPreferredSize(new Dimension(750, 200));
        panel3.setPreferredSize(new Dimension(750, 230));

        panel1.setLayout(null);
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Danh sách thí sinh");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        label1.setBounds(250, 10, 360, 50);

        modelTableTS = new DefaultTableModel();
        vectorHeaderTable = new Vector();
        vectorHeaderTable.add("SBD");
        vectorHeaderTable.add("Họ");
        vectorHeaderTable.add("Tên");
        vectorHeaderTable.add("Giới tính");
        vectorHeaderTable.add("Ngày sinh");
        vectorHeaderTable.add("Nơi sinh");
        vectorHeaderTable.add("CMND");
        vectorHeaderTable.add("Ngày cấp");
        vectorHeaderTable.add("Nơi cấp");
        vectorHeaderTable.add("SDT");
        vectorHeaderTable.add("Email");
        vectorHeaderTable.add("Phòng Thi");
        vectorHeaderTable.add("Khóa Thi");

       if (modelTableTS.getRowCount() == 0) {
            modelTableTS = new DefaultTableModel(vectorHeaderTable, 0);
        }
        jTableTS = new JTable();
        jTableTS.setModel(modelTableTS);
        jTableTS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableTS.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableTS.setForeground(Color.black);
        jTableTS.setFillsViewportHeight(true);
        jTableTS.getTableHeader().setBackground(Color.white);
        jTableTS.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));

        jScrollPaneTable = new JScrollPane(jTableTS);
        jScrollPaneTable.setViewportView(jTableTS);
        jScrollPaneTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneTable.setPreferredSize(new Dimension(720, 200));

        String[] choose = {"SBD", "Tên", "CMND", "Phòng Thi","Khóa Thi", "SDT"};
        jComboBoxTimKiem = new JComboBox(choose);
        jComboBoxTimKiem.setSelectedIndex(1);
        jComboBoxTimKiem.setBounds(200, 75, 100, 25);

        jTextFieldTimKiem = new JTextField();
        jTextFieldTimKiem.setBounds(310, 75, 150, 25);

        jButtonTimKiem = new JButton();
        jButtonTimKiem.setText("Tìm");
        jButtonTimKiem.setForeground(Color.black);
        jButtonTimKiem.setFont(new Font("Arial", Font.PLAIN, 15));
        jButtonTimKiem.setBounds(480, 75, 80, 25);
        
        JButton themTS = new JButton("Thêm");
        themTS.setBounds(200, 10, 120, 30);

        JButton capNhatTable = new JButton("Cập nhật");
        capNhatTable.setBounds(200, 70, 120, 30);
        
        JButton QLKT = new JButton("QLKT");
        QLKT.setBounds(400, 10, 120, 30);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.RED);
        btnThoat.setBounds(400, 70, 120, 30);

        jButtonTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timKiemTS();
        }});

        jTableTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = jTableTS.getSelectedRow();
                if (i == press) {
                    clickTable(i);
                    press = i;
                }
            }});

        themTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themTS();
            }
        });

        QLKT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quanLiKhoaThi();
            }
        });

        capNhatTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                capNhatDulieu();
            }
        });
        
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        panel1.add(label1);
        panel1.add(jComboBoxTimKiem);
        panel1.add(jTextFieldTimKiem);
        panel1.add(jButtonTimKiem);

        panel2.add(jScrollPaneTable);

        panel3.add(themTS);
        panel3.add(QLKT);
        panel3.add(capNhatTable);
        panel3.add(btnThoat);

        add(panel1);
        add(panel2);
        add(panel3);
        capNhatDulieu();
    }

    public void run() {
        this.setVisible(true);
    }

    public void capNhatDulieu() {
        thisinhBus = new ThiSinhBUS();
        ArrayList<ThiSinhDTO> result = thisinhBus.arr;
        this.loadDuLieuTable(result);
    }

    public void themTS() {
        QuanLyThiSinh_Them insert = new QuanLyThiSinh_Them();
        insert.setVisible(true);
    }

    public void quanLiKhoaThi() {
        QuanLyKhoaThi quanLyKhoaThi = new QuanLyKhoaThi();
        quanLyKhoaThi.run();
    }

    public void clickTable(int i) {}

    public void timKiemTS() {
        String text = jTextFieldTimKiem.getText();
        int selectedIndex = jComboBoxTimKiem.getSelectedIndex();
        ArrayList result = thisinhBus.timTheoDieuKien(selectedIndex, text);
        this.loadDuLieuTable(result);
    }

    public void loadDuLieuTable(ArrayList newData) {
        if (modelTableTS !=null) {
            modelTableTS = new DefaultTableModel(vectorHeaderTable, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }
        for(int i = 0; i < newData.size(); i++) {
            Vector row = new Vector();
            ThiSinhDTO thisinh = (ThiSinhDTO) newData.get(i);
            row.add(thisinh.getSbd());
            row.add(thisinh.getHo());
            row.add(thisinh.getTen());
            String gioiTinhTS = "";
            String gioiTinh = thisinh.getGioiTinh();
            if (gioiTinh.equals("0")) {
                gioiTinhTS = "Nữ";
            }
            else {
                gioiTinhTS = "Nam";
            }
            row.add(gioiTinhTS);
            row.add(thisinh.getNgaySinh());
            row.add(thisinh.getNoiSinh());
            row.add(thisinh.getCmnd());
            row.add(thisinh.getNgayCap());
            row.add(thisinh.getNoiCap());
            row.add(thisinh.getSdt());
            row.add(thisinh.getEmail());
            row.add(thisinh.getPhongThi());
            row.add(thisinh.getKhoaThi());
            modelTableTS.addRow(row);
        }
        jTableTS.setModel(modelTableTS);
    }

    public static void main(String[] args) {
        MainGUI mainGUI = new MainGUI();
        mainGUI.run();
    }
}
