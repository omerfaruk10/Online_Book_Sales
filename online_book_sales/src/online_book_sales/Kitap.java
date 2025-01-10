package online_book_sales;

/**
 * @author Omer Faruk
 */
public class Kitap {
    private String YayineviAdi;
    private String KitapAdi;
    private String Tur;
    private int SayfaSayisi;
    private int StokAdedi;
    private float Fiyat;
    private String YazarAdi;
    private String YazarSoyadi;
    private int SaticiID;

    public Kitap(String YayineviAdi, String KitapAdi, String Tur, int SayfaSayisi, int StokAdedi, float Fiyat, String YazarAdi, String YazarSoyadi, int SaticiID) {
        this.YayineviAdi = YayineviAdi;
        this.KitapAdi = KitapAdi;
        this.Tur = Tur;
        this.SayfaSayisi = SayfaSayisi;
        this.StokAdedi = StokAdedi;
        this.Fiyat = Fiyat;
        this.YazarAdi = YazarAdi;
        this.YazarSoyadi = YazarSoyadi;
        this.SaticiID = SaticiID;
    }

    public int getSaticiID() {
        return SaticiID;
    }

    public void setSaticiID(int SaticiID) {
        this.SaticiID = SaticiID;
    }

    public String getYayineviAdi() {
        return YayineviAdi;
    }

    public void setYayineviAdi(String YayineviAdi) {
        this.YayineviAdi = YayineviAdi;
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

    public float getFiyat() {
        return Fiyat;
    }

    public void setFiyat(float Fiyat) {
        this.Fiyat = Fiyat;
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
    
    
}
