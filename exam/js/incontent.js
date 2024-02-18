let incontent=document.getElementById("incontent");


class Pic extends React.Component{
    constructor(props)
    {
        super(props);
    }

    render(){
        return <img alt="101" src="images/101.jpg"></img>
    }
}


ReactDOM.createRoot(incontent).render(<Pic/>);