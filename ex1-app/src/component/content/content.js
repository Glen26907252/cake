import React, { Component } from 'react'
import QueryAllChat from './chat/QueryAllChat'
import AddChat from './chat/AddChat'
import ChatContent from './chat/ChatContent'

export default class header extends Component {
  render() {
    return (
    <div>
      <div><QueryAllChat/></div>
      <div><AddChat/></div>
      <div><ChatContent/></div>
    </div>
    )
  }
}
