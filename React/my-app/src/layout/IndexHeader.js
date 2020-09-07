import React, {Fragment} from "react";
import {Col, Layout, Menu, Row} from "antd";
import {Link, withRouter} from "react-router-dom";
import IndexHeaderRouterConfig from "../router/IndexHeaderRouterConfig";

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

                            <Menu theme="dark" mode="horizontal">
                                {/*<SubMenu key="sub1" icon={<UserOutlined/>} title="用户">*/}
                                {/*    <Menu.Item key="1">设置</Menu.Item>*/}
                                {/*    <Menu.Item key="2">空间</Menu.Item>*/}
                                {/*    <Menu.Item key="3">消息</Menu.Item>*/}
                                {/*    <Menu.Item onClick={this.toIndex} key="4">注销</Menu.Item>*/}
                                {/*    <Menu.Item onClick={this.toIndex} key="5">退出</Menu.Item>*/}
                                {/*</SubMenu>*/}
                                {/*<Menu.Item key="1">欢迎</Menu.Item>*/}
                                {/*<Menu.Item key="2">系统介绍</Menu.Item>*/}

                                {
                                    IndexHeaderRouterConfig && IndexHeaderRouterConfig.map((item) => {
                                        return item.child && item.child.length > 0 ? this.renderSubMenu(item) : this.renderMenu(item);
                                    })
                                }
                            </Menu>
                        </Col>
                    </Row>
                </Header>
            </Fragment>
        );
    }

    toIndex = () => {
        this.props.history.push("/");
    }

    /**
     * 处理嵌套菜单
     * @param title
     * @param key
     * @param child
     * @param icon
     * @returns {JSX.Element}
     */
    renderSubMenu = ({title, key, child, icon}) => {
        return (
            <SubMenu key={key} icon={icon && icon.render()} title={title}>
                {
                    child && child.map((item) => {
                        return item.child && item.child.length > 0 ? this.renderSubMenu(item) : this.renderMenu(item);
                    })
                }
            </SubMenu>
        );
    }

    /**
     * 处理单层菜单
     * @param title
     * @param key
     * @param icon
     * @returns {JSX.Element}
     */
    renderMenu = ({title, key, icon}) => {
        return (
            <Menu.Item key={key} icon={icon && icon.render()}>
                <Link to={key}><span>{title}</span></Link>
            </Menu.Item>)
    }

}

export default withRouter(IndexHeader);
