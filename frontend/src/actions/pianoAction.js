import { PIANO, MARIMBA, GUITAR } from '../actions/actionTypes/pianoTypes';

const piano = () => {
    return {
        type: "PIANO",
    }
}

const marimba = () => {
    return {
        type: "MARIMBA",
    }
}

const guitar = () => {
    return {
        type: "GUITAR",
    }
}

export { piano, marimba, guitar };