package DTO;

public class KhoaThiDTO {
    public String khoaThi;
    public String ngayThi;

    public KhoaThiDTO() {}

    public KhoaThiDTO(String khoaThi, String ngayThi) {
        this.khoaThi = khoaThi;
        this.ngayThi = ngayThi;
    }

    public String getKhoaThi() {
        return khoaThi;
    }

    public void setKhoaThi(String khoaThi) {
        this.khoaThi = khoaThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }
}
