import logo from './logo.svg';
import './App.css';
import News from "./news/news";
import * as PropTypes from "prop-types";
import Home from "./home/home";


function Routes(props) {
    return null;
}

Routes.propTypes = {children: PropTypes.node};

function App() {
    return (
       <>
           <News></News>
           <Home></Home>
       </>
    );
}

export default App;
