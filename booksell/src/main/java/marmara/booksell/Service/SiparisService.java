package marmara.booksell.Service;

import marmara.booksell.Entity.Siparis;
import marmara.booksell.Repository.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiparisService {

    @Autowired
    private SiparisRepository siparisRepository;

    public Siparis saveSiparis(Siparis siparis) {
        return siparisRepository.save(siparis);
    }

    public List<Siparis> getAllSiparisler() {
        return siparisRepository.findAll();
    }
}
