/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：HttpTest.java
 * 版本信息：
 * 日期：2018年7月10日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.http;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * HttpTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年7月10日 下午8:32:12
 * @since 1.0
 */
public class HttpTest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        };
        restTemplate.setErrorHandler(responseErrorHandler);

        /* 注意：必须 http、https……开头，不然报错，浏览器地址栏不加 http 之类不出错是因为浏览器自动帮你补全了 */
        HttpHeaders headers = new HttpHeaders();
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        // 设置参数
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        IPassLogin ipassLogin = new IPassLogin();
        HttpEntity<IPassLogin> requestEntity = new HttpEntity<IPassLogin>(ipassLogin, headers);
        /* body是Http消息体例如json串 */
        // 执行请求
        ResponseEntity<IPassResponseData> resp = restTemplate.exchange("https://www.baidu.com/", HttpMethod.POST, requestEntity, IPassResponseData.class);
        /*上面这句返回的是往 url发送 post请求 请求携带信息为entity时返回的结果信息
        String.class 是可以修改的，其实本质上就是在指定反序列化对象类型，这取决于你要怎么解析请求返回的参数*/

        // 获取返回的header
        List<String> val = resp.getHeaders().get("Set-Cookie");

        // 获得返回值
        IPassResponseData responseData = resp.getBody();
    }

}
