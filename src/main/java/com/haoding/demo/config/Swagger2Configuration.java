package com.haoding.demo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     *
     * @return
     */
    @Bean
    public Docket accessEntrust() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.haoding.demo.controller")) // 拦截的包路径
                .paths(PathSelectors.any())// 拦截的接口路径
                .build(); // 创建
        //.apiInfo(apiInfo()); // 配置说明
    }
    /*@Bean
    public Docket accessForumTopicBack() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("forumTopicBack")// 定义组
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.haoding.demo.controller")) // 拦截的包路径
                .paths(regex("/forumTopicBack/.*"))// 拦截的接口路径
                .build(); // 创建
        //.apiInfo(apiInfo()); // 配置说明
    }

    @Bean
    public Docket accessForumTopic() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("forumTopic")// 定义组
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.haoding.demo.controller")) // 拦截的包路径
                .paths(regex("/forumTopic/.*"))// 拦截的接口路径
                .build(); // 创建
        //.apiInfo(apiInfo()); // 配置说明
    }

    @Bean
    public Docket accessHistoryTrade() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("historyTrade")// 定义组
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.haoding.demo.controller")) // 拦截的包路径
                .paths(regex("/historyTrade/.*"))// 拦截的接口路径
                .build(); // 创建
        //.apiInfo(apiInfo()); // 配置说明
    }

    @Bean
    public Docket accessMain() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("main")// 定义组
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.haoding.demo.controller")) // 拦截的包路径
                .paths(regex("/main/.*"))// 拦截的接口路径
                .build(); // 创建
        //.apiInfo(apiInfo()); // 配置说明
    }
    @Bean
    public Docket accessUser() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("user")// 定义组
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.haoding.demo.controller")) // 拦截的包路径
                .paths(regex("/user/.*"))// 拦截的接口路径
                .build(); // 创建
        //.apiInfo(apiInfo()); // 配置说明
    }*/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("证劵交易系统的RESTful APIs")
                .description("本系统使用前后端分离的开发方式")
                .termsOfServiceUrl("http://www.xml626.cn")
                .version("1.0")
                .build();
    }
}
