import React, { useState } from "react";
import { useSelector } from 'react-redux';
import { connect } from 'react-redux';
import  cloneDeep from 'lodash/cloneDeep';


import './dropDown.css';


function DropDown(props) {

    const { instrument } = props;

    const [ open, setOpen ] = useState(false);

    const state = useSelector((state) => state.instruments);

    const instrumentClone = cloneDeep(state);

    return(
        <div className="drop-down-list">
            <div className="drop-down-first-item">
                <a href="#" className="icon-button" onClick={() => setOpen(!open)}>
                {props.icon}
                </a>
                <div className="selected-option">
                    {console.log(instrument)}
                    {console.log(instrumentClone)}
                     current instrument: {instrument}
                </div>
            </div>
            
            {open && props.children}
        </div>
    )
}
const mapStateToProps = state => {
    return {
        instrument: state.instruments.instrument
    }
}

export default connect(mapStateToProps)(DropDown);