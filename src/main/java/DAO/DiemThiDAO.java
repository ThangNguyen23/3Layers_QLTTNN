package DAO;

import DTO.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class DiemThiDAO {
    private Connect connect;
    private ArrayList<DiemThiDTO> arr;
    
    public DiemThiDAO(){
        this.arr = new ArrayList<DiemThiDTO>();
    }
    
    public ArrayList<DiemThiDTO> getAll() {
        try {
            connect = new Connect();
            ArrayList temp = connect.loadData("diemthi");

            for(int i = 0; i < temp.size(); i++) {
                ArrayList tempDiemThi = (ArrayList) temp.get(i);
                DiemThiDTO diemThiDTO = new DiemThiDTO();
                diemThiDTO.setSbd(tempDiemThi.get(0).toString());
                diemThiDTO.setKhoaThi(tempDiemThi.get(1).toString());
                diemThiDTO.setNghe(Float.parseFloat(tempDiemThi.get(2).toString()));
                diemThiDTO.setNoi(Float.parseFloat(tempDiemThi.get(3).toString()));
                diemThiDTO.setDoc(Float.parseFloat(tempDiemThi.get(4).toString()));
                diemThiDTO.setViet(Float.parseFloat(tempDiemThi.get(5).toString()));
                
                this.arr.add(diemThiDTO);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.arr;
    }
    
    public boolean insert(DiemThiDTO diemThiDTO) {
        String query = "'" + diemThiDTO.getSbd() + "','" + diemThiDTO.getKhoaThi() + "'," + diemThiDTO.getNghe() + "," + diemThiDTO.getNoi() + "," + diemThiDTO.getDoc() + "," + diemThiDTO.getViet();
        try {
            connect = new Connect();
            connect.insert("diemthi", query);
            return true;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }        
    }
}
