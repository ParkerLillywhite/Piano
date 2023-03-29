import { PIANO, MARIMBA, GUITAR } from '../actions/actionTypes/pianoTypes';

const initialState = {
    instrument: PIANO,
}

const instrumentReducer = (state = initialState, action) => {
    switch(action.type){
        case 'PIANO':
            return {
                ...state,
                instrument: state.instrument = PIANO,
            };
        case 'MARIMBA':
            return {
                ...state,
                instrument: state.instrument = MARIMBA,
            };
        case 'GUITAR':
            return {
                ...state,
                instrument: state.instrument = GUITAR,
            }
        default:
            return state;
    }
}

export default instrumentReducer;