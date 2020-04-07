package com.hxp.vo;

import java.util.Date;

/**
 * Created by hxp on 2020/3/25.
 */
public class DatabaseInfoVO {
    private int id;
    private String databaseDescription;
    private String ip;
    private int  port;
    private String username;
    private String password;
    private Date ctime;
    private Date mtime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatabaseDescription() {
        return databaseDescription;
    }

    public void setDatabaseDescription(String databaseDescription) {
        this.databaseDescription = databaseDescription;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        return "DatabaseInfoVO{" +
                "id=" + id +
                ", databaseDescription='" + databaseDescription + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
