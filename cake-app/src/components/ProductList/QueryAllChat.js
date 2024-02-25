import React, { Component } from 'react';
import Footer from '../Footer/Footer';
import './productList.css';
import axios from 'axios';

export default class QueryAllChat extends Component {
  constructor(props) {
    super(props);
    this.state = {
      deleteId: '',
      updateId: '',
      updateItem: '',
      updateQuantity: '',
      showDeleteControls: false,
      showUpdateControls: false,
      queryResult: []
    };
  }

  handleInputChange = (e) => {
    this.setState({
      deleteId: e.target.value
    });
  };

  handleDeleteClick = () => {
    this.setState({
      showDeleteControls: true,
      showUpdateControls: false, // 添加这行以隐藏修改表单
    });
    this.test();
  };

  handleDelete = () => {
    const { deleteId } = this.state;
    axios.delete(`http://localhost:8080/cake/delete/${deleteId}`)
      .then(response => {
        this.test();
        this.setState({ deleteId: '' });
      })
      .catch(error => {
        console.error('删除失败:', error);
      });
  };

  test = () => {
    axios.get("http://localhost:8080/cake/queryAllCake")
      .then(response => {
        this.setState({
          queryResult: response.data
        });
      })
      .catch(error => {
        console.error('获取数据失败:', error);
      });
  };

  handleQueryClick = () => {
    this.setState({
      showDeleteControls: false,
      showUpdateControls: false, // 添加这行以隐藏修改表单
    });
    this.test();
  };

  handleUpdateClick = () => {
    this.setState({
      showUpdateControls: true,
      showDeleteControls: false,
    });
    this.test();
  };

  handleUpdateInputChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  handleUpdate = () => {
    const { updateId, updateItem, updateQuantity } = this.state;
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
    const product = productList.find(p => p.productId === Number(updateItem));
    if (!product) {
      console.error('商品不存在');
      return;
    }
    const data = {
      item: updateItem,
      item_name: product.name,
      amount: updateQuantity,
      subtotal: product.price * updateQuantity,
    };
  
    axios.put(`http://localhost:8080/cake/update/${updateId}`, data)
      .then(response => {
        this.test();
        this.setState({ 
          updateId: '',
          updateItem: '',
          updateQuantity: '',
          showUpdateControls: false
        });
      })
      .catch(error => {
        console.error('更新訂單失敗:', error);
      });
  };

  render() {
    const { showDeleteControls, showUpdateControls, queryResult } = this.state;
    return (
      <div>
        <img src="images/banner.jpg" className="img-responsive" id="banner" alt="" /><br/>
        <ul className="nav nav-tabs">
          <li className="nav-item">
            <button className="custom-button" onClick={this.handleQueryClick}>查看訂單</button>
          </li>
          <li className="nav-item">
            <button className="custom-button" onClick={this.handleDeleteClick}>刪除</button>
          </li>
          <li className="nav-item">
            <button className="custom-button" onClick={this.handleUpdateClick}>修改</button>
          </li>
        </ul>
        {showDeleteControls && (
          <div>
            <input type="text" value={this.state.deleteId} onChange={this.handleInputChange} placeholder="輸入要刪除的訂單ID" />
            <button onClick={this.handleDelete}>確認刪除</button>
          </div>
        )}
        {showUpdateControls && (
          <div>
            <input type="text" name="updateId" value={this.state.updateId} onChange={this.handleUpdateInputChange} placeholder="輸入要修改的訂單ID" />
            <input type="text" name="updateItem" value={this.state.updateItem} onChange={this.handleUpdateInputChange} placeholder="輸入要修改的商品" />
            <input type="text" name="updateQuantity" value={this.state.updateQuantity} onChange={this.handleUpdateInputChange} placeholder="輸入修改後的數量" />
            <button onClick={this.handleUpdate}>確認修改</button>
          </div>
        )}
        {queryResult.length > 0 && (
          <div id="show">
            <table border="1" align="center" width="70%">
              <thead>
                <tr>
                  <th>訂單編號</th>
                  <th>商品代號</th>
                  <th>商品品名</th>
                  <th>數量</th>
                  <th>金額</th>
                </tr>
              </thead>
              <tbody>
                {queryResult.map(item => (
                  <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.item}</td>
                    <td>{item.item_name}</td>
                    <td className="right-align">{item.amount ? item.amount.toLocaleString() : ""}</td>
                    <td className="right-align">{item.subtotal ? item.subtotal.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 }) + " NTD" : ""}</td>
                  </tr>
                ))}
              </tbody>
            </table>
            <br/>共:{queryResult.length}筆  
          </div>
        )}
        <Footer />
      </div>
    )
  }
}
