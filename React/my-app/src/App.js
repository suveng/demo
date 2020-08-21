import React from 'react';
import './App.css';

// 引入路由
import {Switch, Route, HashRouter} from 'react-router-dom'
import Home from './views/Home'
import About from './views/About'

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {

        return (
            <HashRouter>
                <Switch>
                    <Route component={Home} exact path = "/"/>
                    <Route component={About} path = "/about"/>
                </Switch>
            </HashRouter>
        )
    }


}

export default App;
