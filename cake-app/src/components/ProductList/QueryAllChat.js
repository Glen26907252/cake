/////////////////////////////////////////查看訂單 刪除OK/////////////////////////////////////////////////////
// import React, { Component } from 'react';
// import Footer from '../Footer/Footer';
// import './productList.css';
// import axios from 'axios';

// export default class QueryAllChat extends Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       deleteId: '',
//       showDeleteControls: false, // 控制刪除相關元素的顯示
//       queryResult: []
//     };
//   }

//   handleInputChange = (e) => {
//     this.setState({
//       deleteId: e.target.value
//     });
//   };

//   handleDeleteClick = () => {
//     this.setState({
//       showDeleteControls: true, // 點擊刪除時設置為true，顯示相關元素
//     });
//     this.test();
//   };

//   handleDelete = () => {
//     const { deleteId } = this.state;
//     axios.delete(`http://192.168.1.103:8080/cake/delete/${deleteId}`)
//       .then(response => {
//         this.test();
//         this.setState({ deleteId: '' }); // 清空文字框的內容
//       })
//       .catch(error => {
//         console.error('删除失败:', error);
//       });
//   };

//   test = () => {
//     axios.get("http://192.168.1.103:8080/cake/queryAllCake")
//       .then(response => {
//         this.setState({
//           queryResult: response.data
//         });
//       })
//       .catch(error => {
//         console.error('获取数据失败:', error);
//       });
//   };

//   handleQueryClick = () => {
//     this.setState({
//       showDeleteControls: false, // 點擊查詢時重置為false，隱藏相關元素
//     });
//     this.test();
//   };

//   render() {
//     const { showDeleteControls, queryResult } = this.state;
//     return (
//       <div>
//         <img src="images/banner.jpg" className="img-responsive" id="banner" alt="" /><br/>
//         <ul className="nav nav-tabs">
//           <li className="nav-item">
//             <button className="custom-button" onClick={this.handleQueryClick}>查看訂單</button>
//           </li>
//           <li className="nav-item">
//             <button className="custom-button" onClick={this.handleDeleteClick}>刪除</button>
//           </li>
          
          
//         </ul>
//         {showDeleteControls && (
//           <div>
//             <input type="text" value={this.state.deleteId} onChange={this.handleInputChange} placeholder="輸入要刪除的訂單ID" />
//             <button onClick={this.handleDelete}>確認刪除</button>
//           </div>
//         )}
//         {queryResult.length > 0 && (
//           <div id="show">
//             <table border="1" align="center" width="70%">
//               <thead>
//                 <tr>
//                   <th>訂單編號</th>
//                   <th>商品代號</th>
//                   <th>商品品名</th>
//                   <th>數量</th>
//                   <th>金額</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {queryResult.map(item => (
//                   <tr key={item.id}>
//                     <td>{item.id}</td>
//                     <td>{item.item}</td>
//                     <td>{item.itemName}</td>
//                     <td className="right-align">{item.amount ? item.amount.toLocaleString() : ""}</td>
//                     <td className="right-align">{item.subtotal ? item.subtotal.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 }) + " NTD" : ""}</td>
//                   </tr>
//                 ))}
//               </tbody>

//             </table>
//             <br/>共:{queryResult.length}筆
//           </div>
//         )}
//         <Footer />
//       </div>
//     )
//   }
// }


/////////////////////////////////////////增加 Tab修改 但Update後 品名和金額會不見///////////////////////////////////////////////////


// import React, { Component } from 'react';
// import Footer from '../Footer/Footer';
// import './productList.css';
// import axios from 'axios';

// export default class QueryAllChat extends Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       deleteId: '',
//       updateId: '',
//       updateItem: '',
//       updateQuantity: '',
//       showDeleteControls: false,
//       showUpdateControls: false,
//       queryResult: []
//     };
//   }

//   handleInputChange = (e) => {
//     this.setState({
//       deleteId: e.target.value
//     });
//   };

//   handleDeleteClick = () => {
//     this.setState({
//       showDeleteControls: true,
//     });
//     this.test();
//   };

//   handleDelete = () => {
//     const { deleteId } = this.state;
//     axios.delete(`http://192.168.1.103:8080/cake/delete/${deleteId}`)
//       .then(response => {
//         this.test();
//         this.setState({ deleteId: '' });
//       })
//       .catch(error => {
//         console.error('删除失败:', error);
//       });
//   };

