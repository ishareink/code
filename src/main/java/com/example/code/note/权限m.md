# Spring Security

安全框架，特点：认证 授权，认证用户是否需要登录才能访问，授权用户是否有权限才能执行一些操作

特点：

1、和Spring无缝整合

2、全面的权限控制

3、里面做了分层抽取，分成了核心模块和Web模块，单独映入核心可以脱离Web环境

4、重量级，依赖严重

# Shiro 

Apache下的轻量级权限控制框架

缺点：Web某些情况需要定制代码

# 安全框架一般的组合

SSM+shiro

Springboot/cloud+Spring Security

# Spring Security原理

本质上是一个过滤器

FilterSecurityInterceptor：是一个方法级的权限过滤器，基本位于过滤器的最底层（放行前会查看token）

ExceptionTranslationFilter 是异常过滤器，用来处理在认证授权中抛出的异常

UsernamePasswordAuthenticationFilter：对/login的POST请求做拦截，校验表单中的用户名密码

两个重要接口

UserDetailService接口：查询数据库用户名和密码过程

* 创建类继承UsernamePasswordAuthenticationFilter，重写方法
* 创建类实现UserDetailService，编写查询数据过程，返回User对象，这个User对象是安全框架提供对象

PasswordEncoder

* 数据加密接口，用于返回User对象里面密码加密



# 微服务权限方案

单点登录+授权

基于Session

2、基于token



步骤

1、登录：查询登录用户权限列表

2、key：登录成功用户名 value：用户权限列表

3、根据用户信息生成token（jwt）

4、token放到cookie 在header放token值

5、从header获取token 从token获取用户名 从redis获取权限列表

6、由springsecurity给 当前用户赋予权限，可以进行相应操作

