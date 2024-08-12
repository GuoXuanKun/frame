package com.gmgx.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建一个配置类（将一些相关配置配进来，和xml配置bean 相似的，这里采取的是配置类的方式
 * SpringBoot基本上是用配置类的方式实现（Springboot applicationContext.xml）
 *
 * ）
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket myDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("学生管理系统[Api接口文档]") // 标题
                .description("") // 描述
                .contact(new Contact("", "", "")) // 联系方式
                .version("1.0") // 版本号
                .build();
        docket.apiInfo(apiInfo);
        //设置只生成被Api这个注解注解过的Ctrl类中有ApiOperation注解的api接口的文档
        docket.select().apis(RequestHandlerSelectors.basePackage("com.gmgx.controller")).build();
        return docket;
    }

}
