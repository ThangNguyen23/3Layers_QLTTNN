package BUS;

import DTO.*;
import DAO.*;

import java.util.ArrayList;

public class KhoaThiBUS {
    public KhoaThiDAO khoaThiDAO;
    public ArrayList<KhoaThiDTO> arr;

    public KhoaThiBUS() {
        khoaThiDAO = new KhoaThiDAO();
        this.arr = khoaThiDAO.getAll();
        if(this.arr.isEmpty()) {
            System.out.println("Error");
        }
    }

    public void insert(KhoaThiDTO khoaThiDTO) {
        boolean result =  khoaThiDAO.insert(khoaThiDTO);
        if(result) {
            this.arr.add(khoaThiDTO);
        }
    }

    public String getTrinhdo(String phongThi) {
        PhongThiBUS phongThiBUS = new PhongThiBUS();
        return phongThiBUS.getTrinhdo(phongThi);
    }

    public ArrayList getPhongthi(String khoaThi) {
        PhongThiBUS phongThiBUS = new PhongThiBUS();
        return phongThiBUS.getPhongthi(khoaThi);
    }

    public ArrayList timKhoathi(String khoaThi) {
        ArrayList result = new ArrayList();
        for(int i = 0; i < this.arr.size(); i++) {
            KhoaThiDTO khoaThiDTO = this.arr.get(i);
            if(khoaThiDTO.getKhoaThi().equalsIgnoreCase(khoaThi)) {
                result.add(khoaThiDTO);
            }
        }
        return result;
    }

    public String getMakhoathi() {
        String khoaThiMoi = null;
        KhoaThiDTO khoaThiDTO = this.arr.get(this.arr.size() - 1);
        String khoaThi  = khoaThiDTO.getKhoaThi();
        String result   = khoaThi.substring(4, khoaThi.length());
        int numberOfResult = Integer.parseInt(result);
        numberOfResult++;
        if(numberOfResult < 10) {
            khoaThiMoi = "Khoa00" + numberOfResult;
        }
        else if(numberOfResult < 100) {
            khoaThiMoi = "Khoa0" + numberOfResult;
        }
        else if(numberOfResult >= 100) {
            khoaThiMoi = "Khoa" + numberOfResult;
        }
        return khoaThiMoi;
    }
}

