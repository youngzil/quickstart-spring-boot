/**
 * 项目名称：msgframe-core 
 * 文件名：IPassResponseData.java
 * 版本信息：
 * 日期：2018年7月10日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.http;

/**
 * IPassResponseData
 * 
 * @author：youngzil@163.com
 * @2018年7月10日 上午11:04:50
 * @since 1.0
 */
public class IPassResponseData {

    private String code = "200";

    private String message = "success";

    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IPassResponseData [code=" + code + ", message=" + message + ", data=" + data + "]";
    }

}
