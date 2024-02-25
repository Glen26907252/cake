import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from "react-router-dom";
import CategoryTag from '../CategoryTag/CategoryTag';
import Footer from '../Footer/Footer';
import './detail.css';
import axios from 'axios';


const Detail = () => {
    let params = useParams();
    const navigate = useNavigate(); // 使用 useHistory 钩子获取 history 对象

    

    // 抓取Route過來的id
    console.log('params',params);

    const [ product, setProduct ] = useState({});
    const [quantity, setQuantity] = useState(1); // 使用 useState hook 來追蹤使用者輸入的數量
    const [subtotal, setSubtotal] = useState(0);

    const handleQuantityChange = (e) => {
        setQuantity(e.target.value); // 當使用者改變數量輸入框的值時更新 quantity 狀態
    };

    const calculateSubtotal = () => {
        return product.price * quantity;
    };

    const handleOrder = async () => {
        try {
            const data = {
                item: product.productId,
                item_name: product.name,
                amount: quantity, // 將使用者輸入的數量存入 amount 欄位
                subtotal: subtotal,

                // 可以在這裡添加其他要傳送的資料
            };

            const response = await axios.post('http://localhost:8080/cake/add', data);

            console.log(response.data);
            alert('訂單已提交！');
            navigate('/product'); // 提交订单成功后重定向到產品頁


        } catch (error) {
            console.error('發生錯誤：', error);
            alert('訂單提交失敗！');
        }
    };

    useEffect(() => {
        const productList = [ 
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
                price: 69,
                category: ["巧克力", "蛋糕"]
            }, {
                productId: 3,
                name: "限量莓果乳酪蛋糕",
                descript: "自製微酸香甜的草莓醬點綴了藍莓，雙層華麗的享受與令人驚豔的口感絕對讓你幸福美滿。",
                img: "cake03.jpg",
                price: 89,
                category: ["水果", "蛋糕"]
            }, {
                productId: 4,
                name: "法式藍莓蛋糕",
                descript: "新鮮藍莓的清香在嘴裡蔓延，甜而不膩的獨家配方，每一口都是幸福的感受。",
                img: "cake04.jpg",
                price: 49,
                category: ["水果", "蛋糕"]
            }, {
                productId: 5,
                name: "法式泡芙",
                descript: "外酥內嫩的口感，三種不同口味一次滿足不同味蕾",
                img: "puff.jpg",
                price: 99,
                category: ["水果", "蛋糕"]
            }
        ];

        let product = productList.find(p => p.productId === Number(params.id));
        console.log('product', product);
        setProduct(product);

        const newSubtotal = calculateSubtotal();
        setSubtotal(newSubtotal);

   
        }, [quantity, product, subtotal, params.id]); // Listen for changes in quantity and product

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
                        <p>分類：
                            {product.category && product.category.map(c => <CategoryTag key={c} tag={c} />)}
                        </p>
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

