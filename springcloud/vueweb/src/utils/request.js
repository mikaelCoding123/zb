import axios from "axios";

import {Toast, Dialog} from 'vant';

import store from "@/store";
import errorCode from "@/utils/const/errorCode";
import {tansParams} from "@/utils/tools";
import {getToken} from "@/utils/auth";


axios.defaults.headers["Content-Type"] = "application/json;charset=utf-8";
axios.defaults.withCredentials = true;


const showLoading = (zhi) => {
    /*Toast.loading({
        duration: 0, // 持续展示 toast
        forbidClick: true,
        // message: "加载中..."
    })*/
};
// 创建axios实例
const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: import.meta.env.VITE_APP_BASE_API,
    // 超时
    timeout: 60000,
    withCredentials: true,
});

// request拦截器
service.interceptors.request.use(
    (config) => {
        // 是否需要设置 token
        const isToken = (config.headers || {}).isToken === false
        if (getToken() && !isToken) {
            // 让每个请求携带自定义token
            config.headers['Token'] = getToken();
        }

        // get请求映射params参数
        if (config.method === "get" && config.params) {
            let url = config.url + "?" + tansParams(config.params);
            url = url.slice(0, -1);
            config.params = {};
            config.url = url;
        }
        if (config.isShowLoad) {
            // showLoading()
        }
        return config;
    },
    (error) => {
        console.log(error);
        Promise.reject(error);
    }
);

// 响应拦截器
service.interceptors.response.use(
    (res) => {
        // console.log(res.data)
        Toast.clear()//清除加载效果
        if (res.request.responseURL.indexOf('sjx.json') !== -1) {
            return res.data;
        }

        // 返回结果集
        const code = res.data.resultCode
        // 返回结果信息code
        const msg = res.data.resultMsg || errorCode[code] || errorCode["default"]
        if (res.request.responseType === "blob" ||
            res.request.responseType === "arraybuffer") {
            // 如果请求二进制数据则直接返回
            return res.data;
        } else if ("000000" === res.data.resultCode) {
            return res.data;
        } else if ("403" === res.data.resultCode) {
            // Dialog.confirm({
            //     title: '温馨提示',
            //     message:
            //         '登录信息获取失败，请重新登录',
            // }).then(() => {
            //     store.dispatch('LogOut').then(() => {
            //         window.location = window.location.origin + '/login'
            //     })
            // }).catch(() => {
            //     store.dispatch('LogOut').then(() => {
            //         window.location = window.location.origin + '/'
            //     })
            // });
            return Promise.reject(res.data);
        } else {
            // console.log(msg)
            Dialog.alert({
                message: msg,
            }).then(() => {});
            // Toast.fail({
            //     message: msg
            // });
            return Promise.reject(new Error(msg));
        }
    },
    (error) => {
        Toast.clear()//清除加载效果
        console.log(error)
        if ("403" === error.response.data.resultCode) {
            Dialog.confirm({
                title: '温馨提示',
                message:
                    '登录信息获取失败，请重新登录',
            }).then(() => {
                store.dispatch('LogOut').then(() => {
                    window.location = window.location.origin + '/login'
                })
            }).catch(() => {
                store.dispatch('LogOut').then(() => {
                    window.location = window.location.origin + '/'
                })
            });
            return Promise.reject(error);
        }
        let {message} = error;
        if (message === "Network Error") {
            message = "后端接口连接异常";
        } else if (message.includes("timeout")) {
            message = "系统接口请求超时";
        } else if (message.includes("Request failed with status code")) {
            message = "系统接口" + message.substr(message.length - 3) + "异常";
        }
        Toast.fail({
            message: message
        })
        return Promise.reject(error);
    }
);

export function getImgData(url, data) {
    return service({
        responseType: "arraybuffer",
        url,
        method: "post",
        data,
    }).then(function (res) {
        return res;
    });
}

export function postData(url, data) {
    return service({
        url,
        method: "post",
        data,
    }).then(function (res) {
        return res.resultObj;
    });
}

export function getData(url, data) {
    return service({
        url,
        method: "get",
        data,
    }).then(function (res) {
        return res.resultObj;
    });
}

export function postRes(url, data) {
    return service({
        url,
        method: "post",
        data,
    }).then(function (res) {
        console.log(res);
        return res;
    });
}

export default service;
