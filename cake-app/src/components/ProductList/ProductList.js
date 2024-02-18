import React, { Component } from 'react';
import Footer from '../Footer/Footer';
import './productList.css';
import ProductItem from '../ProductItem/ProductItem';

class Product extends Component {

    constructor(props) {
        super(props);
        this.state = {
            productList: null
        };
    }

    componentDidMount() {
        // 取得產品資料
        this.setState({
            productList: [
                {
                    productId: 1,
                    name: "鄉村檸檬乳酪塔",
                    descript: "採用紐西蘭小鄉村濃郁的乳酪香味，搭配清涼檸檬口感是鄉村中最具引響力的一道甜點。",
                    img: "cake01.jpg",
                    price: 79,
                    category: ["水果", "蛋糕"]
                }, {
                    productId: 2,
                    name: "精緻手工巧克蛋糕",
                    descript: "本店採用歐洲低筋麵粉純手工製作，搭配瑞士金典巧克力碎片，每一口都能被巧克力滋潤，令人著迷且充滿想像的奇幻空間。",
                    img: "cake02.jpg",
                    price: 79,
                    category: ["水果", "蛋糕"]
                }, {
                    productId: 3,
                    name: "限量莓果乳酪蛋糕",
                    descript: "自製微酸香甜的草莓醬點綴了藍莓，雙層華麗的享受與令人驚豔的口感絕對讓你幸福美滿。",
                    img: "cake03.jpg",
                    price: 79,
                    category: ["水果", "蛋糕"]
                }, {
                    productId: 4,
                    name: "法式藍莓蛋糕",
                    descript: "新鮮藍莓的清香在嘴裡蔓延，甜而不膩的獨家配方，每一口都是幸福的感受。",
                    img: "cake04.jpg",
                    price: 79,
                    category: ["水果", "蛋糕"]
                }, {
                    productId: 5,
                    name: "法式泡芙",
                    descript: "外酥內嫩的口感，三種不同口味一次滿足不同味蕾",
                    img: "puff.jpg",
                    price: 79,
                    category: ["水果", "蛋糕"]
                }
            ]
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