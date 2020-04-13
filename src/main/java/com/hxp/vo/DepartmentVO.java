package com.hxp.vo;

import java.util.Date;

/**
 * Created by hxp on 2020/4/13.
 */
public class DepartmentVO {
    private int id;
    private String departmentName;
    private String owner;
    private Date ctime;
    private Date mtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        return "DepartmentVO{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", owner='" + owner + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
