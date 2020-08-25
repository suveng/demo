// css
import './../../styles/login.scss'

import React from 'react';
// ant design
import {Layout} from 'antd';
// 表单 icon
import HeaderCompnent from "../layout/HeaderComponent";
import RightSiderCompnent from "../layout/RightSiderComponent";
import LeftSiderCompnent from "../layout/LeftSiderComponent";
import FooterCompnent from "../layout/FooterComponent";
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
                    <HeaderCompnent/>
                    <Layout>

                        <RightSiderCompnent/>
                        <Content className='content-css'>
                            <Login/>
                        </Content>

                        <LeftSiderCompnent/>
                    </Layout>

                    <FooterCompnent/>
                </Layout>


            </div>
        );
    }
}

export default LoginIndex;
