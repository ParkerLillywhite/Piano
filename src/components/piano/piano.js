import React from "react";
import Key from './key';
import { NOTES } from '../../constants/notes';

import './piano.css';

class Piano extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pressedKeys: ['d']
        };
    }

    render(){
        const keys = NOTES.map((note, index) => {
            return (
                <Key 
                    key={index}
                    note={note}
                    pressedKeys={this.state.pressedKeys}
                />
            )
        })
        return(
            <div className="piano">
                {keys}
            </div>
        )
    }
}

export default Piano;