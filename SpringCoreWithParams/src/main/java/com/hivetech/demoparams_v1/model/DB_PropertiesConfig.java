package com.hivetech.demoparams_v1.model;

public class DB_PropertiesConfig {
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

    @Override
    public String toString() {
        return "DB_PropertiesConfig{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pw='" + pw + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
