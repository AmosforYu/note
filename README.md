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



## SpringCloud组件简介

###1.Eureka |服务注册中心

#####高可用，可以集群模式部署：Eureka自身可作为一个服务注册到其他注册中心，形成注册中心集群。

```
-|服务注册：客户端通过REST请求方式注册到Eureka，Eureka会将客户端的元数据存储在一个双层结构Map中，外层key是服务名，内层key是具体服务的实例名；

-|服务同步：Eureka集群中的任一Eureka，会将注册过来的请求同步到其他Eureka处，从而实现Eureka之间的服务同步。

-|服务续约：客户端注册后会维护一个心跳来告诉Eureka服务依旧可用，防止Eureka的服务剔除任务将该客户端实例从服务列表中删除。
  #定义服务续约任务的调用间隔时间，默认30秒
  eureka.instance.lease-renewal-interval-in-seconds=30
  #定义服务失效的时间，默认90秒
  eureka.instance.lease-expiration-duration-in-seconds=90
  
-|获取服务：Eureka会维护一份只读的服务清单，当有客户端来请求获取可用服务时，Eureka会将该清单返回给客户端，该缓存清单会没隔30秒更新一次；
  # 缓存清单的更新时间，默认30秒
  eureka.client.registry-fetch-interval-seconds=30

-|服务调用：服务消费者在获取到服务清单后，通过服务名可以获得具体提供服务的实例及其元数据。(在Ribbon中会默认采用轮询模式来调用服务，从而实现客户端的负载均衡)

-|服务下线：服务正常下线时，会调用发送下线的REST请求给Eureka，Eureka收到下线请求后会将该服务实例下线并将该服务实例的下线事件传播出去，同步到Eureka集群

-|失效剔除：Eureka在启动的时候会创建一个定时任务，默认每隔一段时间（默认为60秒）将当前清单中超时（默认为90秒）没有续约的服务剔除出去

-|自我保护：Eureka运行时会统计心跳数，心跳失败比例如果在15分钟内低于85%，Eureka就会将当前的实例注册信息保护起来，保证其不被剔除；但在这种情况下，需要项目中有容错机制：服务降级、请求重试等功能
  #关闭保护机制，以确保注册中心可以将不用的实例正确剔除（本地调试可以使用，线上不推荐）
  eureka.server.enable-self-preservation=false
```



### 2.Ribbon|客户端负载均衡

##### 基于HTTP和TCP的客户端负载均衡器

```
1.
2.
3.
```



### 3.Hystrix|断路器

##### 服务降级、服务熔断、请求缓存、请求合并等

```
1.
2.
3.
```



### 4.Zuul|网关

##### 请求到后端服务的入口，统一拦截、转发

```
1.
2.
3.
```

### 5.Feign|轻便的微服务调用

##### 和Ribbon以及Eureka紧密协作的微服务接口代理

```
1.
2.
3.
```

