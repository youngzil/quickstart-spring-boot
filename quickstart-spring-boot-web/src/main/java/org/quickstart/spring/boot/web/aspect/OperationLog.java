/**
 * 项目名称：msgframe-core 
 * 文件名：OperationLog.java
 * 版本信息：
 * 日期：2018年5月18日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.aspect;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * OperationLog
 * 
 * @author：youngzil@163.com
 * @2018年5月18日 上午9:50:42
 * @since 1.0
 */
public class OperationLog {

    private String id;
    private String remoteHost;
    private String serverInfo;
    private String className;
    private String param;
    private String operUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operTime;

    private String exceptionInfo;
    private int costTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public int getCostTime() {
        return costTime;
    }

    public void setCostTime(int costTime) {
        this.costTime = costTime;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OperationLog [id=" + id + ", remoteHost=" + remoteHost + ", serverInfo=" + serverInfo + ", className=" + className + ", param=" + param + ", operUser=" + operUser + ", operTime="
                + operTime + ", exceptionInfo=" + exceptionInfo + ", costTime=" + costTime + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }

}
