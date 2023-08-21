import React, {useEffect, useState} from "react";
import { Order } from "../models/Order";
import axios from 'axios';
import './styles.css'
import SingleOrder from "./SingleOrder";

const OrderList: React.FC = () => {
  const [orders, setOrders] = useState<Order[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get<{ orders: Order[] }>('http://127.0.0.1:8082/product');
        setOrders(response.data.orders);
      } catch(error) {
        console.error('Error fetching data:', error);
      }
    };
    fetchData();
  }, []);

    return ( 
        <div className="orders">
            {orders.map((order) => (
                <SingleOrder 
                    order={order}
                    key={order.id}
                />
        ))}
    </div>
    );
};

export default OrderList;