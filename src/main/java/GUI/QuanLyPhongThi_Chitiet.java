package GUI;

import DTO.*;
import BUS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class QuanLyPhongThi_Chitiet extends JFrame {
    DiemThiBUS diemthiBUS;
    PhongThiDTO phongThiDTO;

    JTable tableTS;
    DefaultTableModel modelTS;
    JScrollPane jScrollPane1;
    Vector headerofTable;

    public QuanLyPhongThi_Chitiet(PhongThiDTO phongThiDTO) {
        this.phongThiDTO = phongThiDTO;

        setTitle("Danh sach thi sinh");
        setSize(760, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel();

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel3.setBackground(Color.lightGray);

        panel1.setPreferredSize(new Dimension(750, 120));
        panel2.setPreferredSize(new Dimension(750, 200));
        panel3.setPreferredSize(new Dimension(750, 230));

        panel1.setLayout(null);
        panel3.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Danh sách thí sinh phòng " + phongThiDTO.getPhongThi());
        label1.setForeground(Color.BLACK);
        label1.setBounds(200, 20, 360, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));

        modelTS = new DefaultTableModel();
        headerofTable = new Vector();
        headerofTable.add("SBD");
        headerofTable.add("Nghe");
        headerofTable.add("Nói");
        headerofTable.add("Đọc");
        headerofTable.add("Viết");

        if (modelTS.getRowCount() == 0) {
            modelTS = new DefaultTableModel(headerofTable, 0);
        }

        tableTS = new JTable();
        tableTS.setModel(modelTS);
        tableTS.setFillsViewportHeight(true);
        tableTS.setForeground(Color.black);
        tableTS.setFillsViewportHeight(true);
        tableTS.getTableHeader().setBackground(Color.white);
        tableTS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableTS.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));

        jScrollPane1 = new JScrollPane(tableTS);
        jScrollPane1.setViewportView(tableTS);
        jScrollPane1.setPreferredSize(new Dimension(700, 200));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton btnNhapdiem = new JButton("Nhập điểm");
        btnNhapdiem.setBounds(300, 20, 120, 30);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBackground(Color.RED);
        btnThoat.setBounds(300, 80, 120, 30);

        btnNhapdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhapDiemTS();
            }
        });

        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        panel1.add(label1);

        panel2.add(jScrollPane1, BorderLayout.CENTER);

        panel3.add(btnNhapdiem);
        panel3.add(btnThoat);

        add(panel1);
        add(panel2);
        add(panel3);

        diemthiBUS = new DiemThiBUS();
        ArrayList<ThiSinhDTO> results = diemthiBUS.getDiemthiFromPhongthi(this.phongThiDTO.getPhongThi(), this.phongThiDTO.getKhoaThi());
        this.loadDulieuTable(results);
    }

    public void run() {
        this.setVisible(true);
    }


    public void nhapDiemTS() {
        ThiSinhBUS thisinhbus = new ThiSinhBUS();
        ArrayList result = thisinhbus.getThisinh(phongThiDTO.getPhongThi(), phongThiDTO.getKhoaThi());
        QuanLyDiemThi_Nhapdiem nhapDiem = new QuanLyDiemThi_Nhapdiem(result);
        nhapDiem.setVisible(true);
    }

    public void loadDulieuTable(ArrayList newData) {
        if (modelTS !=null) {
            modelTS = new DefaultTableModel(headerofTable, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }

        for(int i = 0; i < newData.size(); i++) {
            Vector row = new Vector();
            DiemThiDTO diemThiDTO = (DiemThiDTO) newData.get(i);
            row.add(diemThiDTO.getSbd());
            row.add(diemThiDTO.getNghe());
            row.add(diemThiDTO.getNoi());
            row.add(diemThiDTO.getDoc());
            row.add(diemThiDTO.getViet());
            modelTS.addRow(row);
        }
        tableTS.setModel(modelTS);
    }

//    public static void main(String[] args) {
//        QuanLyPhongThi_Chitiet quanLyPhongThiChitiet = new QuanLyPhongThi_Chitiet(new PhongThiDTO("A2P01","Khoa003"));
//        quanLyPhongThiChitiet.run();
//    }

}
