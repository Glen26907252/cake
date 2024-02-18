import React, { Component } from 'react'

export default class Delete extends Component {
  render() {
    return (
      <div>
        <form action="http://192.168.1.103:8080/user/delete" method="post">
            id:<input type="text" name="uid"/><br/>
             <input type="submit" value="ok"/>
        </form>
      </div>
    )
  }
}
