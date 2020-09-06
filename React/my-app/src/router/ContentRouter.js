import React from 'react';
// 引入路由
import {Route, Switch} from 'react-router-dom'
import AutoConfigRouter from "./AutoConfigRouter";


class ContentRouter extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {

        return (
            <Switch>
                {
                    AutoConfigRouter.map((item) => {
                        return <Route key={item.path} component={item.component} exact path={item.path}/>;
                    })
                }
            </Switch>
        )
    }


}

export default ContentRouter;
