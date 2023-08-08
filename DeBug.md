# 开发登录成功后，显示学生列表的jsp页面(successful.jsp)
- 学生列表，在刷新之后不会更新的bug
  > 原因：在对数据库进行操作之后，没有即时关闭SqlSession对象
  > 解决：在StudentService实现类中的StudentList方法中关闭连接