import React, { Component } from 'react';
import Content from './component/Content';


export default class App extends Component {
  render() {
    return (
      <span>
        <div class="header">header</div>
        <div class="content">
            <div class="con"><Content/></div>
        </div>
        <div class="footer">footer</div>
      </span>
    )
  }
}
