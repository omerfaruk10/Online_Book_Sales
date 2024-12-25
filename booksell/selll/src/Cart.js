import React, { useState } from "react";
import "./Cart.css"; // CSS dosyasını import edelim

const Cart = () => {
    const [cartItems, setCartItems] = useState([
        {
            name: "Kitap 1",
            price: 1,
            quantity: 1,
            image: "",
        },
    ]);

    const removeItem = (id) => {
        setCartItems(cartItems.filter(item => item.id !== id));
    };

    const updateQuantity = (id, newQuantity) => {
        setCartItems(cartItems.map(item =>
            item.id === id ? { ...item, quantity: newQuantity } : item
        ));
    };

    const getTotal = () => {
        return cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
    };

    return (
        <div className="cart-container">
            <h2>Alışveriş Sepeti</h2>

            {cartItems.length === 0 ? (
                <p>Sepetinizde ürün bulunmamaktadır.</p>
            ) : (
                <div className="cart-items">
                    {cartItems.map((item) => (
                        <div key={item.id} className="cart-item">
                            <img src={item.image} alt={item.name} className="cart-item-image" />
                            <div className="cart-item-details">
                                <h3>{item.name}</h3>
                                <p>{item.price} TL</p>
                                <div className="quantity">
                                    <button onClick={() => updateQuantity(item.id, item.quantity - 1)} disabled={item.quantity <= 1}>-</button>
                                    <span>{item.quantity}</span>
                                    <button onClick={() => updateQuantity(item.id, item.quantity + 1)}>+</button>
                                </div>
                                <p><strong>Toplam: {item.price * item.quantity} TL</strong></p>
                            </div>
                            <button onClick={() => removeItem(item.id)} className="remove-button">Kaldır</button>
                        </div>
                    ))}
                </div>
            )}

            <div className="cart-summary">
                <h3>Toplam Tutar: {getTotal()} TL</h3>
                <div className="cart-actions">
                    <button className="clear-cart">Sepeti Temizle</button>
                    <button className="checkout">Ödeme Yap</button>
                </div>
            </div>
        </div>
    );
};

export default Cart;
