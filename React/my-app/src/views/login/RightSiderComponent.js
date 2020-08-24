// css
import './../../styles/layout.scss'

import React from "react";
// ant design
import {Layout} from 'antd';
// 布局
const {Sider} = Layout;

class RightSiderCompnent extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state={};
    }

    render() {
        return (
            <Sider className='right-sider-css' />
        )
    }
}

export default RightSiderCompnent;
