package com.co.gestortareasms.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase que agrupa configuración web del proyecto
 *
 * @since 1.0.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  @Value("${cors.pathPattern}")
  private String pathPattern;

  @Value("${cors.allowedOrigins}")
  private String allowedOrigins;

  @Value("${cors.allowedMethods}")
  private String allowedMethods;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping(pathPattern).allowedOrigins(allowedOrigins).allowedMethods(allowedMethods);
  }
}
