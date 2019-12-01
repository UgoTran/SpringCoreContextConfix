package com.hivetech.demoparams_v2.context;

import com.hivetech.demoparams_v2.connectionutils.Connection_Utils;
import com.hivetech.demoparams_v2.model.DB_YamlConfig;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.logging.Logger;

@Configuration
public class SpringConfigurationContext {

    private static final Logger LOGGER = Logger.getLogger(SpringConfigurationContext.class.getName());

    @Bean
    public Connection_Utils createConnection(){
        return new Connection_Utils(createDbConfig());
    }

    @Bean
    public DB_YamlConfig createDbConfig(){
        return new DB_YamlConfig();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("mariadb_2.yml"));

        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());

        return propertySourcesPlaceholderConfigurer;
    }
}
