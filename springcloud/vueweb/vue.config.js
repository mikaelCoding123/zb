const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        //端口
        port: 9999,
        proxy: {
            '/dev-api': {
                // target: 'http://192.100.140.4:28080/DztMain',
                // target: 'http://192.168.1.120:8082/',
                target: 'http://localhost:8082/',
                changeOrigin: true,
                rewrite: (p) => p.replace(/^\/dev-api/, '')
            },
            // '/dev-api': {
            //     target: 'http://192.100.140.4:28080/hscweb',
            //     changeOrigin: true,
            //     rewrite: (p) => p.replace(/^\/dev-api/, '')
            // },
            '/prod-api': {
                target: 'http://192.100.140.4:28080/hscweb',
                changeOrigin: true,
                rewrite: (p) => p.replace(/^\/prod-api/, '')
            },
            '/hscweb': {
                target: 'http://192.100.140.14:18003',
                changeOrigin: true
            },
            '/DzfpPt': {
                target: 'http://192.100.140.14:18003',
                changeOrigin: true
            }
        }


    }
})
