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
          <Piano />
        </div>
      </Layout>
    );
  }
}
