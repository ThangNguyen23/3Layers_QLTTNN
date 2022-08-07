package DTO;

public class ThiSinhDTO {
    public String sbd;
    public String phongThi;
    public String khoaThi;

    public String ho;
    public String ten;
    public String gioiTinh;
    public String ngaySinh;
    public String noiSinh;
    public String cmnd;
    public String ngayCap;
    public String noiCap;
    public String sdt;
    public String email;
    
    public ThiSinhDTO() {
        this.sbd = null;
        this.ho = null;
        this.ten = null;
        this.gioiTinh = null;
        this.ngaySinh = null;
        this.noiSinh = null;
        this.cmnd = null;
        this.ngayCap = null;
        this.noiCap = null;
        this.sdt = null;
        this.email = null;
        this.phongThi = null;
        this.khoaThi = null;
    }

    public ThiSinhDTO(String sbd, String ho, String ten , String gioiTinh, String ngaySinh, String noiSinh, String cmnd, String ngayCap, String noiCap, String sdt, String email, String phongThi, String khoaThi) {
        this.sbd = sbd;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.cmnd = cmnd;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.sdt = sdt;
        this.email = email;
        this.phongThi = phongThi;
        this.khoaThi = khoaThi;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