//   test = () => {
//     axios.get("http://192.168.1.103:8080/cake/queryAllCake")
//       .then(response => {
//         this.setState({
//           queryResult: response.data
//         });
//       })
//       .catch(error => {
//         console.error('获取数据失败:', error);
//       });
//   };

//   handleQueryClick = () => {
//     this.setState({
//       showDeleteControls: false,
//     });
//     this.test();
//   };

//   handleUpdateClick = () => {
//     this.setState({
//       showUpdateControls: true,
//     });
//   };

//   handleUpdateInputChange = (e) => {
//     this.setState({
//       [e.target.name]: e.target.value,
//     });
//   };

//   handleUpdate = () => {
//     const { updateId, updateItem, updateQuantity } = this.state;
//     const data = {
//       item: updateItem,
//       amount: updateQuantity
//     };

//     axios.put(`http://192.168.1.103:8080/cake/update/${updateId}`, data)
//       .then(response => {
//         this.test();
//         this.setState({ 
//           updateId: '',
//           updateItem: '',
//           updateQuantity: '',
//           showUpdateControls: false
//         });
//       })
//       .catch(error => {
//         console.error('更新訂單失敗:', error);
//       });
//   };

//   render() {
//     const { showDeleteControls, showUpdateControls, queryResult } = this.state;
//     return (
//       <div>
//         <img src="images/banner.jpg" className="img-responsive" id="banner" alt="" /><br/>
//         <ul className="nav nav-tabs">
//           <li className="nav-item">
//             <button className="custom-button" onClick={this.handleQueryClick}>查看訂單</button>
//           </li>
//           <li className="nav-item">
//             <button className="custom-button" onClick={this.handleDeleteClick}>刪除</button>
//           </li>
//           <li className="nav-item">
//             <button className="custom-button" onClick={this.handleUpdateClick}>修改</button>
//           </li>
//         </ul>
//         {showDeleteControls && (
//           <div>
//             <input type="text" value={this.state.deleteId} onChange={this.handleInputChange} placeholder="輸入要刪除的訂單ID" />
//             <button onClick={this.handleDelete}>確認刪除</button>
//           </div>
//         )}
//         {showUpdateControls && (
//           <div>
//             <input type="text" name="updateId" value={this.state.updateId} onChange={this.handleUpdateInputChange} placeholder="輸入要修改的訂單ID" />
//             <input type="text" name="updateItem" value={this.state.updateItem} onChange={this.handleUpdateInputChange} placeholder="輸入要修改的商品" />
//             <input type="text" name="updateQuantity" value={this.state.updateQuantity} onChange={this.handleUpdateInputChange} placeholder="輸入修改後的數量" />
//             <button onClick={this.handleUpdate}>確認修改</button>
//           </div>
//         )}
//         {queryResult.length > 0 && (
//           <div id="show">
//             <table border="1" align="center" width="70%">
//               <thead>
//                 <tr>
//                   <th>訂單編號</th>
//                   <th>商品代號</th>
//                   <th>商品品名</th>
//                   <th>數量</th>
//                   <th>金額</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {queryResult.map(item => (
//                   <tr key={item.id}>
//                     <td>{item.id}</td>
//                     <td>{item.item}</td>
//                     <td>{item.itemName}</td>
//                     <td className="right-align">{item.amount ? item.amount.toLocaleString() : ""}</td>
//                     <td className="right-align">{item.subtotal ? item.subtotal.toLocaleString(undefined, { minimumFractionDigits: 2, maximumFractionDigits: 2 }) + " NTD" : ""}</td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//             <br/>共:{queryResult.length}筆
//           </div>
//         )}
//         <Footer />
//       </div>
//     )
//   }
// }


//////////////////////////test///////////////

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
    });
    this.test();
  };

  handleDelete = () => {
    const { deleteId } = this.state;
    axios.delete(`http://192.168.1.103:8080/cake/delete/${deleteId}`)
      .then(response => {
        this.test();
        this.setState({ deleteId: '' });
      })
      .catch(error => {
        console.error('删除失败:', error);
      });
  };

  test = () => {
    axios.get("http://192.168.1.103:8080/cake/queryAllCake")
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
    });
    this.test();
  };

  handleUpdateClick = () => {
    this.setState({
      showUpdateControls: true,
    });
  };

  handleUpdateInputChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  handleUpdate = () => {
    const { updateId, updateItem, updateQuantity } = this.state;
    const data = {
      item: updateItem,
      amount: updateQuantity
    };

    axios.put(`http://192.168.1.103:8080/cake/update/${updateId}`, data)
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
