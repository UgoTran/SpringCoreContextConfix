package com.hivetech.servletjsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Connection_Utils {
    private static final Logger LOGGER = Logger.getLogger(Connection_Utils.class.getName());

    private static DB_YamlConfig dbConfig;
    private static Connection connection;

    private Connection_Utils() {    }

    public static Connection connect() {
        if (connection == null) {

            dbConfig = ParseYaml.parse();

            try {
                Class.forName(dbConfig.getDatabaseProperties().getDbDriver());
                connection = DriverManager.getConnection(
                        dbConfig.getDatabaseProperties().getDbUrl()
                        , dbConfig.getDatabaseProperties().getDbUser()
                        , dbConfig.getDatabaseProperties().getDbPw());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        LOGGER.info(dbConfig.toString());

        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
