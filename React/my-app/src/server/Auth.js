// 登录授权
// class AuthServer extends React.Component{
//
//     constructor(props, context) {
//         super(props, context);
//         this.getToken = this.getToken();
//     }
//
//
// }
import Axios from "axios";
import querystring from "querystring";

// import React from "react";

export function getToken(username,password){
    let data = {
        grant_type:"password",
        username: username,
        password: password,
        scope:"app"
    };
    let key = "client";
    let secret = "secret";
    let basicAuth = Axios.create({
        timeout: 3000,
        timeoutErrorMessage: '请求超时',
        auth: {
            username: key,
            password: secret
        }
    });
    basicAuth.request({
        url: '/api/user/center/oauth/token',
        method: "POST",
        data: querystring.stringify(data) // 表单传参
    }).then(response => {
        console.log(response);
    })

}
