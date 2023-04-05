import React, { useEffect, useState } from "react";
import { useSelector } from 'react-redux';
import { connect, useDispatch } from 'react-redux';
import { DropDownMenu } from ".";
import  cloneDeep from 'lodash/cloneDeep';
import DropDownCaret from '../../../static/assets/svg/drop.svg';



import './dropDown.css';


function DropDown(props) {

    const { 
        instrument,
     } = props;

    const [ open, setOpen ] = useState(false);
    
    return(
        <div className="drop-down-list">
            <div className="drop-down-first-item">
                <a href="#" className="icon-button" onClick={() => setOpen(!open)}>
                    <img 
                        className="icon-button-svg"
                        src={DropDownCaret}
                        alt="Drop Down Caret"
                    />

                
                </a>
                <div className="selected-option">
                     Instrument: {instrument}
                </div>
            </div>
            
            {open && <DropDownMenu changeOpenStatus={setOpen}/>}
        </div>
    )
}
const mapStateToProps = state => {
    return {
        instrument: state.instruments.instrument
    }
}

export default connect(mapStateToProps)(DropDown);