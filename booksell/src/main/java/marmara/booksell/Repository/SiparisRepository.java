package marmara.booksell.Repository;

import marmara.booksell.Entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiparisRepository extends JpaRepository<Siparis, Long> {
    // Siparişle ilgili özel sorgular eklenebilir.
}
