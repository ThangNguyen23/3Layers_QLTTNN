package DAO;

import DTO.*;

import java.util.ArrayList;
import java.sql.SQLException;

public class KhoaThiDAO {
    private Connect connect;
    private ArrayList<KhoaThiDTO> arr;
    
    public KhoaThiDAO() {
        this.arr = new ArrayList<KhoaThiDTO>();
    }
    
    public ArrayList<KhoaThiDTO> getAll() {
        try {
            connect = new Connect();
            ArrayList temp = connect.loadData("khoathi");

            for(int i = 0; i < temp.size(); i++) {
                ArrayList tempKhoaThi = (ArrayList) temp.get(i);
                KhoaThiDTO khoaThiDTO = new KhoaThiDTO();
                khoaThiDTO.setKhoaThi(tempKhoaThi.get(0).toString());
                khoaThiDTO.setNgayThi(tempKhoaThi.get(1).toString());
                
                this.arr.add(khoaThiDTO);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.arr;
    }
    
    public boolean insert(KhoaThiDTO khoaThiDTO) {
        String query = "'" + khoaThiDTO.getKhoaThi() + "','" + khoaThiDTO.getNgayThi() + "'";
        try {
            connect = new Connect();
            connect.insert("khoathi", query);
            return true;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }        
    }
}
