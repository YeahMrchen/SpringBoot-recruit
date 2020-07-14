# 人才招聘系统

## 项目预览

### 登录界面

<img src="images/login.png" style="zoom:60%" />

### 主页界面

![](images/index.png)

### 职位列表界面

![](images/list.png)

### 用户信息界面

![](images/userInfo.png)

### 联系我们

![](images/send.png)







## 关于项目

该网站是基于SpringBoot实现的企业招聘系统，应用于求职者投递简历，公司HR进行审核。

主要涉及技术包含Maven、Spring、SpringBoot、MyBatis、Redis等。

项目前端模板引擎使用Thymeleaf，数据源使用Druid。



## 使用注意

### 1、开发工具的选择

本项目使用 Intellij IDEA 2019.3.5 版本开发，若使用 Eclipse/MyEclipse导入项目，请注意文件编码为UTF-8，以避免乱码。

### 2、确保拥有Maven环境

项目使用 Maven 3.6.3 版本开发，请使用 3.3.9及以上环境进行导入。

### 3、MySQL版本注意事项

项目基于 MySQL 8.0.20 版本进行开发，若为MySQL 8.0 以前版本，请注意 Pom.xml 文件中数据库驱动版本，并修改 application.yml 文件中的 spring.datasource.url 属性，并注意时区的设定。

### 4、Tomcat配置

由于项目已部署至服务器，则 Tomcat 未使用 SpringBoot 自带版本。若使用本地 Tomcat  进行测试，请删去 Pom.xml 文件中对 Tomcat 的依赖，并添加 SpringBoot 内嵌的 Tomcat 依赖。

### 5、邮件设置

在application.properties中修改自己的邮件运营商的域名，登录邮件账户后开启SMAP协议，获得授权码，再进行配置。

### 6、其他细节

1、导入项目后修改 application.yml 文件中关于数据库的配置信息，以及 Redis 的相关配置。项目根目录下有数据库文件 web_recruit.sql 使用前导入至本地数据库中，并配置相关信息。

2、配置文件配置了项目根目录的名字，若在本地测试请访问：http://localhost:8080/recruit













