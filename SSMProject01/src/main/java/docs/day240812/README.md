# Note 240812

## Review

- AOP
    - 表达式
        - ![img_1.png](img_1.png)
        - ![img_2.png](img_2.png)
        - ![img_3.png](img_3.png)
        - ![img_4.png](img_4.png)
    - 通知类
        - @Component (使用注释 将通知类 IOC 到 Spring 容器中 ,后面直接用 , 不用再配 bean 标签)
        - 五个 方法(通知)
            - ![img_18.png](img_18.png)
        - 切面 切点
            - ![img_19.png](img_19.png)
            - ![img_20.png](img_20.png)
        - ![img_22.png](img_22.png)

## 事务 (Transaction)

- ACID
    - 原子性
        - ![img_6.png](img_6.png)
    - 一致性
        - ![img_7.png](img_7.png)
    - 隔离性
        - ![img_8.png](img_8.png)
    - 持久性
        - ![img_9.png](img_9.png)
- 作用在那一层
    - Service
    - ![img_16.png](img_16.png)
- applicationContext.xml 配置
    - ![img_17.png](img_17.png)
- 业务逻辑层 实现类 事务注解 @Transactional
    - 某方法 方法前
        - ![img_15.png](img_15.png)
- 回滚
    - 如果遇到异常 在没有捕获的情况下 事务会启动回滚机制
    - 如果遇到异常 捕获了 就手动实现回滚
        - ![img_12.png](img_12.png)

## Swagger2

- 依赖
- 配置类 (SwaggerConfig)
  ![img_28.png](img_28.png)
- 配置 springmvc-servlet.xml
    - ![img_26.png](img_26.png)
    - ![img_25.png](img_25.png)
    - 访问路径名
        - ![img_27.png](img_27.png)
- 对应 Controller 加 注解
    - ![img_29.png](img_29.png)
    - ![img_30.png](img_30.png)
- restFul方式
    - 让地址栏更加简单
    - @RestController 注解
        - 是一个综合注解
            - ![img_31.png](img_31.png)
    - ![img_32.png](img_32.png)
      - @GetMapping 查询
      - @PostMapping 添加
      - @DeleteMapping 删除
      - @PutMapping 修改
    - @PathVariable 配置 路径变量
      - ![img_33.png](img_33.png)
      - ![img_34.png](img_34.png)
## 报错处理

- springmvc-servlet.xml 配置拦截器 报错 , 但是并不影响运行结果
    - ![img_23.png](img_23.png)
        - ![img_5.png](img_5.png)

## 截图寄存处

- ![img.png](img.png)
