let navigater=document.getElementById("navigater");
class MyNavigater extends React.Component{
    constructor(props)
    {
        super(props);

    }
    render(){
        return (
            <span>
                <a href="index.html">首頁</a>
                <a href="queryAll.html">查詢</a>
                <a href="add.html">新增</a>
                <a href="delete.html">刪除</a>
            </span>

        )           
        
    }



}


ReactDOM.createRoot(navigater).render(<MyNavigater/>);