import React, { Component } from 'react'
import AddChat from './AddChat'
import QueryAllChat from './QueryAllChat'
export default class EmployeeContent extends Component {
  render() {
    return (
        <div className="container">
     
        <ul class="nav nav-tabs" id="myTab">
          <li class="nav-item"><a class="nav-link active" data-bs-toggle="tab" href="#tab1">首頁</a></li>
          <li class="nav-item"><a class="nav-link" data-bs-toggle="tab" href="#tab2">新增</a></li>
          <li class="nav-item"><a class="nav-link" data-bs-toggle="tab" href="#tab3">查詢</a></li>
        </ul>
        
        <div class="tab-content" id="myTabContent">
          <div class="tab-pane fade show active" id="tab1"><p>巨匠電腦留言資料</p></div>
          <div class="tab-pane fade" id="tab2"><p><AddChat/></p></div>
          <div class="tab-pane fade" id="tab3"><p><QueryAllChat/></p></div>
        </div>
      </div>
    )
  }
}


