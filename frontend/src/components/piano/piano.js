import React from "react";
import Key from './key';
import { KEY_TO_NOTE, NOTES, VALID_KEYS } from '../../constants/piano/notes';
import { DropDown, DropDownMenu } from '../dropDown';
import { connect } from 'react-redux';
import DropDownCaret from '../../../static/assets/svg/drop.svg';

import './piano.css';
import _ from "lodash";


class Piano extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pressedKeys: [],
            
        };
    }
    
    componentDidMount = () => {
        window.addEventListener('keydown', this.handleKeyDown);
        window.addEventListener('keyup', this.handleKeyUp);
    }

    playNote = (note) => {
        const  { instrument } = this.props;
        if(!_.isEmpty(note)) {
            const noteAudio = new Audio(window.location.origin + '/assets/' + this.changeInstrumentToNoteType(instrument) + '/' + note + '.mp3');
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

    changeInstrumentToNoteType = (instrument) => {
        switch(instrument){
            case 'Piano':
                return 'pianoNotes';
            case 'Marimba': 
                return 'marimbaNotes';
            case 'Guitar':
                return 'guitarNotes';
        }
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

    
        return(
            <div className="piano-container">
                <div className="options-bar">
                    <DropDown />
                </div>
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

function mapStateToProps(state) {
    const instrument = state.instruments.instrument;
    return {instrument};
}

export default connect(mapStateToProps)(Piano);