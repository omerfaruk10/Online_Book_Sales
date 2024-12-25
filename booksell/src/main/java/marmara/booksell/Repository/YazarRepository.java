package marmara.booksell.Repository;

import marmara.booksell.Entity.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YazarRepository extends JpaRepository<Yazar, Long> {
    // Burada özel sorgular eklenebilir
}
