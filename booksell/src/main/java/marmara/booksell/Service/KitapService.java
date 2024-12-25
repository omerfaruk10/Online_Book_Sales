package marmara.booksell.Service;

import marmara.booksell.Entity.Kitap;
import marmara.booksell.Repository.KitapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitapService {

    @Autowired
    private KitapRepository kitapRepository;

    // Kitap ekleme
    public Kitap saveKitap(Kitap kitap) {
        return kitapRepository.save(kitap);
    }

    // Kitap adı ile arama
    public Kitap getKitapByKitapAdi(String kitapAdi) {
        return kitapRepository.findByKitapAdi(kitapAdi);
    }

    // Tüm kitapları listeleme
    public List<Kitap> getAllKitaplar() {
        return kitapRepository.findAll();
    }

    // Kitap ID ile arama
    public Kitap getKitapById(Long kitapID) {
        Optional<Kitap> kitap = kitapRepository.findById(kitapID);
        return kitap.orElse(null); // Eğer kitap bulunamazsa null döndür
    }


}
