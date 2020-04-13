package com.hxp.vo;

import java.util.Date;

/**
 * Created by hxp on 2020/4/13.
 */
public class IntegrationTaskVO {
    private int  id;
    private String username;
    private String  taskName;
    private String dataSourceDescription;
    private String departmentName;
    private String projectName;
    private String serveName;
    private String ip;
    private int port;
    private String databaseName;
    private String tableName;
    private Boolean hasSubTable;
    private Boolean isCreateHiveTable;
    private String syncStrategy;
    private Date ctime;
    private Date mtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDataSourceDescription() {
        return dataSourceDescription;
    }

    public void setDataSourceDescription(String dataSourceDescription) {
        this.dataSourceDescription = dataSourceDescription;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getServeName() {
        return serveName;
    }

    public void setServeName(String serveName) {
        this.serveName = serveName;
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

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Boolean getHasSubTable() {
        return hasSubTable;
    }

    public void setHasSubTable(Boolean hasSubTable) {
        this.hasSubTable = hasSubTable;
    }

    public Boolean getCreateHiveTable() {
        return isCreateHiveTable;
    }

    public void setCreateHiveTable(Boolean createHiveTable) {
        isCreateHiveTable = createHiveTable;
    }

    public String getSyncStrategy() {
        return syncStrategy;
    }

    public void setSyncStrategy(String syncStrategy) {
        this.syncStrategy = syncStrategy;
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
        return "IntegrationTaskVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", taskName='" + taskName + '\'' +
                ", dataSourceDescription='" + dataSourceDescription + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", serveName='" + serveName + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", databaseName='" + databaseName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", hasSubTable=" + hasSubTable +
                ", isCreateHiveTable=" + isCreateHiveTable +
                ", syncStrategy='" + syncStrategy + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
