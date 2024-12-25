package marmara.booksell.Service;

import marmara.booksell.Entity.Yazar;
import marmara.booksell.Repository.YazarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YazarService {

    @Autowired
    private YazarRepository yazarRepository;

    public Yazar saveYazar(Yazar yazar) {
        return yazarRepository.save(yazar);
    }

    public List<Yazar> getAllYazarlar() {
        return yazarRepository.findAll();
    }

    public Yazar getYazarById(Long id) {
        return yazarRepository.findById(id).orElse(null);
    }
}
