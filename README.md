## SSM上手之书评网站
本项目基于java SSM框架进行搭建，目的在于熟悉Spring MVC的xml配置
主要应用到的组件有MySQL8.0 junit4.12 logback 1.2.3 MyBatis 3.5.1 FreeMarker  2.3.31

### 项目重点及实现步骤
1. 各个新版本组件在xml的配置
2. 应用freemarker进行前后端混合开发
3. MyBatisPlus分页插件使用
4. ajax art-template 动态加载图书信息
5. 分页查询，多条件动态查询
6. 实现图书基本信息/短评
7. 多表查询处理（二次查询）
8. Kaptcha生成验证码
9. 用户注册 md5加密
10. 统一异常处理，统一请求返回
11. 用户登陆过滤器，ThreadLocal保存session的用户信息
12. 书本详情页面新增用户阅读状态、点赞、短评功能

一些问题，写给自己：
1. 处理单个用户对评价的点赞 限制次数，保存点赞内容，可以改进存入数据库
2. 项目中对日期的处理使用LocalDateTime更推荐，Date过时了
3. entity类中嵌套对象二次查询效率很低，建议改为表链接