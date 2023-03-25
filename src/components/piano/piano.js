import React from "react";
import Key from './key';
import { KEY_TO_NOTE, NOTES, VALID_KEYS } from '../../constants/notes';
import { sound } from '../../../static/assets/b.mp3';

import './piano.css';
import _ from "lodash";

//current bug dealing with the handle up reasing all current pressed keys.

class Piano extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pressedKeys: []
        };
    }
    
    componentDidMount = () => {
        window.addEventListener('keydown', this.handleKeyDown);
        window.addEventListener('keyup', this.handleKeyUp);
    }

    playNote = (note) => {
        if(!_.isEmpty(note)) {
            const noteAudio = new Audio(window.location.origin + '/assets/b.mp3');
            noteAudio.play();
        }
    }

    handleKeyDown = (event) => {
        if(event.repeat) {
            return;
        }
    
        const key = event.key;
        const updatedPressedKeys = [...this.state.pressedKeys];
        if (!updatedPressedKeys.includes(key) && VALID_KEYS.includes(key)) {
            updatedPressedKeys.push(key);
        }
        this.setState({
            pressedKeys: updatedPressedKeys,
        })
        this.playNote(KEY_TO_NOTE[key]);
        
    }

    handleKeyUp = (event) => {
        const key = event.key;
        const updatedKeys = [...this.state.pressedKeys];
        if(updatedKeys.includes(key)){
            updatedKeys.splice(key);
        }
        
        this.setState({
            pressedKeys: updatedKeys
        })
    }

    
    

    render(){
        const audioFiles = _.map(NOTES, (note, index) => {
            <audio 
                id={note}
                key={index}
                src={window.location.origin + `/pianoNotes/${note}.mp3`}
            />
        })

        const keys = NOTES.map((note, index) => {
            return (
                <Key 
                    key={index}
                    note={note}
                    pressedKeys={this.state.pressedKeys}
                />
            )
        })

        const soundTest = () => {
            try {
                let audio = new Audio(window.location.origin + '/assets/b.mp3');
                audio.play();
                console.log('play audio');
            } catch (error) {
                console.log("failed to play sound: " + error);
            }

        }
        

        return(
            <div>
                <button onClick={soundTest}>play sound</button>
                <div className="piano">
                    {keys}
                </div>
                <div>
                    {audioFiles}
                </div>
            </div>
            
        )
    }
}

export default Piano;