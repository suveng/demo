import React, {Fragment} from "react";
import {Button, Form, Input, Row, Col} from "antd";
import {LockOutlined, UserOutlined} from '@ant-design/icons';

class Login extends React.Component {

    constructor() {
        super();
        this.state = {};
    }

    onFinish = () => {
        console.log("finish");
    }

    newValidate = (rule, val, callback) => {
        if (!val) {
            callback();
        }
        let validateResult = "err";  // 自定义规则
        if (!validateResult) {
            callback('请输入正确的内容！');
        }
        callback();
    }

    render() {
        return (
            <Fragment>
                <Form onFinish={this.onFinish()}>
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
                                    },{
                                    validator: this.newValidate
                                    }
                                ]}
                            >
                                <Input
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
                                        type="primary"
                                        htmlType="submit"
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
}

export default Login;
