let header=document.getElementById("header");
class MyHeader extends React.Component{
    constructor(props)
    {
        super(props);
        
        }
   

    render()
    {
        return (
            <span>
                <h3>使用者管理系統</h3>                
            </span>
        );
    }

}
    ReactDOM.createRoot(header).render(<MyHeader/>);
