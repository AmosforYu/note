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

####高可用，可以集群模式部署：Eureka自身可作为一个服务注册到其他注册中心，形成注册中心集群。

实现高可用的服务注册中心以及实现微服务的注册与发现

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

####基于HTTP和TCP的客户端负载均衡器，是一个工具类框架，不需要独立部署，几乎集成在SpringCloud组件中。

实现服务间负载均衡的接口调用

```
Ribbon内置可拔插、可定制的负载均衡策略
1.RandomRule：随机选取负载均衡策略
2.RoundRobinRule：线性轮询负载均衡策略
3.RetryRule：使用线性轮询策略获取服务，如果获取失败则在指定时间内重试，重新获取可用服务。
4.WeightedResponseTimeRule：响应时间作为选取权重的负载均衡策略
5.BestAvailableRule：继承自ClientConfigEnabledRoundRobinRule。从所有没有断开的服务中，选取到目前为止请求数量最小的服务。
等等。。。
```



### 3.Hystrix|断路器

####服务降级、服务熔断、请求缓存、请求合并等

实现线程隔离并进入熔断机制，以免在微服务架构中因个别服务出现异常而引起级联故障蔓延

![20180307104620889](D:\TSBrowserDownloads\20180307104620889.png)

```
1.单个服务异常时，不影响到依赖方业务正常流转，可以给予一个错误响应；
2.使用航壁仓模式实现线程池的隔离，会为每一个依赖的服务创建独立的线程池，这样就算某个服务出现延迟过高的情况，也只是对依赖该服务的调用方产生影响，不会影响全局；
```



### 4.Zuul|网关

####请求到后端服务的入口，可以做统一的降级、限流、认证授权、安全

```
1.类似nginx的反向代理
2.Zuul和Eureka整合之后，它为Eureka中的每一个服务都自动创建一个默认路由规则，这些默认规则的path会使用serviceId配置的服务名作为请求前缀
3.
```



###### 请求隔离	

```yaml
#Zuul默认使用信号量来实现隔离，ThreadPool信息会一直处于Loading状态，需要通过Hystrix配置把隔离机制改为线程池的方式才能得以展示。此时execution.isolation.strategy=THREAD这个配置不会生效，需要使用zuul.ribbonIsolationStrategy=THREAD的方式。当 zuul.ribbonIsolationStrategy=THREAD 时，Hystrix的线程隔离策略将会作用于所有路由。且此时HystrixThreadPoolKey 默认为“RibbonCommand”。这意味着，所有路由的HystrixCommand都会在相同的Hystrix线程池中执行。可使用以下配置，让每个路由使用独立的线程池：

zuul:
  ribbon-isolation-strategy: THREAD #Zuul默认使用信号量来实现隔离, 改为线程池隔离模式
  threadPool:
    useSeparateThreadPools: true
    thread-pool-key-prefix: zuul  #为每个路由的HystrixThreadPoolKey添加前缀
```

###### 请求路由	

```yaml
zuul:
  prefix: /learn 
  routes:
    jbusine:
      path: /busine/**
      serviceId: jbusine
      sensitiveHeaders:	#对指定路由的敏感头设置为空
      stripPrefix: false	#路由时默认会去除前缀,在当前路由设置不去除前缀
  ignored-services: jarea,jdashboard  #不自动创建默认路由规则,多个逗号隔开
```

###### 请求过滤	

```java
@Component
public class TokenFilter extends ZuulFilter ...
```

###### Cookie与Header	

```yaml
#默认情况下，Spring Cloud Zuul在请求路由时，会过滤掉HTTP请求头信息中的一些敏感信息，防止它们被传递到下游的外部服务器。

# 方法一，对指定路由开启自定义敏感头
zuul:
	routes:
		<route>:
			customSensitiveHeaders: true
# 方法二，对指定路由的敏感头设置为空
zuul:
	routes:
		<route>:
			sensitiveHeaders: 
# 方法三，对特定的某些头信息设置拦截
#如果项目中引入了Spring Security,Spring Security会自动加上这个配置，默认值为:Pragma,Cache-Control,X-Frame-Options,X-Content-Type-Options,X-XSS-Protection,Expries
zuul:
    ignored-headers: Header1,Header2
```

###### 重定向问题	

```
#在使用了Shiro、Spring Security等安全框架登录成功后，会重定向到具体的web应用所在的地址，而不是指向api网关地址，就会暴露内部服务的关键信息，这种情况要避免：

zuul:
	add-host-header: true
```

###### 匹配规则	

```
线性匹配，即按照路由匹配规则的存储顺序依次匹配(properties文件中不能保证这个先后顺序，需要用YAML来配置)
```

###### 服务降级

```java
@Component
public class BusineFallback implements FallbackProvider...
```



#####过滤器简介

IZuulFilter接口 -> ZuulFilter抽象类 -> Zuul的Filter实现类、自定义Filter实现类

```java
String filterType();		/* 过滤类型 */
int filterOrder();			/* 执行顺序 */
boolean shouldFilter();		/* 执行条件 */
Object run();				/* 具体操作 */
```

过滤类型：[pre]请求被路由前生效；[routing]路由请求时生效；[post]在pre或error后生效；[error]请求处理出错时生效。
执行顺序：int类型数字，数字越小，越先生效。
执行条件：当前过滤器是否生效，可通过此方法指定过滤器生效范围。
具体操作：过滤器的具体逻辑，拦截、路由或对请求路由返回的结果做一些处理。

![img](https://img-blog.csdn.net/20180920141204792?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dZQTE5OTM=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



### 5.Feign|轻便的微服务调用

####整合了Spring Cloud Ribbon 和 Spring Cloud Hystrix，微服务接口代理，提供了一种声明式的Web服务客户端定义方式

实现服务间负载均衡的接口调用

```
1.基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

注：Feign和Ribbon的重试机制是相互独立的，且一旦使用了Feign就肯定会用到Ribbon，所以一般都直接使用到Ribbon的重试。不过一般并不建议开启重试机制，因为只做查询的请求重试多次无所谓，涉及到修改数据库如增加订单、支付扣款等操作，在未做幂等性的情况下，可能会发生重复操作的情况。
```

