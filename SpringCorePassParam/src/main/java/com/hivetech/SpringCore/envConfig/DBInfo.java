package com.hivetech.SpringCore.envConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource(value = {"classpath:envDB.properties"})
public class DBInfo {

//    @Value("${db.url}")
    private String url;
    private String port;
    private String userName;
    private String passWord;

    @Value("#{environment.DB_URL}")
    public void setUrl(String url) {
        this.url = url;
    }

    @Value("#{environment.DB_PORT}")
    public void setPort(String port) {
        this.port = port;
    }

    @Value("#{environment.DB_USER}")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Value("#{environment.DB_PASS}")
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "DBInfo{" + '\n' +
                "url=" + url + "," + '\n' +
                "port=" + port + "," + '\n' +
                "userName=" + userName + "," + '\n' +
                "passWord=" + passWord + '\n' +
                '}';
    }
}
