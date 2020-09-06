import React, {Fragment} from "react";
import {Layout, Menu} from "antd";
import RouterConfig from "../router/RouterConfig";
import {Link} from "react-router-dom";

const {SubMenu} = Menu;
const {Sider} = Layout;


class IndexSider extends React.Component {


    constructor(props, context) {
        super(props, context);
        this.state = {}
    }

    render() {
        return (
            <Fragment>
                <Sider>

                    <Menu
                        mode="inline"
                        defaultSelectedKeys={['1']}
                        defaultOpenKeys={['sub1']}
                        style={{height: '100%', borderRight: 0}}
                    >
                        {
                            RouterConfig && RouterConfig.map((item) => {
                                return item.child && item.child.length > 0 ? this.renderSubMenu(item) : this.renderMenu(item);
                            })
                        }
                    </Menu>
                </Sider>
            </Fragment>
        );
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

export default IndexSider;
