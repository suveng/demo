import Axios from "axios";

// 创建实例

const instance = Axios.create({
    timeout: 2000,
})

instance.interceptors.request.use(function (config) {

    //
    return config;
}, function (error) {

    return Promise.reject(error);
});


instance.interceptors.response.use(function (response) {

    return response;
}, function (error) {
    return Promise.reject(error);
})

export default instance;
