package com.hivetech.SpringCore.preConfig.xmlConfig;

public class DBInfo {
    private String url;
    private String port;
    private String userName;
    private String passWord;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

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
