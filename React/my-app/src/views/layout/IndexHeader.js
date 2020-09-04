import React, {Fragment} from "react";
import {Col, Layout, Menu, Row} from "antd";


import {UserOutlined,} from '@ant-design/icons';
import {withRouter} from "react-router-dom";

const {Header} = Layout;
const {SubMenu} = Menu;

class IndexHeader extends React.Component {


    constructor(props, context) {
        super(props, context);
        this.state = {}
    }

    render() {
        return (
            <Fragment>
                <Header style={{padding: 0}}>
                    <Row style={{height: '100%'}}>
                        <Col style={{height: '100%'}}>

                            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                                <SubMenu key="sub1" icon={<UserOutlined/>} title="用户">
                                    <Menu.Item key="1">设置</Menu.Item>
                                    <Menu.Item key="2">空间</Menu.Item>
                                    <Menu.Item key="3">消息</Menu.Item>
                                    <Menu.Item onClick={this.toIndex} key="4">注销</Menu.Item>
                                    <Menu.Item onClick={this.toIndex} key="5">退出</Menu.Item>
                                </SubMenu>
                                <Menu.Item key="1">欢迎</Menu.Item>
                                <Menu.Item key="2">系统介绍</Menu.Item>
                            </Menu>
                        </Col>
                    </Row>
                </Header>
            </Fragment>
        );
    }

    toIndex= ()=>{
        this.props.history.push("/");
    }

}

export default withRouter(IndexHeader);
