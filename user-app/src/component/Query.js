import React, { Component } from 'react'

export default class Query extends Component {
  render() {
    return (
      <div>
            <h2>query</h2>
            <form action="http://192.168.1.103:8080/user/queryAll" method="get">
           
             <input type="submit" value="ok"/>
        </form>
      </div>
    )
  }
}
