package com.ygbc.brain.business.management.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.ygbc.brain.business.management.web.controller")).build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("组网式脑图分析管理系统-业务数据接口文档").description("").termsOfServiceUrl("http://localhost:8080/earn-business-mamagement-web/").version("1.0").build();
    }
}