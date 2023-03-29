import React, { useState } from "react";

import './dropDown.css';


function DropDown(props) {

    const [ open, setOpen ] = useState(false);

    return(
        <div className="drop-down-list">
            <div className="drop-down-first-item">
                <a href="#" className="icon-button" onClick={() => setOpen(!open)}>
                {props.icon}
                </a>
                <div className="selected-option">
                    Piano
                </div>
            </div>
            
            {open && props.children}
        </div>
    )
}

export default DropDown;