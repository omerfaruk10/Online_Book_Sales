import React, { useState } from 'react';
import axios from 'axios';
import { Navigate } from 'react-router-dom';
import './Login.css';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [redirectToBooks, setRedirectToBooks] = useState(false);

    const handleLogin = async () => {
        try {
            const response = await axios.post('http://localhost:8080/api/kullanici/login', {
                kullaniciAdi: username,
                sifre: password
            });

            if (response.status === 200) {
                // Başarıyla giriş yapıldığında
                setRedirectToBooks(true);
            }
        } catch (error) {
            console.error('Login error:', error);
            setErrorMessage('Geçersiz kullanıcı adı veya şifre.');
        }
    };


    if (redirectToBooks) {
        return <Navigate to="/books" />;
    }

    return (
        <div className="login-container">
            <div className="login-card">
                <h2>Giriş Yap</h2>
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
                    {errorMessage && <p className="error-message">{errorMessage}</p>}
                    <button onClick={handleLogin} className="login-btn">Giriş Yap</button>
                    {/* Kayıt ol butonu */}
                    <button onClick={() => window.location.href = "/register"} className="register-btn">Kayıt Ol</button>
                </div>
            </div>
        </div>
    );
}

export default Login;
