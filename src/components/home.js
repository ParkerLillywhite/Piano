import React, { Component } from 'react';
import { useHistory } from 'react-router-dom';
import { Header }from './layout/header';
import { Layout } from './layout';
import { Piano } from './piano';

export default class Home extends Component {
  render() {

    return (
      <Layout>
        <div className='app'>
          <h1>homepage garbage</h1>
          <h2>under construction</h2>
          <Piano />
        </div>
      </Layout>
    );
  }
}
