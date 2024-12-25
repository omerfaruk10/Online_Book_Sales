package marmara.booksell.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siparisler")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siparisID;

    @ManyToOne
    @JoinColumn(name = "kullaniciID", nullable = false)
    private Kullanici kullanici;

    @Column(nullable = false)
    private Integer toplamUrunAdedi;

    @Column(nullable = false)
    private Double toplamFiyat;

    @Column(nullable = false)
    private Date siparisTarihi;

    public Long getSiparisID() {
        return siparisID;
    }

    public void setSiparisID(Long siparisID) {
        this.siparisID = siparisID;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Integer getToplamUrunAdedi() {
        return toplamUrunAdedi;
    }

    public void setToplamUrunAdedi(Integer toplamUrunAdedi) {
        this.toplamUrunAdedi = toplamUrunAdedi;
    }

    public Double getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(Double toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public Date getSiparisTarihi() {
        return siparisTarihi;
    }

    public void setSiparisTarihi(Date siparisTarihi) {
        this.siparisTarihi = siparisTarihi;
    }
}
