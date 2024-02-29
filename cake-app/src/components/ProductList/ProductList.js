import React, { Component } from 'react';
import Footer from '../Footer/Footer';
import './productList.css';
import ProductItem from '../ProductItem/ProductItem';
import axios from 'axios';

class Product extends Component {

    constructor(props) {
        super(props);
        this.state = {
            productList: null
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/products/queryAllProducts')
            .then(response => {
                // 從後端獲取產品資料成功，將資料設置到state中
                this.setState({
                    productList: response.data
                });
            })
            .catch(error => {
                console.error('獲取產品資料失敗：', error);
            });
    }
    

    render() {
        const { productList } = this.state;
        if (productList === null) {
            return <div>Loading...</div>;
        }
        return (
            <>
                <img src="images/banner.jpg" className="img-responsive" id="banner" alt="" />
                <div id="content" className="container">
                    <h3 className="title">| 產品介紹<small>Product</small></h3>
                    <div className="row">
                        {productList.map((productInfo) => <ProductItem key={ productInfo.productId } productInfo={ productInfo }/>)}
                    </div>
                </div>
                <Footer />
            </>
        );
    }
}

export default Product;