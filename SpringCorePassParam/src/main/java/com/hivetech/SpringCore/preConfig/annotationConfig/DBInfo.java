package com.hivetech.SpringCore.preConfig.annotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:db.properties"})
//@PropertySource(value = {"classpath:db.properties", "2ndDB.properties"})
//@PropertySources({
//        @PropertySource("classpath:db.properties"),
//        @PropertySource("classpath:2ndDB.properties")
//})
public class DBInfo {
    @Value("${db.anotherUrl}")
    private String anotherUrl;
    private String anotherPort;
    private String userName;
    private String passWord;

    //    @Value("${db.url}")
    public void setAnotherUrl(String anotherUrl) {
        this.anotherUrl = anotherUrl;
    }

    @Value("${db.anotherPort}")
    public void setAnotherPort(String anotherPort) {
        this.anotherPort = anotherPort;
    }

    @Value("${db.username}")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Value("${db.password}")
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "DBInfo{" + '\n' +
                "url='" + anotherUrl + "," + '\n' +
                "port='" + anotherPort + "," + '\n' +
                "userName='" + userName + "," + '\n' +
                "passWord='" + passWord + '\n' +
                '}';
    }
}
