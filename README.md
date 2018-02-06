SSH
======================

项目描述
----------------------
    自己搭建的一个SSH框架

运行方式
-----------------------
```
 1. 下载项目压缩包
 2. 解压后，使用 myeclipse 或者 eclipse 打开
 3. 将项目添加到tomcat服务器中，并启动服务
 4. 打开浏览器访问 http://localhost:8080/ssh/login.jsp，进入登录页面
 5. 输入数据库的账号和密码登录
```

项目构建
-----------------------
```
1. 使用myeclipse创建一个web项目
2. 配置pom.xml、更新maven，加载项目所依赖的包
3. 前台建立如下文件：
    bootstrap、css、front、js、validation、index.jsp（入口文件）、login.jsp
   后台进行如下分层：
    action（接口层）、dao（数据库访问层）、domain（实体）、dto（对象）、interceptor（过滤层）、  
    mapping、service（业务层）、utils（工具类）
 4. 进行业务开发
```

心得体会
-----------------------
```
 1. 了解了ssh框架的大致工作原理
 2. 学会了maven的使用 
```
