package GUI;

import DTO.*;
import BUS.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class QuanLyThiSinh_Them extends JFrame {
    ThiSinhBUS thisinhBus;

    ButtonGroup groupGioitinh;
    JComboBox comboBoxTrinhdo, comboBoxKhoathi;
    JRadioButton radioButtonNu, radioButtonNam;
    JTextField ho, ten, ngaySinh, noiSinh, cmnd, ngayCap, noiCap, sdt, email;

    public QuanLyThiSinh_Them() {
        setTitle("Them Thi Sinh");
        setSize(520, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel1.setPreferredSize(new Dimension(520, 50));
        panel2.setPreferredSize(new Dimension(520,400));

        panel1.setLayout(null);
        panel2.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Thêm Thí Sinh");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        label1.setBounds(180, 5, 350, 50);

        JLabel lblTrinhdo = new JLabel();
        lblTrinhdo.setText("Trình độ");
        lblTrinhdo.setForeground(Color.BLACK);
        lblTrinhdo.setBounds(20, 10, 90, 30);
        lblTrinhdo.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblHo = new JLabel();
        lblHo.setText("Họ");
        lblHo.setForeground(Color.BLACK);
        lblHo.setBounds(20, 60, 90, 30);
        lblHo.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblTen = new JLabel();
        lblTen.setText("Tên");
        lblTen.setForeground(Color.BLACK);
        lblTen.setBounds(20, 110, 90, 30);
        lblTen.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblGioitinh = new JLabel();
        lblGioitinh.setText("Giới tính");
        lblGioitinh.setForeground(Color.BLACK);
        lblGioitinh.setBounds(20, 160, 90, 30);
        lblGioitinh.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNgaysinh = new JLabel();
        lblNgaysinh.setText("Ngày sinh");
        lblNgaysinh.setForeground(Color.BLACK);
        lblNgaysinh.setBounds(20, 210, 90, 30);
        lblNgaysinh.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNoisinh = new JLabel();
        lblNoisinh.setText("Nơi sinh");
        lblNoisinh.setForeground(Color.BLACK);
        lblNoisinh.setBounds(20, 260, 90, 30);
        lblNoisinh.setFont(new Font("Arail", Font.PLAIN, 15));

        JLabel lblKhoathi = new JLabel();
        lblKhoathi.setText("Khóa Thi");
        lblKhoathi.setForeground(Color.BLACK);
        lblKhoathi.setBounds(270, 10, 90, 30);
        lblKhoathi.setFont(new Font("Arail", Font.PLAIN, 15));

        JLabel lblCmnd = new JLabel();
        lblCmnd.setText("CMND");
        lblCmnd.setForeground(Color.BLACK);
        lblCmnd.setBounds(270, 60, 90, 30);
        lblCmnd.setFont(new Font("Arail", Font.PLAIN, 15));

        JLabel lblNgaycap = new JLabel();
        lblNgaycap.setText("Ngày cấp");
        lblNgaycap.setForeground(Color.BLACK);
        lblNgaycap.setBounds(270, 110, 90, 30);
        lblNgaycap.setFont(new Font("Arail", Font.PLAIN, 15));

        JLabel lblNoicap = new JLabel();
        lblNoicap.setText("Nơi cấp");
        lblNoicap.setForeground(Color.BLACK);
        lblNoicap.setBounds(270, 160, 90, 30);
        lblNoicap.setFont(new Font("Arail", Font.PLAIN, 15));

        JLabel lblSdt = new JLabel();
        lblSdt.setText("SDT");
        lblSdt.setForeground(Color.BLACK);
        lblSdt.setBounds(270, 210, 90, 30);
        lblSdt.setFont(new Font("Arail", Font.PLAIN, 15));

        JLabel lblEmail = new JLabel();
        lblEmail.setText("Email");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBounds(270, 260, 90, 30);
        lblEmail.setFont(new Font("Arail", Font.PLAIN, 15));

        String[] choose = {"A2", "B1"};
        comboBoxTrinhdo = new JComboBox(choose);
        comboBoxTrinhdo.setEditable(false);
        comboBoxTrinhdo.setBackground(Color.white);
        comboBoxTrinhdo.setBounds(100, 15, 130, 20);

        this.ho = new JTextField();
        this.ho.setText(null);
        this.ho.setBackground(Color.white);
        this.ho.setBounds(100, 65, 130, 20);

        this.ten = new JTextField();
        this.ten.setText(null);
        this.ten.setBackground(Color.white);
        this.ten.setBounds(100, 115, 130, 20);

        groupGioitinh = new ButtonGroup();
        radioButtonNu = new JRadioButton("Nữ", false);
        radioButtonNam = new JRadioButton("Nam", false);
        groupGioitinh.add(radioButtonNu);
        groupGioitinh.add(radioButtonNam);
        groupGioitinh.setSelected(radioButtonNu.getModel(), true);
        radioButtonNu.setBounds(100, 165, 70, 20);
        radioButtonNam.setBounds(170, 165, 60, 20);

        this.ngaySinh = new JTextField();
        this.ngaySinh.setText(null);
        this.ngaySinh.setBackground(Color.white);
        this.ngaySinh.setBounds(100, 215, 130, 20);
        
        this.noiSinh = new JTextField();
        this.noiSinh.setText(null);
        this.noiSinh.setBackground(Color.white);
        this.noiSinh.setBounds(100, 265, 130, 20);

        String[] chooses = this.getKhoathiDB();
        this.comboBoxKhoathi = new JComboBox(chooses);
        this.comboBoxKhoathi.setBackground(Color.white);
        this.comboBoxKhoathi.setBounds(350, 15, 130, 20);
        
        this.cmnd = new JTextField();
        this.cmnd.setText(null);
        this.cmnd.setBackground(Color.white);
        this.cmnd.setBounds(350, 65, 130, 20);
        
        this.ngayCap = new JTextField();
        this.ngayCap.setText(null);
        this.ngayCap.setBackground(Color.white);
        this.ngayCap.setBounds(350, 115, 130, 20);
        
        this.noiCap = new JTextField();
        this.noiCap.setText(null);
        this.noiCap.setBackground(Color.white);
        this.noiCap.setBounds(350, 165, 130, 20);
        
        this.sdt = new JTextField();
        this.sdt.setText(null);
        this.sdt.setBackground(Color.white);
        this.sdt.setBounds(350, 215, 130, 20);
        
        this.email = new JTextField();
        this.email.setText(null);
        this.email.setBackground(Color.white);
        this.email.setBounds(350, 265, 130, 20);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(120, 310, 100, 30);
        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.red);
        btnThoat.setBounds(280, 310, 100, 30);

        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themTSMoi();
            }
        });

        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thoatForm();
            }
        });

        panel1.add(label1);

        panel2.add(lblTrinhdo);
        panel2.add(lblHo);
        panel2.add(lblTen);
        panel2.add(lblGioitinh);
        panel2.add(lblNgaysinh);
        panel2.add(lblNoisinh);

        panel2.add(lblKhoathi);
        panel2.add(lblCmnd);
        panel2.add(lblNgaycap);
        panel2.add(lblNoicap);
        panel2.add(lblSdt);
        panel2.add(lblEmail);

        panel2.add(btnThem);
        panel2.add(btnThoat);
        
        panel2.add(comboBoxTrinhdo);
        panel2.add(this.ho);
        panel2.add(this.ten);
        panel2.add(radioButtonNam);
        panel2.add(radioButtonNu);
        panel2.add(this.ngaySinh);
        panel2.add(this.noiSinh);

        panel2.add(this.comboBoxKhoathi);
        panel2.add(this.cmnd);
        panel2.add(this.ngayCap);
        panel2.add(this.noiCap);
        panel2.add(this.sdt);
        panel2.add(this.email);

        add(panel1);
        add(panel2);
    }

    public void run() {
        setVisible(true);
    }

    public boolean kiemTraNhap() {
        if(this.ho.getSelectionEnd() == 0 || this.ten.getSelectionEnd() ==0 || this.ngaySinh.getSelectionEnd() ==0 || this.noiSinh.getSelectionEnd() ==0 || this.cmnd.getSelectionEnd() == 0 || this.ngayCap.getSelectionEnd() == 0 || this.noiCap.getSelectionEnd() == 0 || this.sdt.getSelectionEnd() == 0 || this.email.getSelectionEnd() == 0) {
            JOptionPane.showMessageDialog(this, "Thông tin không được để trống !","Select an option", JOptionPane.CANCEL_OPTION);
            return false;
        }
        return true;
    }

    public void themTSMoi() {
        if (this.kiemTraNhap() == false) {
            return;
        }
        String trinhdo = (String) this.comboBoxTrinhdo.getSelectedItem();
        trinhdo = trinhdo.trim();

        ThiSinhDTO thiSinhDTO = new ThiSinhDTO();
        thiSinhDTO.setHo(this.ho.getText());
        thiSinhDTO.setTen(this.ten.getText());
        if (this.radioButtonNu.isSelected()) {
            thiSinhDTO.setGioiTinh("0");
        }
        else {
            thiSinhDTO.setGioiTinh("1");
        }
        thiSinhDTO.setNgaySinh(this.ngaySinh.getText());
        thiSinhDTO.setNoiSinh(this.noiSinh.getText());

        thiSinhDTO.setKhoaThi((String) this.comboBoxKhoathi.getSelectedItem());
        thiSinhDTO.setCmnd(this.cmnd.getText());
        thiSinhDTO.setNgayCap(this.ngayCap.getText());
        thiSinhDTO.setNoiCap(this.noiCap.getText());
        thiSinhDTO.setSdt(this.sdt.getText());
        thiSinhDTO.setEmail(this.email.getText());

        thiSinhDTO.setPhongThi(thisinhBus.getPhongthiNew((String) this.comboBoxKhoathi.getSelectedItem(), trinhdo));
        thisinhBus.insertAndCreateSbd(thiSinhDTO, trinhdo, (String) this.comboBoxKhoathi.getSelectedItem());
        this.dispose();
    }

    public String[] getKhoathiDB() {
        thisinhBus = new ThiSinhBUS();
        return thisinhBus.getKhoathi();
    }
    
    public void thoatForm(){
        this.dispose();
    }

//    public static void main(String[] args) {
//        QuanLyThiSinh_Them quanLyThiSinhThem = new QuanLyThiSinh_Them();
//        quanLyThiSinhThem.setVisible(true);
//    }

}
