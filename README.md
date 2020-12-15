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


```

