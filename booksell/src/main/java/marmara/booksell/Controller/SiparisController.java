package marmara.booksell.Controller;

import marmara.booksell.Entity.Siparis;
import marmara.booksell.Service.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siparis")
public class SiparisController {

    @Autowired
    private SiparisService siparisService;

    @PostMapping("/ver")
    public Siparis createSiparis(@RequestBody Siparis siparis) {
        return siparisService.saveSiparis(siparis);
    }

    @GetMapping("/all")
    public List<Siparis> getAllSiparisler() {
        return siparisService.getAllSiparisler();
    }
}
