package marmara.booksell.Controller;

import marmara.booksell.Entity.Yazar;
import marmara.booksell.Service.YazarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yazar")
public class YazarController {

    @Autowired
    private YazarService yazarService;

    // Yazar ekleme
    @PostMapping("/ekle")
    public Yazar addYazar(@RequestBody Yazar yazar) {
        return yazarService.saveYazar(yazar);
    }

    // Tüm yazarları getirme
    @GetMapping("/tumu")
    public List<Yazar> getAllYazarlar() {
        return yazarService.getAllYazarlar();
    }

    // Yazar ID ile getirme
    @GetMapping("/{id}")
    public Yazar getYazarById(@PathVariable Long id) {
        return yazarService.getYazarById(id);
    }
}
