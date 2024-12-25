package marmara.booksell.Service;

import marmara.booksell.Entity.Kullanici;
import marmara.booksell.Repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    public Kullanici authenticate(Kullanici kullanici) {
        Kullanici foundUser = kullaniciRepository.findByKullaniciAdi(kullanici.getKullaniciAdi());

        if (foundUser != null && foundUser.getSifre().equals(kullanici.getSifre())) {
            return foundUser;
        }
        return null;
    }


    // Kullanıcı kaydetme işlemi
    public Kullanici saveKullanici(Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }
}
