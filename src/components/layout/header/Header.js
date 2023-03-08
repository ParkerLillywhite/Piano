import React from "react";
import { useHistory } from 'react-router-dom';

const Header = () => {

    let history = useHistory();
    const changeRoute = (path) => {
        history.push(path);
    }


    return(
        <div className="headerContainer">
            <div className="navButtons">
                <button className="homeButton" onClick={() => changeRoute('/')}>
                    Home
                </button>
                <button className='searchButton' onClick={() => changeRoute('search')}>
                    Search
                </button>
            </div>
        </div>
    )
}

export default Header;