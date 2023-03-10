import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import { createStore, applyMiddleware } from "redux";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./components/home";
import reducers from "./reducers";
import thunk from "redux-thunk";

const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);

import "./style/main.scss";
import { SpeciesFinderLayout } from "./components/species_finder";

function main() {
  ReactDOM.render(
    <Provider store={createStoreWithMiddleware(reducers)}>
      <BrowserRouter>
        <Switch>
          <Route path='/' exact component={Home}/>
          <Route path='/search' component={SpeciesFinderLayout}/>
        </Switch>
      </BrowserRouter>
    </Provider>,
    document.querySelector(".app-wrapper")
  );
}

document.addEventListener("DOMContentLoaded", main);
