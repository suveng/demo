import React from 'react';
// 引入路由
import {Route, Switch} from 'react-router-dom'
import UserList from "../views/user/UserList";
import UserAdd from "../views/user/UserAdd";


class ContentRouter extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {

        return (
            <Switch>
                <Route component={UserList} exact path="/index/user/list"/>
                <Route component={UserAdd} exact path="/index/user/add"/>
            </Switch>
        )
    }


}

export default ContentRouter;
