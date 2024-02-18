import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Navibar extends Component {
    render() {
        return (
            <nav className="navbar navbar-inverse navbar-fixed-top">
                <div className="container-fluid">

                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span className="sr-only">Toggle navigation</span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        <Link to="/" className="navbar-brand" >甜 時 ． Sweet</Link>
                    </div>


                    <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul className="nav navbar-nav navbar-right">
                            <li><Link to="/">首頁</Link></li>
                            <li><Link to="/about">關於我們</Link></li>
                            <li><Link to="/product">產品介紹</Link></li>
                            <li><Link to="/query">購買清單</Link></li>

                        </ul>
                    </div>
                </div>
            </nav>
        );
    }
}

export default Navibar;