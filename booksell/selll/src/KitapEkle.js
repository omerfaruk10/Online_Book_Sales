import React, { useState } from "react";
import axios from "axios";
import "./KitapEkle.css"; // CSS dosyasını import edelim

const KitapEkle = () => {
    const [formData, setFormData] = useState({
        kitapAdi: "",
        fiyat: "",
        sayfaSayisi: "",
        stokAdedi: "",
        tur: "",
        resimUrl: "",
    });

    const [mesaj, setMesaj] = useState("");

    // Form alanı değişikliklerini işleme
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    // Kitap ekleme işlemi
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/books/ekle", formData);
            if (response.status === 200 || response.status === 201) {
                setMesaj("Kitap başarıyla kaydedildi!");
                setFormData({
                    kitapAdi: "",
                    fiyat: "",
                    sayfaSayisi: "",
                    stokAdedi: "",
                    tur: "",
                    resimUrl: "",
                });
            }
        } catch (error) {
            setMesaj("Kitap eklenirken bir hata oluştu: " + error.message);
        }
    };

    return (
        <div className="kitap-ekle-container">
            <h2>Kitap Ekleme</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Kitap Adı:</label>
                    <input
                        type="text"
                        name="kitapAdi"
                        value={formData.kitapAdi}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Fiyat:</label>
                    <input
                        type="number"
                        name="fiyat"
                        value={formData.fiyat}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Sayfa Sayısı:</label>
                    <input
                        type="number"
                        name="sayfaSayisi"
                        value={formData.sayfaSayisi}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Stok Adedi:</label>
                    <input
                        type="number"
                        name="stokAdedi"
                        value={formData.stokAdedi}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Tür:</label>
                    <input
                        type="text"
                        name="tur"
                        value={formData.tur}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Resim URL:</label>
                    <input
                        type="text"
                        name="resimUrl"
                        value={formData.resimUrl}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit">Kaydet</button>
            </form>
            {mesaj && <p>{mesaj}</p>}
        </div>
    );
};

export default KitapEkle;
