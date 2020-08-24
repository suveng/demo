import React, {Fragment} from "react";
import {Button, Col, Form, Input, Row, Spin, message} from "antd";
import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {getToken} from '../../server/Auth'

class Login extends React.Component {

    constructor() {
        super();
        this.state = {
            loading: false,
            finished: false
        };
    }

    onFinish = () => {
        console.log("finish")
        // this.setState({
        //     finished: true
        // })
    }
    onFinishFailed = () => {
        console.log("fail")
        // this.setState({
        //     finished: false
        // })
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

    login = () => {

        if (!this.state.finished){
            message.error('表单验证失败!');
            return;
        }

        let form = Form.useForm;
        console.log(form)

        getToken()


    }
    render() {
        return (
            <Fragment>
                <Form onFinish={this.onFinish()} onFinishFailed={this.onFinishFailed()}>
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
                                    }, {
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
                                        onClick={this.login}
                                    >
                                        登录
                                    </Button>
                                )}
                            </Form.Item>
                        </Col>
                        <Col span={6}> </Col>
                    </Row>
                    <Spin size={"large"} tip="Loading..." spinning={this.state.loading} style={{position: "fixed"}}/>


                </Form>
            </Fragment>
        );
    }


}

export default Login;
