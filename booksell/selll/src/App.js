import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import Books from './Books'; // Örnek bir Books sayfası
import KitapEkle from "./KitapEkle";
import Cart from "./Cart";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/books" element={<Books />} />
                <Route path="/add-book" element={<KitapEkle />} />
                <Route path="/cart" element={<Cart />} />
                {/* Diğer sayfalar */}
            </Routes>
        </Router>
    );
}

export default App;
