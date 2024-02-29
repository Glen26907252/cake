import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from "react-router-dom";
import CategoryTag from '../CategoryTag/CategoryTag';
import Footer from '../Footer/Footer';
import './detail.css';
import axios from 'axios';

const Detail = () => {
    let params = useParams();
    const navigate = useNavigate(); 

    const [product, setProduct] = useState({});
    const [quantity, setQuantity] = useState(1);
    const [subtotal, setSubtotal] = useState(0);
    const [productList, setProductList] = useState([]); // State to hold product list

    const handleQuantityChange = (e) => {
        setQuantity(e.target.value);
    };

    const calculateSubtotal = () => {
        if (product && product.price) {
            return product.price * quantity;
        } else {
            return 0;
        }
    };

    const handleOrder = async () => {
        try {
            const data = {
                item: product.product_id,
                item_name: product.name,
                amount: quantity,
                subtotal: subtotal,
            };

            const response = await axios.post('http://localhost:8080/cake/add', data);
            console.log(response.data);
            alert('訂單已提交！');
            navigate('/product');

        } catch (error) {
            console.error('發生錯誤：', error);
            alert('訂單提交失敗！');
        }
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/products/queryAllProducts');
                setProductList(response.data);
            } catch (error) {
                console.error('獲取產品列表時發生錯誤：', error);
            }
        };

        fetchData(); // Call the function to fetch data

        const selectedProduct = productList.find(p => p.product_id === params.id); // Update selected product based on params
        setProduct(selectedProduct);

        const newSubtotal = calculateSubtotal();
        setSubtotal(newSubtotal);

    }, [quantity, productList, params.id]);

    if (!product) {
        return <div>Loading...</div>;
    }

    return (
        <>
            <img src="images/banner.jpg" className="img-responsive" id="banner" alt="" />
            <div id="content" className="container">
                <h3 className="title">| 產品細節<small>Detail</small></h3>
                <div className="row">
                    <div className="col-md-8">
                        <img src={`../../images/${product.img}`} className="img-responsive" alt="" />
                    </div>
                    <div className="col-md-4">
                        <h3>{product.name}</h3>
                        <p>{product.descript}</p>
                        <p>價錢：{product.price}元 / 片</p>
                        <p>分類：{Array.isArray(product.category) && product.category.map(c => <CategoryTag key={c} tag={c} />)}</p>
                        <form>
                            <div className="form-group">
                                <label htmlFor="number">數量</label>
                                <input type="text" className="form-control" id="number" placeholder="" onChange={handleQuantityChange} />
                            </div>
                            <button type="button" className="btn btn-default" onClick={handleOrder}>我要訂購</button>
                        </form>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default Detail;
