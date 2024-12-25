package marmara.booksell.Controller;

import marmara.booksell.Entity.Kullanici;
import marmara.booksell.Service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kullanici")
public class KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;

    @PostMapping("/kayit")
    public Kullanici register(@RequestBody Kullanici kullanici) {
        return kullaniciService.saveKullanici(kullanici);
    }

    // Giriş işlemi
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Kullanici kullanici) {
        Kullanici authenticatedUser = kullaniciService.authenticate(kullanici);

        if (authenticatedUser != null) {
            return ResponseEntity.ok("Giriş başarılı");
        } else {
            return ResponseEntity.status(401).body("Geçersiz kullanıcı adı veya şifre");
        }
    }
}
