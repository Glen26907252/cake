import React, { Component } from 'react';
import './about.css';
import Footer from '../Footer/Footer';

class About extends Component {
    render() {
        return (
            <>
                <img src="images/banner.jpg" className="img-responsive" id="banner" alt=""/>
                <div id="content" className="container">
                    <div className="row text-center">
                        <div className="col-md-6 col-sm-12 text">
                            <h3 className="title">| 關於我們 <small>About Us</small></h3>
                            <p>吃一口讓你宛如置身巴黎街頭，每一口都是滿滿的幸福。</p>
                            <ul className="list">
                                <li>嚴選獨家法式香草佐料</li>
                                <li>時尚、純手工製作</li>
                                <li>全台第一家上市總店</li>
                                <li>採用台灣當季新鮮特產水果</li>
                            </ul>
                        </div>
                        <div className="col-md-6 col-sm-12 pic">
                            <img src="images/cupcake.jpg" className="img-responsive" alt=""/>
                        </div>
                    </div>
                    <div className="row text-center">
                        <div className="col-md-6 col-sm-12 pic">
                            <img src="images/cupcake2.jpg" className="img-responsive" alt=""/>
                        </div>
                        <div className="col-md-6 col-sm-12 text">
                            <h3 className="title">| 店家資訊 <small>Store Information</small></h3>
                            <ul className="list">
                                <li>營業時間：12:00p.m. ~ 20:00p.m.</li>
                                <li>電話：02-12345678</li>
                                <li>地址：台中市中區美術路二段102號</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <Footer />
            </>
        );
    }
}

export default About;