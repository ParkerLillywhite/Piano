import React from 'react';
import  { useSelector, useDispatch } from "react-redux";
import { piano, marimba, guitar } from '../../actions/pianoAction';

import './dropDown.css'

function DropDownMenu() {

    function DropDownItem(props){
        const state = useSelector((state) => state);
        const dispatch = useDispatch();

        return(
            <a href="#" className="drop-down-item"
            onClick={() => {dispatch(props.instrument), console.log(state)}}>
                {props.children}
            </a>
        )
    }

    return(
        <div className="drop-down-menu">
            <DropDownItem instrument={piano()} >Piano</DropDownItem>
            <DropDownItem instrument={marimba()} >Marimba</DropDownItem>
            <DropDownItem instrument={guitar()} >Guitar</DropDownItem>

        </div>
    )
}

export default DropDownMenu