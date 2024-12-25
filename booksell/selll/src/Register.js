import React, { useState } from 'react';
import axios from 'axios';
import './Login.css'; // Aynı tasarım stilini kullanıyoruz

function Register() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [gender, setGender] = useState('');
    const [userType, setUserType] = useState('');
    const [phone, setPhone] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const handleRegister = async () => {
        try {
            // Kullanıcı verilerini doğru formatta gönderiyoruz
            const response = await axios.post('http://localhost:8080/api/kullanici/kayit', {
                kullaniciAdi: username,
                sifre: password,
                email: email,
                cinsiyet: gender,
                kullaniciTipi: userType,
                telefonNo: phone,
                bakiye: 0 // Default bakiye
            });

            if (response.status === 200) {
                console.log('Kayıt başarılı');
                // Kayıt başarılı olduktan sonra yönlendirme yapılabilir
                window.location.href = "/login";
            }
        } catch (error) {
            console.error('Hata:', error.response ? error.response.data : error.message);
            setErrorMessage('Kayıt işlemi sırasında bir hata oluştu.');
        }
    };

    return (
        <div className="login-container">
            <div className="login-card">
                <h2>Kayıt Ol</h2>
                <div className="login-form">
                    <label>
                        Kullanıcı Adı:
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            placeholder="Kullanıcı adınızı girin"
                            className="input-field"
                        />
                    </label>
                    <label>
                        Şifre:
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="Şifrenizi girin"
                            className="input-field"
                        />
                    </label>
                    <label>
                        E-mail:
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            placeholder="E-mail adresinizi girin"
                            className="input-field"
                        />
                    </label>
                    <label>
                        Cinsiyet:
                        <select
                            value={gender}
                            onChange={(e) => setGender(e.target.value)}
                            className="input-field"
                        >
                            <option value="">Seçiniz</option>
                            <option value="Erkek">Erkek</option>
                            <option value="Kadın">Kadın</option>
                            <option value="Diğer">Diğer</option>
                        </select>
                    </label>
                    <label>
                        Kullanıcı Tipi:
                        <select
                            value={userType}
                            onChange={(e) => setUserType(e.target.value)}
                            className="input-field"
                        >
                            <option value="">Seçiniz</option>
                            <option value="Bireysel">Bireysel</option>
                            <option value="Kurumsal">Kurumsal</option>
                        </select>
                    </label>
                    <label>
                        Telefon Numarası:
                        <input
                            type="tel"
                            value={phone}
                            onChange={(e) => setPhone(e.target.value)}
                            placeholder="Telefon numaranızı girin"
                            className="input-field"
                        />
                    </label>

                    {errorMessage && <p className="error-message">{errorMessage}</p>}
                    <button onClick={handleRegister} className="login-btn">Kayıt Ol</button>
                </div>
            </div>
        </div>
    );
}

export default Register;
