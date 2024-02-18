let addcntent=document.getElementById("addContent");

class Add extends React.Component{
    constructor(props)
    {
        super(props);
    }

    render(){
        return (
            <span>
                        <form action="http://192.168.1.103:8080/user/add"    method="post">
                            name:<input type="text"    name="name" /><br/>
                            age:<input type="text"    name="age"/><br/>
                            telphone:<input type="text"    name="telephone"/><br/>
                            email:<input type="text"    name="email"/><br/>
                            job:<input type="text"    name="job"/><br/>
                            
                            <input type="submit" value="ok"/>
                        </form>
                        
                    </span>
        );
    }
}


ReactDOM.createRoot(addcntent).render(<Add/>);