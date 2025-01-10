package online_book_sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * @author Omer Faruk
 */
public class List {
    public ArrayList<User> getKullanicilar() throws SQLException { // Kullanıcıların bilgileri
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>(); 
        
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kullanıcılar");
            
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("Ad"),
                        resultSet.getString("Soyad"),
                        resultSet.getString("DogumTarihi"),
                        resultSet.getString("Cinsiyet"),
                        resultSet.getFloat("Bakiye"),
                        resultSet.getString("KullanıcıAdı"),
                        resultSet.getString("Sifre"),
                        resultSet.getString("TelefonNumarası"),
                        resultSet.getString("Email")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close(); 
            if (connection != null) connection.close(); 
        }
        return users;
    }
    
    public ArrayList<Kitap> getKitaplar() throws SQLException{  // Kitapların bilgileri
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Kitap> kitaplar = null;
        
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT YayıneviAdı, KitapAdı, Tür, SayfaSayısı, StokAdedi, Fiyat, YazarAdı, "
                    + "YazarSoyadı, SaticiID FROM kitap.kitaplar as k JOIN kitap.yazarlar as y ON k.YazarID = y.YazarID");
            kitaplar = new ArrayList<>();
            while (resultSet.next()) {
                kitaplar.add(new Kitap(
                        resultSet.getString("YayıneviAdı"),
                        resultSet.getString("KitapAdı"),
                        resultSet.getString("Tür"),
                        resultSet.getInt("SayfaSayısı"),
                        resultSet.getInt("StokAdedi"),
                        resultSet.getFloat("Fiyat"),
                        resultSet.getString("YazarAdı"),
                        resultSet.getString("YazarSoyadı"),
                        resultSet.getInt("SaticiID")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return kitaplar;
    }
    
    public ArrayList<Kitap> getKitaplar(int kitapID) throws SQLException {  // ID'ye baglın kitabın bilgileri
    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ArrayList<Kitap> kitaplar = new ArrayList<>();

    try {
        connection = dbHelper.getConnection();

        String sql = "SELECT YayıneviAdı, KitapAdı, Tür, SayfaSayısı, StokAdedi, Fiyat, YazarAdı, "
                   + "YazarSoyadı, SaticiID "
                   + "FROM kitap.kitaplar AS k "
                   + "JOIN kitap.yazarlar AS y ON k.YazarID = y.YazarID "
                   + "WHERE KitapID = ?";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, kitapID);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            kitaplar.add(new Kitap(
                resultSet.getString("YayıneviAdı"),
                resultSet.getString("KitapAdı"),
                resultSet.getString("Tür"),
                resultSet.getInt("SayfaSayısı"),
                resultSet.getInt("StokAdedi"),
                resultSet.getFloat("Fiyat"),
                resultSet.getString("YazarAdı"),
                resultSet.getString("YazarSoyadı"),
                resultSet.getInt("SaticiID")
            ));
        }
    } catch (SQLException exception) {
        dbHelper.showErrorMessage(exception);
    } finally {
        if (resultSet != null) resultSet.close();
        if (preparedStatement != null) preparedStatement.close();
        if (connection != null) connection.close();
    }
    return kitaplar;
}

    
    public ArrayList<Siparis> getSiparisler() throws SQLException{  // Siparis bilgileri
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Siparis> siparisler = new ArrayList<>();

        try {
            connection = dbHelper.getConnection();
            String sql = "SELECT * FROM kitap.siparisler";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                siparisler.add(new Siparis(
                        resultSet.getInt("SiparisID"),
                        resultSet.getInt("KullanıcıID"),
                        resultSet.getInt("ToplamUrunAdedi"),
                        resultSet.getInt("TopolamTutar"),
                        resultSet.getString("SiparisTarihi"),
                        resultSet.getInt("Completed")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return siparisler;
    }
    
    public ArrayList<SiparisDetay> getDetaylar() throws SQLException{  // Siparis Detay bilgileri
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<SiparisDetay> detaylar = new ArrayList<>();

        try {
            connection = dbHelper.getConnection();
            String sql = "SELECT * from kitaplar.SiparisDetay";
            
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                detaylar.add(new SiparisDetay(
                        resultSet.getInt("DetayID"),
                        resultSet.getInt("SiparisID"),
                        resultSet.getInt("KitapID"),
                        resultSet.getInt("Adet"),
                        resultSet.getFloat("Fiyat")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return detaylar;
    }
    
    public ArrayList<Siparis_SiparisDetay_Kitap_Yazar> getSiparis_SiparisDetay_Kitap_Yazar(int kullaniciID) throws SQLException{ // Siparis - Detay - Kitap - Yazar tablolarının birlestirilmesi
        ArrayList<Siparis_SiparisDetay_Kitap_Yazar> detaylar = new ArrayList<>();
        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        PreparedStatement preparedStatement  = null;
        ResultSet resultSet = null;

        try {
            connection = dbHelper.getConnection();

            String query = "SELECT s.SiparisID, s.KullanıcıID, s.ToplamUrunAdedi, s.ToplamTutar, s.SiparisTarihi, s.Completed, "
                    + "sd.DetayID, sd.KitapID, sd.Adet, sd.Fiyat, sd.ToplamFiyat, k.YayıneviAdı, k.KitapAdı, k.Tür, "
                    + "k.SayfaSayısı, k.StokAdedi, y.YazarAdı, y.YazarSoyadı, k.SaticiID FROM kitap.siparisler s "
                    + "JOIN kitap.siparisdetay sd ON s.SiparisID = sd.SiparisID "
                    + "JOIN kitap.kitaplar k ON sd.KitapID = k.KitapID "
                    + "JOIN kitap.yazarlar y ON k.YazarID = y.YazarID";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                detaylar.add(new Siparis_SiparisDetay_Kitap_Yazar(
                        resultSet.getInt("SiparisID"),
                        resultSet.getInt("KullanıcıID"),
                        resultSet.getInt("ToplamUrunAdedi"),
                        resultSet.getFloat("ToplamTutar"),
                        resultSet.getString("SiparisTarihi"),
                        resultSet.getInt("Completed"),
                        resultSet.getInt("DetayID"),
                        resultSet.getInt("KitapID"),
                        resultSet.getInt("Adet"),
                        resultSet.getFloat("Fiyat"),
                        resultSet.getFloat("ToplamFiyat"),
                        resultSet.getString("YayıneviAdı"),
                        resultSet.getString("KitapAdı"),
                        resultSet.getString("Tür"),
                        resultSet.getInt("SayfaSayısı"),
                        resultSet.getInt("StokAdedi"),
                        resultSet.getString("YazarAdı"),
                        resultSet.getString("YazarSoyadı"),
                        resultSet.getInt("SaticiID")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

        return detaylar;
    }
    
     public ArrayList<User> getKullaniciBilgilerini(int kullaniciID) {  // Belirli bir kullanıcının bilgileri
        ArrayList<User> kullaniciListesi = new ArrayList<>();
        DbHelper dbHelper = new DbHelper();
        String query = "SELECT * FROM kitap.kullanıcılar WHERE KullanıcıID = ?";
        
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, kullaniciID);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String ad = resultSet.getString("Ad");
                    String soyad = resultSet.getString("Soyad");
                    String dogum = resultSet.getString("DogumTarihi");
                    String cinsiyet = resultSet.getString("Cinsiyet");
                    float bakiye = resultSet.getFloat("Bakiye");
                    String kullaniciAdi = resultSet.getString("KullanıcıAdı");
                    String sifre = resultSet.getString("Sifre");
                    String telNo = resultSet.getString("TelefonNumarası");
                    String email = resultSet.getString("Email");
                    int id = resultSet.getInt("kullaniciID");

                    User user = new User(ad, soyad, dogum, cinsiyet, bakiye, kullaniciAdi, sifre, telNo, email);
                    kullaniciListesi.add(user);
                }
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
            exception.printStackTrace();
        }
        
        return kullaniciListesi;
    }
    
     
     public ArrayList<Siparis_SiparisDetay_Kitap_Yazar> getUrunlar(int SiparisID) throws SQLException { // Bir siparis ID'yr sahip ürünlerin bilgileri
        ArrayList<Siparis_SiparisDetay_Kitap_Yazar> detaylar = new ArrayList<>();
        DbHelper dbHelper = new DbHelper();
        String query = "SELECT s.SiparisID, s.KullanıcıID, s.ToplamUrunAdedi, s.ToplamTutar, s.SiparisTarihi, s.Completed, "
                     + "sd.DetayID, sd.KitapID, sd.Adet, sd.Fiyat, sd.ToplamFiyat, k.YayıneviAdı, k.KitapAdı, k.Tür, "
                     + "k.SayfaSayısı, k.StokAdedi, y.YazarAdı, y.YazarSoyadı, k.SaticiID FROM kitap.siparisler s "
                     + "JOIN kitap.siparisdetay sd ON s.SiparisID = sd.SiparisID "
                     + "JOIN kitap.kitaplar k ON sd.KitapID = k.KitapID "
                     + "JOIN kitap.yazarlar y ON k.YazarID = y.YazarID WHERE sd.SiparisID = ?";

        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, SiparisID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int siparisID = resultSet.getInt("SiparisID");
                    int kullaniciID = resultSet.getInt("KullanıcıID");
                    int toplamUrunAdedi = resultSet.getInt("ToplamUrunAdedi");
                    float toplamTutar = resultSet.getFloat("ToplamTutar");
                    String siparisTarihi = resultSet.getString("SiparisTarihi");
                    int completed = resultSet.getInt("Completed");
                    int detayID = resultSet.getInt("DetayID");
                    int kitapID = resultSet.getInt("KitapID");
                    int adet = resultSet.getInt("Adet");
                    float fiyat = resultSet.getFloat("Fiyat");
                    float toplamFiyat = resultSet.getFloat("ToplamFiyat");
                    String yayineviAdi = resultSet.getString("YayıneviAdı");
                    String kitapAdi = resultSet.getString("KitapAdı");
                    String tur = resultSet.getString("Tür");
                    int sayfaSayisi = resultSet.getInt("SayfaSayısı");
                    int stokAdedi = resultSet.getInt("StokAdedi");
                    String yazarAdi = resultSet.getString("YazarAdı");
                    String yazarSoyadi = resultSet.getString("YazarSoyadı");
                    int saticiID = resultSet.getInt("SaticiID");

                    Siparis_SiparisDetay_Kitap_Yazar detay = new Siparis_SiparisDetay_Kitap_Yazar(
                        siparisID, kullaniciID, toplamUrunAdedi, toplamTutar, siparisTarihi, completed, detayID,
                        kitapID, adet, fiyat, toplamFiyat, yayineviAdi, kitapAdi, tur, sayfaSayisi, stokAdedi,
                        yazarAdi, yazarSoyadi, saticiID
                    );
                    detaylar.add(detay);
                }
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
            exception.printStackTrace();
        }
        return detaylar;
    }

}