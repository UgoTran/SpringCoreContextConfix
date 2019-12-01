package com.hivetech.demoparams_v2;

import com.hivetech.demoparams_v2.connectionutils.Connection_Utils;
import com.hivetech.demoparams_v2.model.DB_YamlConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class AppRunner {

    private static final Logger LOGGER = Logger.getLogger(AppRunner.class.getName());

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }

    private static void context_1() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("db-config-v2");
        DB_YamlConfig dbConfig = (DB_YamlConfig) context.getBean("dbYamlConfigBean");
        Connection_Utils connect = context.getBean(Connection_Utils.class);

        LOGGER.info(dbConfig.toString());
        LOGGER.info(connect.getCustomer());
    }

    public static void main(String[] args) {
        context_1();
    }
}
