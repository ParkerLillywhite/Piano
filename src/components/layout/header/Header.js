import React from "react";
import { useHistory } from 'react-router-dom';

import './header.css'

const Header = () => {

    let history = useHistory();
    const changeRoute = (path) => {
        history.push(path);
    }


    return(
        <NavBar>            
            <button className="homeButton" onClick={() => changeRoute('/')}>
                Home
            </button>
            <button className='searchButton' onClick={() => changeRoute('search')}>
                Search
            </button>
        </NavBar>
    )
}

function NavBar(props) {
    return(
        <div className="navbar">
            <ul className="navbar-nav"> {props.children} </ul>
        </div>
    )
}

export default Header;