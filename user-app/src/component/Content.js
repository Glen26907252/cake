import React, { Component } from 'react'
import Home from './home'
import Add from './Add'
import Delete from './Delete'
import Query from './Query'
export default class Content extends Component {
  render() {
    return (
        <div className="container">
     
        <ul class="nav nav-tabs" id="myTab">
          <li class="nav-item"><a class="nav-link active" data-bs-toggle="tab" href="#tab1">首頁</a></li>
          <li class="nav-item"><a class="nav-link" data-bs-toggle="tab" href="#tab2">新增</a></li>
          <li class="nav-item"><a class="nav-link" data-bs-toggle="tab" href="#tab3">刪除</a></li>
        </ul>
        
        <div class="tab-content" id="myTabContent">
          <div class="tab-pane fade show active" id="tab1"><p><Query/></p></div>
          <div class="tab-pane fade" id="tab2"><p><Add/></p></div>
          <div class="tab-pane fade" id="tab3"><p><Delete/></p></div>
        </div>
      </div>
    )
  }
}
