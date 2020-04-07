package com.hxp.vo;

import java.util.List;

/**
 * Created by hxp on 2020/3/23.
 */
public class ProjectInfoVO {
    private Long  projectId;
    private Integer projectStatus;
    private String projectName;
    private String description;

    private Integer excuteType;//0 手动调度 1 周期调度

    private String dirPath;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExcuteType() {
        return excuteType;
    }

    public void setExcuteType(Integer excuteType) {
        this.excuteType = excuteType;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    @Override
    public String toString() {
        return "ProjectInfoVO{" +
                "projectId=" + projectId +
                ", projectStatus=" + projectStatus +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", excuteType=" + excuteType +
                ", dirPath='" + dirPath + '\'' +
                '}';
    }
}
