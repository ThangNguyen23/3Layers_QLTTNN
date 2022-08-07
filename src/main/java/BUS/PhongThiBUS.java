package BUS;

import DTO.*;
import DAO.*;
import java.util.ArrayList;

public class PhongThiBUS {
    public PhongThiDAO phongThiDAO;
    public ArrayList<PhongThiDTO> arr;
    
    public PhongThiBUS() {
        phongThiDAO = new PhongThiDAO();
        this.arr = phongThiDAO.getAll();
        if(this.arr.isEmpty()) {
            System.out.println("Error");
        }
    }
    
    public void insert(PhongThiDTO phongThiDTO) {
        boolean result =  phongThiDAO.insert(phongThiDTO);
        if(result) {
            this.arr.add(phongThiDTO);
        }        
    }
    
    public ArrayList getAllPhongthi() {
        PhongThiDAO phongThiDAO = new PhongThiDAO();
        ArrayList phongThi = phongThiDAO.getAll();
        return phongThi;
    }

    public String getTrinhdo(String phongThi) {
        String trinhDo = phongThi.substring(0, 2);
        return trinhDo;
    }
    
    public ArrayList getPhongthi(String khoaThi) {
        ArrayList allPhongthi = this.getAllPhongthi();
        ArrayList result = new ArrayList();
        for(int i = 0; i < allPhongthi.size(); i++) {
            PhongThiDTO phongThiDTO = (PhongThiDTO) allPhongthi.get(i);
            if(phongThiDTO.getKhoaThi().equals(khoaThi)) {
                result.add(phongThiDTO);
            }
        }
        return result;
    }

    public String getMaphongthi(String trinhDo, String khoaThi) {
        String maPhongThiMoi = null;

        int maPhongThi = 0;
        for(int i = 0; i < this.arr.size(); i++) {
            PhongThiDTO phongThiDTO = this.arr.get(i);
            if(phongThiDTO.getKhoaThi().equals(khoaThi)) {
                maPhongThi++;
            }                    
        }

        if(maPhongThi < 9) {
            maPhongThi++;
            maPhongThiMoi = trinhDo + "P0" + maPhongThi;
        }
        if(maPhongThi >= 9 && maPhongThi < 99) {
            maPhongThi++;
            maPhongThiMoi = trinhDo + "P" + maPhongThi;
        }
        return maPhongThiMoi;
    }
}

