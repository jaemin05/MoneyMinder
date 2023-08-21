import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { Order } from "./models/Order";
import OrderList from './components/OrderList';

const App: React.FC = () => {

  return (
    <div className="App">
      <span className="heading">Market Admin</span>
      <OrderList/>
    </div>
  )
}

export default App;
