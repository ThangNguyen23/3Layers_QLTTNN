package DTO;

public class DiemThiDTO {
    public float nghe;
    public float noi;
    public float doc;
    public float viet;

    public String sbd;
    public String khoaThi;

    public DiemThiDTO() {}


    public DiemThiDTO(String sbd, String khoaThi, float nghe, float noi, float doc, float viet) {
        this.sbd = sbd;
        this.khoaThi = khoaThi;
        this.nghe = nghe;
        this.noi = noi;
        this.doc = doc;
        this.viet = viet;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getKhoaThi() {
        return khoaThi;
    }

    public void setKhoaThi(String khoaThi) {
        this.khoaThi = khoaThi;
    }

    public float getNghe() {
        return nghe;
    }

    public void setNghe(float nghe) {
        this.nghe = nghe;
    }

    public float getNoi() {
        return noi;
    }

    public void setNoi(float noi) {
        this.noi = noi;
    }

    public float getDoc() {
        return doc;
    }

    public void setDoc(float doc) {
        this.doc = doc;
    }

    public float getViet() {
        return viet;
    }

    public void setViet(float viet) {
        this.viet = viet;
    }
}
