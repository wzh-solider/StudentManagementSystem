# 学生管理系统项目

使用的技术：
 - Servlet
 - Tomcat-11.0.0
 - mybatis-3.5.13
 - maven-3.9.3

## 开发日志

### 第一天

搭建整体架构，注入依赖
1. mybatis
2. mysql
3. tomcat-servlet
4. logback
5. junit

开发登录、注册页面

### 第二天

开发登录注册的模块开发
- 用户登录验证
- 用户注册
  - 注册成功，可以直接登录

### 第三天

登录成功页面，显示学生列表

### 第四天

- 查询页面（按照学生姓名）
- 删除
  - 用户在列表中选定，需要删除的学生信息
  - 后端执行删除功能（通过id唯一标识学生的属性）
- 增加页面

### 第五天 ==> 初步优化项目
- 添加学生时，新增参数校验
- 进行数据操作时，出现问题，进行事务回滚
- 使用模板方法设计模式，解决Servlet类爆炸问题
  - StudentServlet
  - UserServlet
- 对请求路径进行拦截（只有用户登录之后，才可以访问数据）
  - 使用Filter过滤器规则
    - 获取一个会话对象，将登录信息储存到会话对象中
      如果会话对象为null，则跳转到登录界面


