package com.hivetech.SpringCore.preConfig.annotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:db.properties"})
//@PropertySource(value = {"classpath:db.properties", "2ndDB.properties"})
//@PropertySources({
//        @PropertySource("classpath:db.properties"),
//        @PropertySource("classpath:2ndDB.properties")
//})
public class DBInfo {
    @Value("${db.url}")
    private String url;
    private String port;
    private String userName;
    private String passWord;

    //    @Value("${db.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${db.port}")
    public void setPort(String port) {
        this.port = port;
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
                "url='" + url + "," + '\n' +
                "port='" + port + "," + '\n' +
                "userName='" + userName + "," + '\n' +
                "passWord='" + passWord + '\n' +
                '}';
    }
}
