package com.hivetech.demoparams_v1;

import com.hivetech.demoparams_v1.connectionutils.Connection_Utils;
import com.hivetech.demoparams_v1.model.DB_PropertiesConfig;
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
                = new ClassPathXmlApplicationContext("db-config.xml");
        DB_PropertiesConfig dbPropertiesConfig = (DB_PropertiesConfig) context.getBean("dbConfigBean");
        Connection_Utils connect = context.getBean(Connection_Utils.class);

        LOGGER.info(dbPropertiesConfig.toString());
        LOGGER.info(connect.getCustomer());
    }

    public static void main(String[] args) {
        context_1();
    }
}
