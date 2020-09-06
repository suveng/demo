import React from 'react';
// 引入路由
import {HashRouter, Route, Switch} from 'react-router-dom'
import LoginIndex from "./views/login/LoginIndex";
import {Provider} from "react-redux";
import {createStore} from "redux";
import RootReducer from "./redux/reducer/RootReducer";
import Index from "./views/modules/Index";

let store = createStore(RootReducer)

store.subscribe(() => console.log(store.getState()));

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {

        return (
            <Provider store={store}>
                <HashRouter>
                    <Switch>
                        <Route component={LoginIndex} exact path="/"/>
                        <Route component={Index} path="/index"/>
                    </Switch>
                </HashRouter>
            </Provider>


        )
    }


}

export default App;
