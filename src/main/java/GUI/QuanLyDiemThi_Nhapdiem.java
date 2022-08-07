package GUI;

import DTO.*;
import BUS.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class QuanLyDiemThi_Nhapdiem extends JFrame {
    int location;
    JTextField SBD, nghe, noi, doc,viet;
    DiemThiBUS diemThiBUS;
    ThiSinhDTO thisinhVitri;
    ArrayList<ThiSinhDTO> thisinhNhapDiem;

    public QuanLyDiemThi_Nhapdiem(ArrayList<ThiSinhDTO> thisinhNhapDiem) {
        this.thisinhNhapDiem = thisinhNhapDiem;
        thisinhVitri = this.thisinhNhapDiem.get(0);
        this.location = 0;

        setTitle("Nhập điểm");
        setSize(300, 470);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);

        panel1.setPreferredSize(new Dimension(300,100));
        panel2.setPreferredSize(new Dimension(300,370));

        panel1.setLayout(null);
        panel2.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Nhập điểm");
        label1.setForeground(Color.BLACK);
        label1.setBounds(85, 35, 250, 30);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));

        JLabel lblSBD = new JLabel();
        lblSBD.setText("SBD");
        lblSBD.setForeground(Color.BLACK);
        lblSBD.setBounds(30, 15, 90, 15);
        lblSBD.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNghe = new JLabel();
        lblNghe.setText("Nghe");
        lblNghe.setForeground(Color.BLACK);
        lblNghe.setBounds(30, 55, 90, 15);
        lblNghe.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblNoi = new JLabel();
        lblNoi.setText("Nói");
        lblNoi.setForeground(Color.BLACK);
        lblNoi.setBounds(30, 95, 90, 15);
        lblNoi.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblDoc = new JLabel();
        lblDoc.setText("Đọc");
        lblDoc.setForeground(Color.BLACK);
        lblDoc.setBounds(30, 135, 90, 15);
        lblDoc.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel lblViet = new JLabel();
        lblViet.setText("Viết");
        lblViet.setForeground(Color.BLACK);
        lblViet.setBounds(30, 175, 90, 15);
        lblViet.setFont(new Font("Arial", Font.PLAIN, 15));

        SBD = new JTextField();
        SBD.setEditable(false);
        SBD.setText(thisinhVitri.getSbd());
        SBD.setBounds(100, 10, 130, 25);
        SBD.setBackground(Color.white);

        this.nghe = new JTextField();
        this.nghe.setText(null);
        this.nghe.setBounds(100, 50, 130, 25);
        this.nghe.setBackground(Color.white);

        this.noi = new JTextField();
        this.noi.setText(null);
        this.noi.setBounds(100, 90, 130, 25);
        this.noi.setBackground(Color.white);
        
        
        this.doc = new JTextField();
        this.doc.setText(null);
        this.doc.setBounds(100, 130, 130, 25);
        this.doc.setBackground(Color.white);
        
        
        this.viet = new JTextField();
        this.viet.setText(null);
        this.viet.setBounds(100, 170, 130, 25);
        this.viet.setBackground(Color.white);
        
        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(100, 220, 100, 30);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.red);
        btnThoat.setBounds(100, 270, 100, 30);

        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themDiemTS();
            }
        });

        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });

        this.nghe.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    noi.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    noi.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });

        this.noi.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    doc.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    doc.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });

        this.doc.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    viet.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    viet.requestFocus();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });

        this.viet.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    themDiemTS();
                    nghe.setText(null);
                    noi.setText(null);
                    doc.setText(null);
                    viet.setText(null);
                    nghe.requestFocus();
                }
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    themDiemTS();
                    nghe.setText(null);
                    noi.setText(null);
                    doc.setText(null);
                    viet.setText(null);
                    nghe.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });

        panel1.add(label1);
        
        panel2.add(lblSBD);
        panel2.add(lblNghe);
        panel2.add(lblNoi);
        panel2.add(lblDoc);
        panel2.add(SBD);
        panel2.add(this.nghe);
        panel2.add(this.noi);
        panel2.add(this.doc);
        panel2.add(this.viet);
        panel2.add(lblViet);
        panel2.add(btnThem);
        panel2.add(btnThoat);
        
        add(panel1);
        add(panel2);
    }

    public void themDiemTS() {
        DiemThiDTO diemThiDTO = new DiemThiDTO();
        diemThiDTO.setSbd(this.SBD.getText());
        diemThiDTO.setKhoaThi(this.thisinhVitri.getKhoaThi());
        diemThiDTO.setNghe(Float.parseFloat(this.nghe.getText()));
        diemThiDTO.setNoi(Float.parseFloat(this.noi.getText()));
        diemThiDTO.setDoc(Float.parseFloat(this.doc.getText()));
        diemThiDTO.setViet(Float.parseFloat(this.viet.getText()));
        
        diemThiBUS = new DiemThiBUS();
        diemThiBUS.insert(diemThiDTO);

        if(location < thisinhNhapDiem.size() - 1) {
            location++;
            thisinhVitri = thisinhNhapDiem.get(location);
            SBD.setText(thisinhVitri.getSbd());
        }
        else {
            this.dispose();
        }
    }

//    public static void main(String[] args) {
//        ThiSinhBUS thisinhbus = new ThiSinhBUS();
//        ArrayList result = thisinhbus.getThisinh("A2P01", "Khoa003");
//        QuanLyDiemThi_Nhapdiem diemthiThisinh = new QuanLyDiemThi_Nhapdiem(result);
//        diemthiThisinh.setVisible(true);
//    }

}
