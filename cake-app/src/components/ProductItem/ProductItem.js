import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class ProductItem extends Component {
    constructor(props) {
        super(props);
    }
    render() {

        const { productInfo } = this.props;
        console.log('productInfo',productInfo);
        const { product_id, name, descript, img } = productInfo;
        return (
            <div className="col-xs-12 col-sm-6 col-md-4 text-center item">
                <img src={`images/${img}`} className="img-responsive" alt="" />
                <h3>{ name }</h3>
                <p>{descript}</p>
                <Link to={`/detail/${product_id}`} className="btn btn-default">查看</Link>
            </div>
        );
    }
}

export default ProductItem;