package com.hxp.vo;

import java.util.Date;

/**
 * Created by hxp on 2020/4/13.
 */
public class ResourceVO {
    private int id;
    private String fileName;
    private String username;
    private Date ctime;
    private Date mtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "ResourceVO{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", username='" + username + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
