package DTO;

public class PhongThiDTO {
    public String phongThi;
    public String khoaThi;

    public PhongThiDTO() {
    }

    public PhongThiDTO(String phongThi, String khoaThi) {
        this.phongThi = phongThi;
        this.khoaThi = khoaThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

    public String getKhoaThi() {
        return khoaThi;
    }

    public void setKhoaThi(String khoaThi) {
        this.khoaThi = khoaThi;
    }
}
