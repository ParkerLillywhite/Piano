import React, { Component } from 'react';

import SearchBar from './species_finder/SearchBar';
import Header from './Header';

export default class App extends Component {
  render() {
    return (
      <div className='app'>
        <div>header class here</div>
        <h1>DevCamp React Starter</h1>
        <h2>React Redux Router</h2>
        <div>
          <SearchBar />
        </div>
      </div>
    );
  }
}
