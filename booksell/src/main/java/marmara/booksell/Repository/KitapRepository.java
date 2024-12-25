package marmara.booksell.Repository;

import marmara.booksell.Entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitapRepository extends JpaRepository<Kitap, Long> {
    // Kitap adı ile arama
    Kitap findByKitapAdi(String kitapAdi);


}
