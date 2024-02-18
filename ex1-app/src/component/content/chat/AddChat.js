import React, { Component } from 'react';
import axios from 'axios';

export default class AddChat extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      subject: '',
      content: ''
    };
  }

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleSubmit = (e) => {
    e.preventDefault();
    const data = {
      name: this.state.name,
      subject: this.state.subject,
      content: this.state.content
    };

    axios.post("http://192.168.1.103:8080/chat/add", data, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(function (response) {
        console.log(response.data);
        alert("建檔成功");
      })
      .catch(function (error) {
        // 处理错误
      });
  }

  render() {
    return (
      <div>
        <form name="chat" onSubmit={this.handleSubmit}>
          name: <input type="text" name="name" onChange={this.handleChange} value={this.state.name} /><br />
          subject: <input type="text" name="subject" onChange={this.handleChange} value={this.state.subject} /><br />
          content: <input type="text" name="content" onChange={this.handleChange} value={this.state.content} /><br />
          <input type="submit" value="ok" />
        </form>
      </div>
    );
  }
}
