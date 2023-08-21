import React from 'react';
import {Order} from "../models/Order"

const SingleOrder = ({ order}) => {
    return <form className="orders_single">
        <div className="orders_single--text">
            Customer has ordered {order.name}
        </div>
        <div className="orders_single--price">
            The price is {order.price} KRW
        </div>
    </form>
}

export default SingleOrder