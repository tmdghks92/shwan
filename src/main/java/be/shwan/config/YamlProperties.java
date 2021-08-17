package be.shwan.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@Getter
@Setter
@ConfigurationProperties
@PropertySources(value = {@PropertySource(value = "classpath:application.yml", ignoreResourceNotFound = true, factory = YamlPropertyFactory.class)
        , @PropertySource(value = "classpath:application-local.yml", ignoreResourceNotFound = true, factory = YamlPropertyFactory.class)
        , @PropertySource(value = "classpath:application-real.yml", ignoreResourceNotFound = true, factory = YamlPropertyFactory.class)})
public class YamlProperties {

}
