const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
    app.use(
        "^/dev",
        createProxyMiddleware({
            target: 'http://localhost:8080/hscwebbw',    //要访问的地址
            changeOrigin: true,
            pathRewrite: {'^/dev': ''}
        })
    );

};