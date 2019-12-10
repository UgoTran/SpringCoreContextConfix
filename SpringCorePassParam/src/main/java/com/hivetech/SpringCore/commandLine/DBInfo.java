package com.hivetech.SpringCore.commandLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

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

    @Autowired
    private Environment environment;

    public void getParam() {
        String url = environment.getProperty("db.url");
        String port = environment.getProperty("db.port");
        String user = environment.getProperty("db.username");
        String pass = environment.getProperty("db.password");
        System.out.println("the value of url: " + url);
        System.out.println("the value of port: " + port);
        System.out.println("the value of user: " + user);
        System.out.println("the value of pass: " + pass);
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
