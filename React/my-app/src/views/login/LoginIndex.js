// css
import './../../styles/login.scss'

import React from 'react';
// ant design
import {Layout} from 'antd';
// 表单 icon
import HeaderCompnent from "../../layout/LoginHeader";
import LeftSiderCompnent from "../../layout/LoginLeftSider";
import CommonFooter from "../../layout/CommonFooter";
import Login from "./Login";


// 布局
const {Content} = Layout;


class LoginIndex extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
        this.form = {}
    }

    render() {
        return (
            <div>
                <Layout>
                    <LeftSiderCompnent/>
                    <Layout className="login-content">
                        <HeaderCompnent/>
                        <Content className='content-css'>
                            <Login/>
                        </Content>
                        <CommonFooter/>
                    </Layout>

                </Layout>


            </div>
        );
    }
}

export default LoginIndex;
