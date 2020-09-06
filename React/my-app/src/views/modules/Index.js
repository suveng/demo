import React, {Fragment} from "react";

import {Layout} from 'antd';
import CommonFooter from "../../layout/CommonFooter";
import IndexHeader from "../../layout/IndexHeader";
import IndexSider from "../../layout/IndexSider";
import ContentRouter from "../../router/ContentRouter";


const {Content} = Layout;

class Index extends React.Component {


    constructor(props, context) {
        super(props, context);
        this.state = {}
    }

    render() {
        return (
            <Fragment>
                <Layout className="full-screen">
                    <IndexSider/>
                    <Layout>
                        <IndexHeader/>
                        <Content>
                            <ContentRouter/>
                        </Content>
                        <CommonFooter/>
                    </Layout>
                </Layout>
            </Fragment>
        );
    }
}

export default Index;
