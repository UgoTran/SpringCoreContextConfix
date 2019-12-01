package com.hivetech.demoparams_v1.connectionutils;

import com.hivetech.demoparams_v1.model.Customer;
import com.hivetech.demoparams_v1.model.DB_PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Connection_Utils {

    private static final Logger LOGGER = Logger.getLogger(Connection_Utils.class.getName());

    private static DB_PropertiesConfig dbPropertiesConfig;
    private static Connection connection;

    @Autowired
    public Connection_Utils(DB_PropertiesConfig dbPropertiesConfig) {
        this.dbPropertiesConfig = dbPropertiesConfig;
        connection = getConnection();
    }

    public static Connection getConnection() {
        try {
            Class.forName(dbPropertiesConfig.getDriver());
            connection = DriverManager.getConnection(dbPropertiesConfig.getUrl(), dbPropertiesConfig.getUser(), dbPropertiesConfig.getPw());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public String getCustomer(){
        Customer customer = new Customer();

        if (connection != null) {

            try{
                Statement statement = connection.createStatement();

                String sql = "SELECT * FROM customers";

                // Execute SQL statement returns a ResultSet object.
                ResultSet rs = statement.executeQuery(sql);

                rs.next();
                customer.setCustomerNumber(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));
                customer.setContactLastName(rs.getString(3));
                customer.setContactFirstName(rs.getString(4));
                customer.setPhone(rs.getString(5));
                customer.setAddressLine1(rs.getString(6));
                customer.setAddressLine2(rs.getString(7));
                customer.setCity(rs.getString(8));
                customer.setState(rs.getString(9));
                customer.setPostalCode(rs.getString(10));
                customer.setCity(rs.getString(11));
            }catch (SQLException e){
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        }

        return customer.toString();
    }
}
