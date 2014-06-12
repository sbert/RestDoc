package com.manpower.restdoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_RESOURCE_PATTERNS;
import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_RESOURCE_LOCATION;
import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_VIEW_RESOLVER_PREFIX;
import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.WEB_JAR_VIEW_RESOLVER_SUFFIX;

/**
 * Created by sbert on 11/06/2014.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mangofactory.swagger.configuration", "com.manpower.restdoc"})
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(WEB_JAR_RESOURCE_PATTERNS)
                .addResourceLocations(WEB_JAR_RESOURCE_LOCATION).setCachePeriod(0);
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(WEB_JAR_VIEW_RESOLVER_PREFIX);
        resolver.setSuffix(WEB_JAR_VIEW_RESOLVER_SUFFIX);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }



}
