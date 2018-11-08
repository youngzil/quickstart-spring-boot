首先需要建表：
create table account(
	id int,
	name nvarchar(10),
	money float
)
insert account values(1,'yunlingfly',1.2)
insert account values(2,'test',1.6)

输入http://127.0.0.1:8080/MavenSpringBoot/druid/login.html
输入账户：admin    密码：123456    这是在servlet里设置的，可修改与数据库管理员登录那个可以不一致

保持服务器运行再开一个页面输入http://127.0.0.1:8080/MavenSpringBoot/accService

再次查看druid：可以看到监控信息




附：常见问题处理：https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98



参考
https://blog.csdn.net/weixin_38187317/article/details/79556645
