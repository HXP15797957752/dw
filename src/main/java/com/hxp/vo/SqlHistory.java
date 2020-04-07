package com.hxp.vo;

import java.util.Date;

/**
 * Created by hxp on 2020/4/2.
 */
public class SqlHistory {
    private Long id;
    private String sql;
    private String username;
    private int status;//0 成功 1 失败
    private Date ctime;
    private Date mtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return "SqlHistory{" +
                "id=" + id +
                ", sql='" + sql + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
