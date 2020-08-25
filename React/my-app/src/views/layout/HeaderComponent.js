// css
import './../../styles/layout.scss'

import React from "react";
// ant design
import {Layout} from 'antd';
// 布局
const {Header} = Layout;

class HeaderCompnent extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state={};

    }

    render() {
        return (
            <Header className='header-css' />
        )
    }
}

export default HeaderCompnent;
