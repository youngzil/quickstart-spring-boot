/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：ResourceTest.java
 * 版本信息：
 * 日期：2018年9月11日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * ResourceTest
 * 
 * @author：youngzil@163.com
 * @2018年9月11日 下午9:25:38
 * @since 1.0
 */
public class ResourceTest {

    // 本文介绍两种较为通用的spring 资源访问方式
    // UrlResource：可以通过类似 http://, ftp://, file:// 这样的url协议来访问资源
    // 资源加载器：可以通过资源地址表达式来加载资源，支持ant风格，更加灵活

    @Test
    public void UrlResourceTest() throws Exception {
        // 访问http资源 这里访问的是百度首页的logo
        String path = "http://www.baidu.com/img/bdlogo.gif";
        // 访问资源
        Resource res = new UrlResource(path);
        // 使用apache commons的IOUtils将InputStream转换成byte数组
        byte[] gifByte = IOUtils.toByteArray(res.getInputStream());
        // 使用apache commons的FileUtils将byte数组写入文件
        FileUtils.writeByteArrayToFile(new File("D://bdlogo.gif"), gifByte);
        System.out.println("图片访问成功，已经下载到您设定的目录，请访问");
        System.out.println("=================================");

        // 访问本地资源，使用file://协议头,注意这里file:后是三个/
        path = "file:///D://cxyapi/show.txt";
        res = new UrlResource(path);
        System.out.println("文件内容：" + IOUtils.toString(res.getInputStream(), "GB2312"));
    }

    @Test
    public void ResourceLoaderTest() throws Exception {
        /* 资源地址表达式 
         * classpath:相对于类的根路径，可访问jar或zip中的资源哦 
         * classpath*:和上面类似，只不过上面是加载找到的第一个资源，这个是全部加载 
         * file:文件系统目录中加载，可以是绝对，也可以是相对 
         * http:// 不用多说了吧 
         * ftp:// 不用多说了吧 
         *  
         * ant风格：可以使用通配符 
         *  ?:匹配一个字符 
         *  *:匹配多个字符 
         *  **:匹配多层路径 
         * */
        ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
        Resource[] rs = rpr.getResources("classpath:aop.xml");
        for (Resource one : rs) {
            showResourceInfo(one, true);
        }
        System.out.println("=============================");

        // file:访问文件系统（绝对 和 相对路径方式）
        // 绝对路径 类似于FileSystemResource
        rs = rpr.getResources("file:/D:/cxyapi/show.txt");
        // 相对路径 相对于当前项目路径
        // rs=rpr.getResources("file:src/aop.xml");
        for (Resource one : rs) {
            showResourceInfo(one, true);
        }
        System.out.println("=============================");

        // http:方式
        rs = rpr.getResources("http://www.baidu.com/img/bdlogo.gif");
        // 为了测试的简便，这里直接取第一个资源
        byte[] gifByte = IOUtils.toByteArray(rs[0].getInputStream());
        FileUtils.writeByteArrayToFile(new File("D://bdlogo1.gif"), gifByte);
    }

    /**
     * 公共的现实文件信息方法
     * 
     * @param one spring resource对象
     * @param isShowContent 是否打印文件内容（非文本下不建议使用）
     */
    private void showResourceInfo(Resource one, boolean isShowContent) {
        try {
            System.out.println("文件名称:" + one.getFilename());
            System.out.println("是否存在:" + one.exists());
            if (isShowContent) {
                System.out.println("文件绝对路径:" + one.getFile().getAbsolutePath());
                System.out.println("文件内容:");
                System.out.println(IOUtils.toString(one.getInputStream(), "GB2312"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
