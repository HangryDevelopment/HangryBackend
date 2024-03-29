// package hangrydevelopment.hangrybackend.config;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// // import springfox.documentation.builders.PathSelectors;
// // import springfox.documentation.builders.RequestHandlerSelectors;
// // import springfox.documentation.service.*;
// // import springfox.documentation.spi.DocumentationType;
// // import springfox.documentation.spi.service.contexts.SecurityContext;
// // import springfox.documentation.spring.web.plugins.Docket;

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// //
// https://medium.com/turkcell/swagger-with-spring-boot-and-security-cf8585dcf3b2
// //
// https://stackoverflow.com/questions/40241843/failed-to-start-bean-documentationpluginsbootstrapper-in-spring-data-rest

// @Configuration
// public class SwaggerConfig {
// public static final String AUTHORIZATION_HEADER = "Authorization";

// private ApiKey apiKey(){
// return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
// }

// private ApiInfo apiInfo(){
// return new ApiInfo(
// "Spring Boot Hangry REST APIs",
// "Spring Boot Hangry REST API Documentation",
// "1",
// "Terms of service",
// new Contact("Chase Forestello", "www.example.com",
// "chase.forestello@gmail.com"),
// "License of API",
// "API license URL",
// Collections.emptyList()
// );
// }

// @Bean
// public Docket api(){
// return new Docket(DocumentationType.SWAGGER_2)
// .apiInfo(apiInfo())
// .securityContexts(Arrays.asList(securityContext()))
// .securitySchemes(Arrays.asList(apiKey()))
// .select()
// .apis(RequestHandlerSelectors.any())
// .paths(PathSelectors.any())
// .build();
// }

// private SecurityContext securityContext(){
// return SecurityContext.builder().securityReferences(defaultAuth()).build();
// }

// private List<SecurityReference> defaultAuth(){
// AuthorizationScope authorizationScope = new AuthorizationScope("global",
// "accessEverything");
// AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
// authorizationScopes[0] = authorizationScope;
// return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
// }
// }
