import React from 'react';
// 引入路由
import {HashRouter, Route, Switch} from 'react-router-dom'
import LoginIndex from "./views/login/LoginIndex";

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {

        return (
            <HashRouter>
                <Switch>
                    <Route component={LoginIndex} exact path="/"/>
                </Switch>
            </HashRouter>

        )
    }


}

export default App;
