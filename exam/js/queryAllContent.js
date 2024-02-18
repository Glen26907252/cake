let content=document.getElementById("queryAllcontent");

class MyContent extends React.Component{
    constructor(props){
        super(props);
    }

    render(){
        return (
            <span>
                <button id="a1" onClick={this.test.bind(this)}>test</button>
                <div id="show"></div>
                
            </span>
        );
    }

    test(e)
    {
       e.preventDefault();
        $("#a1").on("click",function(){
			$.ajax({
				type:"get",
				url:"http://192.168.1.103:8080/user/queryAll",
				success:function(data){
					let x="";
					
					for(let i=0;i<data.length;i++)
					{
						x=x+data[i].uid+","+
						data[i].name+","+
						data[i].email+","+
						data[i].telephone+","+
                        data[i].job+","+
                        data[i].age+"<br><hr/>"
					}
					
					$("#show").html(x);
				}
			});
		});
    }
}


ReactDOM.createRoot(content).render(<MyContent/>);