import React, { Component } from "react";
import { connect } from 'react-redux';

import * as actions from '../.././actions'

class RecentPosts extends Component {

    componentWillMount(){
        this.props.fetchRecentPosts();
    }
    render(){
        return(
            <div className="resultsContainer">
                <div className="recentPostsHeading"></div>
                <ul className="resultsList">
                    <li>nonsense</li>
                    <li>nonsense</li>
                    <li>nonsense</li>
                </ul>
            </div>
        )
    }
}
export default connect(null, actions)(RecentPosts);