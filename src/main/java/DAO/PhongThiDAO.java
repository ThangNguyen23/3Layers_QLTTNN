package DAO;

import DTO.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class PhongThiDAO {
    private Connect connect;
    private ArrayList<PhongThiDTO> arr;
    
    public PhongThiDAO() {
        this.arr = new ArrayList<PhongThiDTO>();
    }
    
    public ArrayList<PhongThiDTO> getAll() {
        try {
            connect = new Connect();
            ArrayList temp = connect.loadData("phongthi");

            for(int i = 0; i < temp.size(); i++) {
                ArrayList tempPhongThi = (ArrayList) temp.get(i);
                PhongThiDTO phongThiDTO = new PhongThiDTO();
                phongThiDTO.setPhongThi(tempPhongThi.get(0).toString());
                phongThiDTO.setKhoaThi(tempPhongThi.get(1).toString());
                
                this.arr.add(phongThiDTO);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.arr;
    }
    
    public boolean insert(PhongThiDTO phongThiDTO) {
        String query = "'" + phongThiDTO.getPhongThi() + "','" + phongThiDTO.getKhoaThi() + "'";
        try {
            connect = new Connect();
            connect.insert("phongthi", query);
            return true;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }        
    }

    public ArrayList<String> getPhongthiTrinhdoKhoathi(String khoaThi, String trinhDo) {
        try {
            connect = new Connect();
            String query = "" + "Select tenphong" + " from phongthi" + " where phongthi.khoathi = '" + khoaThi + "' and tenphong like '" + trinhDo + "%'";
            ArrayList<String> temp = connect.selectStatement(query);
            return temp;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
