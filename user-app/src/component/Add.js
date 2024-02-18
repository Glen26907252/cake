import React, { Component } from 'react'

export default class Add extends Component {
  render() {
    return (
      <div>
        <form action="http://192.168.1.103:8080/user/add" method="post">
            name:<input type="text" name="name"/><br/>
            email:<input type="text" name="email"/><br/>
            telephone:<input type="text" name="telephone"/><br/>
            job:<input type="text" name="job"/><br/>
            age:<input type="text" name="age"/><br/>
            <input type="submit" value="ok"/>
        </form>
       </div>
    )
  }
}
