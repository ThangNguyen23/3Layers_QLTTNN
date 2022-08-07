package BUS;

import DTO.*;
import DAO.*;
import java.util.ArrayList;

public class DiemThiBUS {
    public DiemThiDAO diemThiDAO;
    public ArrayList<DiemThiDTO> arr;

    public DiemThiBUS() {
        this.diemThiDAO = new DiemThiDAO();
        this.arr = diemThiDAO.getAll();
    }

    public void insert(DiemThiDTO diemThiDTO) {
        diemThiDAO.insert(diemThiDTO);
        this.arr.add(diemThiDTO);
    }
    
    public ArrayList getDiemthiFromPhongthi(String phongThi, String khoaThi) {
        ArrayList result = new ArrayList();

        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        ArrayList thiSinh = thiSinhBUS.getThisinh(phongThi, khoaThi);
        for(int i = 0; i < thiSinh.size(); i++) {
            int flag = 0;
            ThiSinhDTO thiSinhDTO = (ThiSinhDTO) thiSinh.get(i);
            for(int j = 0; j < this.arr.size(); j++) {
                DiemThiDTO diemThiDTO = this.arr.get(j);
                if(diemThiDTO.getSbd().equals(thiSinhDTO.getSbd()) && diemThiDTO.getKhoaThi().equals(thiSinhDTO.getKhoaThi())) {
                    flag = 1;
                    result.add(diemThiDTO);
                    break;
                }                
            }

            if(flag == 0) {
                DiemThiDTO diemThiDTO1 = new DiemThiDTO(thiSinhDTO.getSbd(), thiSinhDTO.getKhoaThi(), 0, 0, 0, 0);
                result.add(diemThiDTO1);
            }
        }
        return result;
    }
}
