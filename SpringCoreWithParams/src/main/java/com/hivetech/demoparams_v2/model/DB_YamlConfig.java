package com.hivetech.demoparams_v2.model;

import org.springframework.beans.factory.annotation.Value;

public class DB_YamlConfig {
    private String description;
    private String url;
    private String user;
    private String pw;
    private String driver;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DB_YamlConfig{" +
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pw='" + pw + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
