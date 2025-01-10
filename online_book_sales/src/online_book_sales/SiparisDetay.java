package online_book_sales;

/**
 * @author Omer Faruk
 */
public class SiparisDetay {
    private int DetayID;
    private int SiparisID;
    private int KitapID;
    private int Adet;
    private float Fiyat;
    private float ToplamFiyat;

    public SiparisDetay(int DetayID, int SiparisID, int KitapID, int Adet, float Fiyat) {
        this.DetayID = DetayID;
        this.SiparisID = SiparisID;
        this.KitapID = KitapID;
        this.Adet = Adet;
        this.Fiyat = Fiyat;
        this.ToplamFiyat = Adet * Fiyat;
    }

    public int getDetayID() {
        return DetayID;
    }

    public void setDetayID(int DetayID) {
        this.DetayID = DetayID;
    }

    public int getSiparisID() {
        return SiparisID;
    }

    public void setSiparisID(int SiparisID) {
        this.SiparisID = SiparisID;
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
    
    
}
