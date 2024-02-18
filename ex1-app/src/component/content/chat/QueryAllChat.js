import React, { Component } from 'react'
import axios from 'axios'

export default class QueryAllChat extends Component {
  render() {
    return (
      <div>
        <button onClick={this.test.bind(this)}>測試</button>
        <div id="show"></div>
      </div>
    )
  }

  test(e)
  {
    e.preventDefault();
    const x=axios.get("http://192.168.1.103:8080/chat/queryAllChat");//XMLHttpRequest
    let y="";
    let sum=0;
    x.then(response=>{
       let y="<table border=1 align='center' width=70%>";

        for(let i=0;i<response.data.length;i++)
        {
            y=y+"<tr><td>"+response.data[i].id+
            "<td>"+response.data[i].name+
            "<td>"+response.data[i].subject+
            "<td>"+response.data[i].content;
            
            sum++;
            
            console.log(sum);
        }
       y=y+"</table>";
        let s=document.getElementById("show");

        s.innerHTML=y+"<br/>共:"+sum+"筆";



    });
  }
}