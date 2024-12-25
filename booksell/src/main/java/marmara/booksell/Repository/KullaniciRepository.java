package marmara.booksell.Repository;

import marmara.booksell.Entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
    Kullanici findByKullaniciAdi(String kullaniciAdi); // Kullanıcıyı kullanıcı adı ile bulma
    Kullanici findByEmail(String email); // Email ile kullanıcıyı bulma
}
