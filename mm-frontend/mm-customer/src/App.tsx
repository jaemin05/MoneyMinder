import React, { useEffect, useState } from 'react';
import './App.css';
import axios from 'axios';

const App: React.FC = () => {
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');

  const handleNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setName(event.target.value);
  };

  const handlePriceChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setPrice(event.target.value);
  };

  const handleRefreshClick = () => {
    window.location.reload();
  };

  const postData = async () => {
    try {
      const data = {
        name: name,
        price: Number(price), // price를 숫자로 변환하여 보냄
      };

     await axios.post('http://127.0.0.1:8081/order', data); 

    } catch (error) {
      console.error('Error sending POST request:', error);
    }
  };

  const handleButtonClick = () => {
    postData();
    handleRefreshClick();
  };

  return (
    <div className="App">
      <span className="heading">Market Customer</span>
      <div className="input">
        <label className="label_text">Name: </label>
        <input className="input__box" placeholder="Please enter a product's name" type="text" value={name} onChange={handleNameChange} />
      </div>
      <div className="input">
        <label className="label_text">Price: </label>
        <input className="input__box" placeholder="Please enter a product's price" type="number" value={price} onChange={handlePriceChange} />
      </div>
      <button className="input_submit" onClick={handleButtonClick}>Order</button>
    </div>
  )
}

export default App;
