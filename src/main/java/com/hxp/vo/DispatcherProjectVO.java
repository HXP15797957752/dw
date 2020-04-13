package com.hxp.vo;

import java.util.Date;

/**
 * Created by hxp on 2020/4/2.
 */
public class DispatcherProjectVO {
    private int id;//logId
    private String departmentName;
    private String username;
    private String jobName;
    private String mainJar;
    private String dependencyJar;
    private String mainClass;
    private String jobParameter;
    private int finishedNotify;//0 为通知，1 为不通知
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMainJar() {
        return mainJar;
    }

    public void setMainJar(String mainJar) {
        this.mainJar = mainJar;
    }

    public String getDependencyJar() {
        return dependencyJar;
    }

    public void setDependencyJar(String dependencyJar) {
        this.dependencyJar = dependencyJar;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getJobParameter() {
        return jobParameter;
    }

    public void setJobParameter(String jobParameter) {
        this.jobParameter = jobParameter;
    }

    public int getFinishedNotify() {
        return finishedNotify;
    }

    public void setFinishedNotify(int finishedNotify) {
        this.finishedNotify = finishedNotify;
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
        return "DispatcherProjectVO{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", username='" + username + '\'' +
                ", jobName='" + jobName + '\'' +
                ", mainJar='" + mainJar + '\'' +
                ", dependencyJar='" + dependencyJar + '\'' +
                ", mainClass='" + mainClass + '\'' +
                ", jobParameter='" + jobParameter + '\'' +
                ", finishedNotify=" + finishedNotify +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
