package online_book_sales;

/**
 * @author Ömer Faruk Akçay
 */
public class Siparis_SiparisDetay_Kitap_Yazar {
    private int SiparisID;
    private int KullaniciID;
    private int ToplamUrunAdedi;
    private float ToplamTutar;
    private String SiparisTarihi;
    private int Completed;
    private int DetayID;
    private int KitapID;
    private int Adet;
    private float Fiyat;
    private float ToplamFiyat;
    private String YayıneviAdi ;
    private String KitapAdi ;
    private String Tur ;
    private int SayfaSayisi;
    private int StokAdedi ;
    private String YazarAdi;
    private String YazarSoyadi;
    private int StaiciID;

    public Siparis_SiparisDetay_Kitap_Yazar(int SiparisID, int KullaniciID, int ToplamUrunAdedi, float ToplamTutar, String SiparisTarihi, int Completed, int DetayID, int KitapID, int Adet, float Fiyat, float ToplamFiyat, String YayıneviAdi, String KitapAdi, String Tur, int SayfaSayisi, int StokAdedi, String YazarAdi, String YazarSoyadi, int StaiciID) {
        this.SiparisID = SiparisID;
        this.KullaniciID = KullaniciID;
        this.ToplamUrunAdedi = ToplamUrunAdedi;
        this.ToplamTutar = ToplamTutar;
        this.SiparisTarihi = SiparisTarihi;
        this.Completed = Completed;
        this.DetayID = DetayID;
        this.KitapID = KitapID;
        this.Adet = Adet;
        this.Fiyat = Fiyat;
        this.ToplamFiyat = ToplamFiyat;
        this.YayıneviAdi = YayıneviAdi;
        this.KitapAdi = KitapAdi;
        this.Tur = Tur;
        this.SayfaSayisi = SayfaSayisi;
        this.StokAdedi = StokAdedi;
        this.YazarAdi = YazarAdi;
        this.YazarSoyadi = YazarSoyadi;
        this.StaiciID = StaiciID;
    }

    public int getSiparisID() {
        return SiparisID;
    }

    public void setSiparisID(int SiparisID) {
        this.SiparisID = SiparisID;
    }

    public int getKullaniciID() {
        return KullaniciID;
    }

    public void setKullaniciID(int KullaniciID) {
        this.KullaniciID = KullaniciID;
    }

    public int getToplamUrunAdedi() {
        return ToplamUrunAdedi;
    }

    public void setToplamUrunAdedi(int ToplamUrunAdedi) {
        this.ToplamUrunAdedi = ToplamUrunAdedi;
    }

    public float getToplamTutar() {
        return ToplamTutar;
    }

    public void setToplamTutar(float ToplamTutar) {
        this.ToplamTutar = ToplamTutar;
    }

    public String getSiparisTarihi() {
        return SiparisTarihi;
    }

    public void setSiparisTarihi(String SiparisTarihi) {
        this.SiparisTarihi = SiparisTarihi;
    }

    public int getCompleted() {
        return Completed;
    }

    public void setCompleted(int Completed) {
        this.Completed = Completed;
    }

    public int getDetayID() {
        return DetayID;
    }

    public void setDetayID(int DetayID) {
        this.DetayID = DetayID;
    }

    public int getKitapID() {
        return KitapID;
    }

    public void setKitapID(int KitapID) {
        this.KitapID = KitapID;
    }

    public int getAdet() {
        return Adet;
    }

    public void setAdet(int Adet) {
        this.Adet = Adet;
    }

    public float getFiyat() {
        return Fiyat;
    }

    public void setFiyat(float Fiyat) {
        this.Fiyat = Fiyat;
    }

    public float getToplamFiyat() {
        return ToplamFiyat;
    }

    public void setToplamFiyat(float ToplamFiyat) {
        this.ToplamFiyat = ToplamFiyat;
    }

    public String getYayıneviAdi() {
        return YayıneviAdi;
    }

    public void setYayıneviAdi(String YayıneviAdi) {
        this.YayıneviAdi = YayıneviAdi;
    }

    public String getKitapAdi() {
        return KitapAdi;
    }

    public void setKitapAdi(String KitapAdi) {
        this.KitapAdi = KitapAdi;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    public int getSayfaSayisi() {
        return SayfaSayisi;
    }

    public void setSayfaSayisi(int SayfaSayisi) {
        this.SayfaSayisi = SayfaSayisi;
    }

    public int getStokAdedi() {
        return StokAdedi;
    }

    public void setStokAdedi(int StokAdedi) {
        this.StokAdedi = StokAdedi;
    }

    public String getYazarAdi() {
        return YazarAdi;
    }

    public void setYazarAdi(String YazarAdi) {
        this.YazarAdi = YazarAdi;
    }

    public String getYazarSoyadi() {
        return YazarSoyadi;
    }

    public void setYazarSoyadi(String YazarSoyadi) {
        this.YazarSoyadi = YazarSoyadi;
    }

    public int getStaiciID() {
        return StaiciID;
    }

    public void setStaiciID(int StaiciID) {
        this.StaiciID = StaiciID;
    }
    
    
    
}
