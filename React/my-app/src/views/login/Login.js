import React, {Fragment} from "react";
import {Button, Col, Form, Input, message, Row} from "antd";
import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {getToken} from '../../server/Auth'
import  '../../styles/login.scss'


class Login extends React.Component {

    constructor() {
        super();
        this.state = {
            // 页面加载
            loading: false,
            // 用户名
            username: "",
            // 密码
            password: "",
            // 防重点击
            buttonDisabled: false
        };
    }
    render() {
        return (
            <Fragment>
                <Form onFinish={this.onFinish()} onFinishFailed={this.onFinishFailed()}>
                    <Row>
                        <Col span={6}> </Col>
                        <Col span={10}>
                            <h1 className="normal-head">登录</h1>
                        </Col>
                        <Col span={6}> </Col>
                    </Row>
                    <Row>
                        <Col span={6}> </Col>
                        <Col span={10}>
                            <Form.Item
                                name="username"
                                rules={[
                                    {
                                        required: true,
                                        message: '用户名不能为空',
                                    },
                                ]}
                            >
                                <Input
                                    onChange={(e) => {
                                        this.setState({
                                            username: e.target.value
                                        })
                                    }}
                                    prefix={<UserOutlined className="site-form-item-icon"/>}
                                    placeholder="用户名"/>

                            </Form.Item>
                        </Col>
                        <Col span={6}> </Col>
                    </Row>

                    <Row>
                        <Col span={6}> </Col>
                        <Col span={10}>
                            <Form.Item
                                name="password"
                                rules={[
                                    {
                                        required: true,
                                        message: '密码不能为空',
                                    }, {
                                        validator: this.newValidate
                                    }
                                ]}
                            >
                                <Input
                                    onChange={(e) => {
                                        this.setState({
                                            password: e.target.value
                                        })
                                    }}
                                    prefix={<LockOutlined className="site-form-item-icon"/>}
                                    type="password"
                                    placeholder="密码"
                                />
                            </Form.Item>
                        </Col>
                        <Col span={6}> </Col>
                    </Row>

                    <Row>
                        <Col span={6}> </Col>
                        <Col span={10}>
                            <Form.Item shouldUpdate>
                                {() => (
                                    <Button
                                        block={true}
                                        disabled={this.state.buttonDisabled}
                                        type="primary"
                                        htmlType="submit"
                                        onClick={this.login}
                                    >
                                        登录
                                    </Button>
                                )}
                            </Form.Item>
                        </Col>
                        <Col span={6}> </Col>
                    </Row>
                </Form>
            </Fragment>
        );
    }
    onFinish = () => {
    }
    onFinishFailed = () => {
    }

    newValidate = (rule, val) => {
        if (!val) {
            return Promise.reject("err");
        }
        let validateResult = "err";  // 自定义规则
        if (!validateResult) {
            return Promise.reject('请输入正确的内容！');
        }
        return Promise.resolve();
    }

    login = (e) => {
        this.setState({
            buttonDisabled: true
        })
        let username = this.state.username;
        let password = this.state.password;
        if (!username || !password) {
            message.error("用户名和密码不为空")
            this.setState({
                buttonDisabled: false
            })
            return;
        }
        getToken(username, password).then((response) => {
            console.log("接口返回", response.data);
            let token = {
                "additionalInformation": {
                    "jti": ""
                },
                "expiration": 1,
                "expired": false,
                "expiresIn": 1,
                "refreshToken": {
                    "expiration": 1,
                    "value": ""
                },
                "scope": [
                    ""
                ],
                "tokenType": "",
                "value": ""
            };

            token = response.data;
            console.log(token)
        }).catch(exception => {
            console.log("服务异常", exception)
            message.error("服务开小差了...")
        }).finally(() => {
            this.setState({
                buttonDisabled: false
            })
        })

    }




}

export default Login;
