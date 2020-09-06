// css
import '../styles/layout.scss'

import React from "react";
// ant design
import {Layout} from 'antd';
// 布局
const {Footer} = Layout;

class CommonFooter extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state={};

    }

    render() {
        return (
            <Footer className='footer-css' style={{textAlign: "center"}}>
               First React APP  ©2020 Created by suveng
            </Footer>
        )
    }
}

export default CommonFooter;
