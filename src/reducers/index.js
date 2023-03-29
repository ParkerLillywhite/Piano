import { combineReducers } from 'redux';

import { reducer as form } from 'redux-form';
import  instrumentReducer  from './selectedInstrument';

const rootReducer = combineReducers({
  form,
  instrumentReducer
});

export default rootReducer;