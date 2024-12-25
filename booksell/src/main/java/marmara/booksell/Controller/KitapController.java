package marmara.booksell.Controller;

import marmara.booksell.Entity.Kitap;
import marmara.booksell.Service.KitapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class KitapController {

    @Autowired
    private KitapService kitapService;

    // Kitap ekleme
    @PostMapping("/ekle")
    public Kitap addKitap(@RequestBody Kitap kitap) {
        return kitapService.saveKitap(kitap);
    }

    // Kitap adı ile kitap getirme
    @GetMapping("/get/{kitapAdi}")
    public Kitap getKitap(@PathVariable String kitapAdi) {
        return kitapService.getKitapByKitapAdi(kitapAdi);
    }

    // Kitap ID ile kitap getirme
    @GetMapping("/get/{kitapID}")
    public Kitap getKitapById(@PathVariable Long kitapID) {
        return kitapService.getKitapById(kitapID);
    }

    // Tüm kitapları listeleme
    @GetMapping("/get-all")
    public List<Kitap> getAllKitaplar() {
        return kitapService.getAllKitaplar();
    }

    // Stok azaltma işlemi
    @PatchMapping("/{kitapID}/decrease-stock")
    public Kitap decreaseStock(@PathVariable Long kitapID) {
        Kitap kitap = kitapService.getKitapById(kitapID);
        if (kitap != null && kitap.getStokAdedi() > 0) {
            kitap.setStokAdedi(kitap.getStokAdedi() - 1);
            return kitapService.saveKitap(kitap);  // Güncellenmiş kitap kaydedilir
        } else {
            throw new RuntimeException("Stokta yeterli kitap yok");
        }
    }
}
