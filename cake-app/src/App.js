import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';
import Navibar from './components/Navibar/Navibar';
import Home from './components/Home/Home';
import About from './components/About/About';
import ProductList from './components/ProductList/ProductList';
import Detail from './components/Detail/Detail';
import QueryAllChat from './components/ProductList/QueryAllChat';

function App() {
  return (
    <Router>
        <Navibar />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/product" element={<ProductList />} />
            <Route path="/query" element={<QueryAllChat />} />
            <Route path="/detail" element={<Detail />}>
              <Route path=":id" element={<Detail />} />

            </Route>
        </Routes>
    </Router>
  );
}

export default App;
