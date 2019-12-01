package com.hivetech.demoparams_v1.context;

import com.hivetech.demoparams_v1.connectionutils.Connection_Utils;
import com.hivetech.demoparams_v1.model.DB_PropertiesConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationContext {

    @Bean
    public Connection_Utils createConnection(){
        return new Connection_Utils(createDbConfig());
    }

    @Bean
    public DB_PropertiesConfig createDbConfig(){
        return new DB_PropertiesConfig();
    }
}
