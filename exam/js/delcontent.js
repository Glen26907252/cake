let delcontent=document.getElementById("delcontent");

class Delete extends React.Component{
    constructor(props)
    {
        super(props);
    }

    render(){
        return (
            <span>
                        <form action="http://192.168.1.103:8080/user/delete"method="post">
                            UID:<input type="text"    name="uid"/><br/>                            
                            <input type="submit" value="ok"/>
                        </form>
                        
                    </span>
        );
    }
}


ReactDOM.createRoot(delcontent).render(<Delete/>);