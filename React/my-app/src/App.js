import React from 'react';
import './App.scss';

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
            <div class="testScss" >
                <h1 >hello</h1>
                <HashRouter>
                    <Switch>
                        <Route component={Home} exact path = "/"/>
                        <Route component={About} path = "/about"/>
                    </Switch>
                </HashRouter>
            </div>
            )
    }


}

export default App;
