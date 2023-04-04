import React from 'react';
import  { useSelector, useDispatch } from "react-redux";
import { piano, marimba, guitar } from '../../actions/pianoAction';

import './dropDown.css'

function DropDownMenu({changeOpenStatus}) {

    function DropDownItem({changeOpenstatus, ...props }){
        const state = useSelector((state) => state);
        const dispatch = useDispatch();
        
        return(
            <a href="#" className="drop-down-item"
            onClick={() => {
                dispatch(props.instrument),
                changeOpenStatus(false);

            }}>
                {props.children}
            </a>
        )
    }

    const closeMenu = () => {
        changeOpenStatus(false);
    }

    return(
        <div className="drop-down-menu" >
            <DropDownItem instrument={piano()} >Piano</DropDownItem>
            <DropDownItem instrument={marimba()} >Marimba</DropDownItem>
            <DropDownItem instrument={guitar()} >Guitar</DropDownItem>
        </div>
    )
}

export default DropDownMenu