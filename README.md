# README


##代码库说明

```分支意义
feature分支：开发、测试
develop分支：校验、合并、单元测试覆盖
master分支：线上部署
```



## 工程说明

### 1.工程架构设计

```java
springcloud+springboot微服务分布式架构

MySQL持久化数据库

Redis缓存数据库

OAuth2认证机制

//todo: 待添加
```



### 2.工程模块

| 模块名   | 模块内容                           |      |      |
| -------- | ---------------------------------- | ---- | ---- |
| hy       | 父级工程                           |      |      |
| j-basics | 基础演示、问题验证                 |      |      |
| j-common | 工程公共依赖(常用工具类、公用参数) |      |      |
| j-server | Eureka服务注册中心                 |      |      |
|          |                                    |      |      |





## 参考资料

```微服务注册与发现
1.https://blog.csdn.net/qq1049545450/article/details/104834423?utm_medium=distribute.pc_relevant.none-task-blog-searchFromBaidu-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-searchFromBaidu-2.control

2.https://blog.csdn.net/WYA1993/article/details/82771743
3.https://blog.csdn.net/qq_36255237/article/details/91990400
（注：springcloud的D版本之后的版本已经不需要在主动添加注解启用注册功能，只需依赖spring-cloud-starter-netflix开头的依赖就可）

4.https://www.cnblogs.com/acm-bingzi/p/javaAnnotation.html(自定义注解，修改注解属性默认值)

5.https://blog.csdn.net/xcy1193068639/article/details/81517456(SpringBoot @ConditionalOnBean、@ConditionalOnMissingBean注解源码)

6.https://blog.csdn.net/ljk126wy/article/details/87895658(springboot2.x整合Druid-Mybatis版)
```





## 项目报错

1.Failed to introspect Class [xxxx] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]

```java
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
[2020/12/18 15:50:23:620][j-basics][main][org.springframework.boot.SpringApplication:837] Application run failed
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'webController': Lookup method resolution failed; nested exception is java.lang.IllegalStateException: Failed to introspect Class [com.yyb.learn.jbasics.controller.WebController] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.determineCandidateConstructors(AutowiredAnnotationBeanPostProcessor.java:289)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.determineConstructorsFromBeanPostProcessors(AbstractAutowireCapableBeanFactory.java:1286)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1201)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:557)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:226)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:893)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551)
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:143)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1237)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226)
	at com.yyb.learn.jbasics.JBasicsApp.main(JBasicsApp.java:13)
Caused by: java.lang.IllegalStateException: Failed to introspect Class [com.yyb.learn.jbasics.controller.WebController] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]
	at org.springframework.util.ReflectionUtils.getDeclaredMethods(ReflectionUtils.java:481)
	at org.springframework.util.ReflectionUtils.doWithLocalMethods(ReflectionUtils.java:321)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.determineCandidateConstructors(AutowiredAnnotationBeanPostProcessor.java:267)
	... 19 common frames omitted
Caused by: java.lang.NoClassDefFoundError: com/yyb/common/dtos/error/MyException
	at java.lang.Class.getDeclaredMethods0(Native Method)
	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701)
	at java.lang.Class.getDeclaredMethods(Class.java:1975)
	at org.springframework.util.ReflectionUtils.getDeclaredMethods(ReflectionUtils.java:463)
	... 21 common frames omitted
Caused by: java.lang.ClassNotFoundException: com.yyb.common.dtos.error.MyException
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	... 25 common frames omitted
```



## SpringCloud细节

```
【问题】
启动两个client，过了一会，停了其中一个，访问注册中心时，界面上显示了红色粗体警告信息：
EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.

【解释】
Eureka server和client之间每隔30秒会进行一次心跳通信，告诉server，client还活着。由此引出两个名词：
Renews threshold：server期望在每分钟中收到的心跳次数
Renews (last min)：上一分钟内收到的心跳次数。

```

