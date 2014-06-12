package com.manpower.restdoc.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sbert on 11/06/2014.
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin swaggerSpringMvcPlugin() {
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .swaggerGroup("controller-api")
                .includePatterns(
                        "/characters.*"
                )
                .apiInfo(apiInfo())
                .build();
    }

    /**
     * API Info as it appears on the swagger-ui page
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Movie Characters Api",
                "A sample api to test swagger with spring mvc",
                "http://en.wikipedia.org/wiki/Terms_of_service",
                "bertrand.rousseau@manpower.fr",
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html"
        );
        return apiInfo;
    }

}
