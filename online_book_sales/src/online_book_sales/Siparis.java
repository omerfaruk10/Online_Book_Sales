package online_book_sales;

/**
 * @author Ömer Faruk Akçay
 */
public class Siparis {
    private int SiparisID;
    private int KullaniciID;
    private int ToplamUrunAdedi;
    private float TopolamTutar;
    private String SiparisTarihi;
    private int Completed;

    public Siparis(int SiparisID, int KullaniciID, int ToplamUrunAdedi, float TopolamTutar, String SiparisTarihi, int Completed) {
        this.SiparisID = SiparisID;
        this.KullaniciID = KullaniciID;
        this.ToplamUrunAdedi = ToplamUrunAdedi;
        this.TopolamTutar = TopolamTutar;
        this.SiparisTarihi = SiparisTarihi;
        this.Completed = Completed;
    }
    
    
    public int getToplamUrunAdedi() {
        return ToplamUrunAdedi;
    }

    public void setToplamUrunAdedi(int ToplamUrunAdedi) {
        this.ToplamUrunAdedi = ToplamUrunAdedi;
    }

    public float getTopolamTutar() {
        return TopolamTutar;
    }

    public void setTopolamTutar(float TopolamTutar) {
        this.TopolamTutar = TopolamTutar;
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
    
    
}
