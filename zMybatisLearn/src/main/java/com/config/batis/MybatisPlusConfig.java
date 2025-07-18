package com.config.batis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
        // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType

        /**
         * 分页拦截器的设置
         * @Configuration
         * public class MybatisPlusConfig {
         *     @Bean
         *     public PaginationInterceptor paginationInterceptor() {
         *         PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
         *         // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求
         *         // 默认false 为false时 会返回空数据
         *         paginationInterceptor.setOverflow(false);
         *         // 设置最大单页限制数量，默认 500 条，-1 不受限制
         *         // paginationInterceptor.setLimit(500);
         *         // 开启 count 的 join 优化,只针对部分 left join
         *         paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
         *         return paginationInterceptor;
         *     }
         *
         * }
         */

        return interceptor;
    }

    @Bean
    public SlowSqlInterceptor slowSqlInterceptor() {
        SlowSqlInterceptor slowSqlInterceptor = new SlowSqlInterceptor();
        return slowSqlInterceptor;
    }


}