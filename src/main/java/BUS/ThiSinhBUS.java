package BUS;

import DTO.*;
import DAO.*;
import java.util.ArrayList;

public class ThiSinhBUS {
    private ThiSinhDAO thiSinhDAO;
    public ArrayList<ThiSinhDTO> arr;
    
    public ThiSinhBUS() {
        thiSinhDAO = new ThiSinhDAO();
        this.arr = thiSinhDAO.getAll();
        if(this.arr.isEmpty()) {
            System.out.println("Error");
        }
    }
    
    public ArrayList getThisinh(String phongThi, String khoaThi) {
        ArrayList result = new ArrayList();
        for(int i = 0; i < this.arr.size(); i++) {
            ThiSinhDTO thiSinhDTO = this.arr.get(i);
            if(thiSinhDTO.getPhongThi().equals(phongThi) && thiSinhDTO.getKhoaThi().equals(khoaThi)) {
                result.add(thiSinhDTO);
            }
        }
        return result;
    }
    
    public void insert(ThiSinhDTO thiSinhDTO) {
        boolean result =  thiSinhDAO.insert(thiSinhDTO);
        if(result) {
            this.arr.add(thiSinhDTO);
        }        
    }

    public ArrayList insertAndCreateSbd(ThiSinhDTO thiSinhDTO, String trinhDo, String khoaThi) {
        int count = thiSinhDAO.countSbd(trinhDo, khoaThi);
        if(trinhDo.equals("A2")) {
            if(count < 9) {
                thiSinhDTO.setSbd("A200" + (count + 1));
            }
            else if(count < 99) {
                thiSinhDTO.setSbd("A20" + (count + 1));
            }
            else if(count >= 99) {
                thiSinhDTO.setSbd("A2" + (count + 1));
            }
        }
        else {
            if(count < 9) {
                thiSinhDTO.setSbd("B100" + (count + 1));
            }
            else if(count < 99) {
                thiSinhDTO.setSbd("B10" + (count + 1));
            }
            else if(count >= 99) {
                thiSinhDTO.setSbd("B1" + (count + 1));
            }
        }
        this.insert(thiSinhDTO);
        return this.arr;
    }

    public String getPhongthi(String khoaThi, String trinhDo) {
        ArrayList temp = thiSinhDAO.getPhongthiChoThisinh(khoaThi, trinhDo);
        if(temp.isEmpty()) {
            temp = thiSinhDAO.getPhongthiMoiTao(khoaThi, trinhDo);
        }
        return String.valueOf(temp.get(0));
    }
    
    public String[] getKhoathi(){
        return thiSinhDAO.getKhoathi();
    }


    public ArrayList timTheoDieuKien(int index, String info) {
        ArrayList<ThiSinhDTO> result = new ArrayList();
        switch(index) {
            case 0:
            {
                for(int i = 0; i < this.arr.size(); i++) {
                    ThiSinhDTO thiSinhDTO = this.arr.get(i);
                    if(thiSinhDTO.getSbd().equals(info)) {
                        result.add(thiSinhDTO);
                    }
                }
                break;
            }
            case 1:
            {
                for(int i = 0; i < this.arr.size(); i++) {
                    ThiSinhDTO thiSinhDTO = this.arr.get(i);
                    if(thiSinhDTO.getTen().equalsIgnoreCase(info)) {
                        result.add(thiSinhDTO);
                    }
                }
                break;
            }
            case 2:
            {
                for(int i = 0; i < this.arr.size(); i++) {
                    ThiSinhDTO thiSinhDTO = this.arr.get(i);
                    if(thiSinhDTO.getCmnd().equals(info)) {
                        result.add(thiSinhDTO);
                    }
                }
                break;
            }
            case 3:
            {
                for(int i = 0; i < this.arr.size(); i++) {
                    ThiSinhDTO thiSinhDTO = this.arr.get(i);
                    if(thiSinhDTO.getPhongThi().equals(info)) {
                        result.add(thiSinhDTO);
                    }
                }
                break;
            }
            case 4:
            {
                for(int i = 0; i < this.arr.size(); i++) {
                    ThiSinhDTO thiSinhDTO = this.arr.get(i);
                    if(thiSinhDTO.getKhoaThi().equals(info)) {
                        result.add(thiSinhDTO);
                    }
                }
                break;
            }
            case 5:
            {
                for(int i = 0; i < this.arr.size(); i++) {
                    ThiSinhDTO thiSinhDTO = this.arr.get(i);
                    if(thiSinhDTO.getSdt().equals(info)) {
                        result.add(thiSinhDTO);
                    }
                }
                break;
            }
        }
        return result;
    }

    public int countThisinhInPhongthi(String phongThi, String khoaThi) {
        int result = 0;
        for(int i = 0; i < this.arr.size(); i ++) {
            ThiSinhDTO thiSinhDTO = this.arr.get(i);
            if(thiSinhDTO.getPhongThi().equals(phongThi) && thiSinhDTO.getKhoaThi().equals(khoaThi)) {
                result++;
            }
        }
        return result;
    }

    public String getPhongthiNew(String khoaThi, String trinhDo) {
        ArrayList<String> allThisinh = new ArrayList();
        ArrayList<String> thisinhInTable = new ArrayList();
        PhongThiDAO phongthiDAO = new PhongThiDAO();

        allThisinh = thiSinhDAO.getPhongthiPhuhopChoThisinh(khoaThi, trinhDo," having count(*)<=35");

        if(allThisinh.size() <= 0) {
            allThisinh = phongthiDAO.getPhongthiTrinhdoKhoathi(khoaThi, trinhDo);

//            get all in table thisinh
            thisinhInTable= thiSinhDAO.getPhongthiPhuhopChoThisinh(khoaThi, trinhDo, " ;");
            for (String tungPhong : allThisinh) {
                if(!thisinhInTable.contains(tungPhong))
                    return tungPhong;
            }
        }
        return String.valueOf(allThisinh.get(0));
    }
}

