import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import './Books.css';  // Stil dosyasını import ediyoruz
import logo from "./Utils/download-Photoroom.png";

function Books() {
    const [userData, setUserData] = useState(null);  // Kullanıcı bilgilerini saklayacak state
    const [books, setBooks] = useState([]);  // Kitapları saklayacak state
    const navigate = useNavigate();  // Navigate hook'u ile yönlendirme işlemi

    useEffect(() => {
        const fetchData = async () => {
            try {
                const userResponse = await axios.get('http://localhost:8080/api/kullanici/current');
                setUserData(userResponse.data);

                const booksResponse = await axios.get('http://localhost:8080/api/books/get-all');
                console.log(booksResponse.data);  // Kitapları kontrol edin
                setBooks(booksResponse.data);
            } catch (error) {
                console.error('Veri çekme hatası:', error);
            }
        };

        fetchData();
    }, []);

    const handleLogout = () => {
        // Çıkış işlemi yapılacak
        localStorage.removeItem('token');  // Örnek olarak token'ı kaldırıyoruz
        navigate('/login');  // Giriş sayfasına yönlendiriyoruz
    };

    const addToCart = async (bookId) => {
        try {
            // Kitap sepete ekleniyor, stok sayısı 1 azaltılıyor
            const bookToUpdate = books.find(book => book.id === bookId);
            if (bookToUpdate.stokAdedi > 0) {
                // Stok sayısını 1 azaltıyoruz
                await axios.patch(`http://localhost:8080/api/books/${bookId}/decrease-stock`);

                // Kitaplar listesini tekrar güncelliyoruz
                const updatedBooks = books.map(book =>
                    book.id === bookId ? { ...book, stokAdedi: book.stokAdedi - 1 } : book
                );
                setBooks(updatedBooks);
                alert('Kitap sepete eklendi');
            } else {
                alert('Stokta bu kitap kalmadı');
            }
        } catch (error) {
            console.error('Kitap sepete eklenirken hata oluştu:', error);
        }
    };

    return (
        <div className="books-container">
            <header className="header-bar">
                <div className="logo-container">
                    <img src={logo} alt="Logo" className="logo"/>
                </div>
                <nav className="nav-buttons">
                    <Link to="/books" className="nav-button">Kitaplar</Link>
                    <Link to="/add-book" className="nav-button">Kitap Ekle</Link>
                    <Link to="/cart" className="nav-button">Sepetim</Link>
                </nav>
                <div className="user-info">
                    {userData && (
                        <div className="user-details">
                            <span>{userData.kullaniciAdi}</span>
                            <span>{userData.bakiye}₺</span>
                        </div>
                    )}
                    <button onClick={handleLogout} className="logout-btn">Çıkış</button>
                </div>
            </header>

            <div className="books-list">
                <h2>Kitaplar</h2>
                <div className="books-grid">
                    {books.length > 0 ? (
                        books.map((book) => (
                            <div key={book.id} className="book-item">
                                <div className="book-img-container">
                                    <img src={book.resimUrl} alt={book.kitapAdi} className="book-image"/>
                                </div>
                                <div className="book-details">
                                    <h3>{book.kitapAdi}</h3>
                                    <p>Yazar: {book.yazarAdi}</p>
                                    <p>Fiyat: {book.fiyat}₺</p>
                                    <button onClick={() => addToCart(book.id)} className="add-to-cart-btn">Sepete Ekle
                                    </button>
                                </div>
                            </div>
                        ))
                    ) : (
                        <p>Kitaplar yükleniyor...</p>
                    )}
                </div>
            </div>

        </div>
    );
}

export default Books;
