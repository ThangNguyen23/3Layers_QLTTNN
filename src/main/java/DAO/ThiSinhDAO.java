package DAO;

import DTO.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class ThiSinhDAO {
    private Connect connect;
    private ArrayList<ThiSinhDTO> arr;

    public ThiSinhDAO(){
        this.arr = new ArrayList<ThiSinhDTO>();
    }
    
    public ArrayList<ThiSinhDTO> getAll() {
        try {
            connect = new Connect();
            ArrayList temp = connect.loadData("thisinh");

            for(int i = 0; i < temp.size(); i++) {
                ArrayList tempThiSinh = (ArrayList) temp.get(i);
                ThiSinhDTO thiSinhDTO = new ThiSinhDTO();
                thiSinhDTO.setSbd(tempThiSinh.get(0).toString());
                thiSinhDTO.setHo(tempThiSinh.get(1).toString());
                thiSinhDTO.setTen(tempThiSinh.get(2).toString());
                thiSinhDTO.setGioiTinh(tempThiSinh.get(3).toString());
                thiSinhDTO.setNgaySinh(tempThiSinh.get(4).toString());
                thiSinhDTO.setNoiSinh(tempThiSinh.get(5).toString());
                thiSinhDTO.setCmnd(tempThiSinh.get(6).toString());
                thiSinhDTO.setNgayCap(tempThiSinh.get(7).toString());
                thiSinhDTO.setNoiCap(tempThiSinh.get(8).toString());
                thiSinhDTO.setSdt(tempThiSinh.get(9).toString());
                thiSinhDTO.setEmail(tempThiSinh.get(10).toString());
                thiSinhDTO.setPhongThi(tempThiSinh.get(11).toString());
                thiSinhDTO.setKhoaThi(tempThiSinh.get(12).toString());
                
                this.arr.add(thiSinhDTO);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.arr;
    }
    
    public boolean insert(ThiSinhDTO thiSinhDTO) {
        String query = "'" + thiSinhDTO.getSbd() + "',N'" + thiSinhDTO.getHo() + "',N'" + thiSinhDTO.getTen() + "'," + thiSinhDTO.getGioiTinh() + ",'" + thiSinhDTO.getNgaySinh() + "','" + thiSinhDTO.getNoiSinh() + "','" + thiSinhDTO.getCmnd() + "','" + thiSinhDTO.getNgayCap() + "','" + thiSinhDTO.getNoiCap() + "','" + thiSinhDTO.getSdt() + "','" + thiSinhDTO.getEmail() + "','" + thiSinhDTO.getPhongThi() + "','" + thiSinhDTO.getKhoaThi() + "'";
        try {
            connect = new Connect();
            connect.insert("thisinh", query);
            return true;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }        
    }
    
    public int countSbd(String trinhDo, String khoaThi) {
        try {
            String query = "`SBD` LIKE '" + trinhDo + "%' and `khoathi`=\"" + khoaThi + "\"";
            connect = new Connect();

            int count = connect.countWithCondition("thisinh", query);
            return count;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }
    
    public String[] getKhoathi() {
        try {
            String query = "SELECT tenkhoa FROM khoathi WHERE datediff(ngaythi,DATE(now()))>=0;";
            connect = new Connect();
            ArrayList<String> temp = connect.selectStatement(query);

            String[] result = temp.toArray(new String[temp.size()]);
            return result;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList getPhongthiChoThisinh(String khoaThi, String trinhDo) {
        try {
            connect = new Connect();
            String query = "" + "Select phongthi" + " from phongthi, thisinh" + " where tenphong = thisinh.phongthi and thisinh.khoathi=phongthi.khoathi" + " and thisinh.khoathi = \"" + khoaThi + "\" and thisinh.SBD like \"" + trinhDo + "%\"" + " group by thisinh.phongthi" + " having count(*)<=35;";
            ArrayList<String> temp = connect.selectStatement(query);
            return temp;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;            
        }
    }
    
    public ArrayList getPhongthiMoiTao(String khoaThi, String trinhDo) {
        try {
            connect = new Connect();
            String query = "" + "Select tenphong" + " from phongthi" + " where phongthi.khoathi = \""+khoaThi+"\" and " + "phongthi.tenphong like \""+trinhDo+"%\"";
            ArrayList<String> temp = connect.selectStatement(query);
            return temp;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;            
        }
    }

    public ArrayList<String> getPhongthiPhuhopChoThisinh(String khoaThi, String trinhDo, String having) {
        try {
            connect = new Connect();
            String query = "" + "Select tenphong" + " from phongthi, thisinh" + " where tenphong = thisinh.phongthi and thisinh.khoathi=phongthi.khoathi" + " and thisinh.khoathi = \"" + khoaThi + "\" and thisinh.SBD like \"" + trinhDo + "%\"" + " group by phongthi.tenphong" + having;
            ArrayList<String> results = connect.selectStatement(query);
            return results;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
