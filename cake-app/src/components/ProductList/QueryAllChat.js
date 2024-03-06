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
  
    axios.get(`http://localhost:8080/products/queryAllProducts`)
      .then(response => {
        const products = response.data;
        console.log('商品列表:', products);
  
        // 將 updateItem 轉換為字符串類型
        const stringUpdateItem = updateItem.toString();
  
        const product = products.find(p => p.product_id === stringUpdateItem);
        console.log('查找的商品:', product);
  
        if (!product) {
          console.error('商品不存在');
          return;
        }
  
        const data = {
          item: stringUpdateItem,
          item_name: product.name,
          amount: updateQuantity,
          subtotal: product.price * updateQuantity,
        };
  
        axios.put(`http://localhost:8080/cake/update/${updateId}`, data)
          .then(response => {
            this.test(); // 更新訂單後刷新訂單列表
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
      })
      .catch(error => {
        console.error('獲取商品信息失敗:', error);
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
          <div>
            <table border="1" width="70%">
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
              共:{queryResult.length}筆
            </table>
             
          </div>
        )}
        <Footer />
      </div>
    )
  }
  
}