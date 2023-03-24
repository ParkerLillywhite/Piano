import React from 'react';
import _ from 'lodash';

import './key.css';

import { NOTE_TO_KEY } from '../../constants/notes';

function noteIsFlatChecker(note) {
    return note.includes("p");
}


function keyIsPressedChecker(note, pressedKeys){
    return _.includes(pressedKeys, note);
    
}

class Key extends React.Component{
    render(){
        let keyClassName = "key";
        
        const noteIsFlat = noteIsFlatChecker(this.props.note);
        const keyIsPressed = keyIsPressedChecker(this.props.note, this.props.pressedKeys);

        if(noteIsFlat) {
            keyClassName += "flat";
        }
        if(keyIsPressed) {
            keyClassName += "pressed";
        }

        let key;

        if (noteIsFlat){
            key = (
                <div className={keyClassName}></div>
            );
        } else {
            key = (
                <div className={keyClassName}>
                    <div className="key-text">
                        {this.props.note.toUpperCase()}
                    </div>
                </div>
            );
        }
        return key;
    }
}

export default Key;