# Note 240808

## Review

- el 表达式 有就添加没有 就去除
    - ![img_15.png](img_15.png)
- SpringMVC 流程图
    - 前端控制器
        - /
            - 路径都会经过他
        - 获得请求路径
        - 类似 过滤器
    - 视图解析器
        - ![img_1.png](img_1.png)
    - 核心
        - ![img_2.png](img_2.png)

## SSM

### log4j.properties

- 日志文件 的 地址 以及 超过指定大小 后进行备份
    - ![img_5.png](img_5.png)
- 最大备份数量
    - ![img_6.png](img_6.png)
    - .1是下标
        - ![img_7.png](img_7.png)

### applicationContext.xml

- 除了 controller 其他都经过这
    - ![img_10.png](img_10.png)

### springmvc-servlet.xml

- 跟视图解析器有关
- 控制 controller
    - ![img_11.png](img_11.png)

### web.xml

- 跟前端控制器有关
- 这段配置代码的主要作用是设置和初始化 Spring 应用上下文。通过 ContextLoaderListener 监听器，Spring 可以在 web
  应用程序启动时自动加载配置文件并初始化应用上下文。contextConfigLocation 参数指定了 Spring 配置文件的位置，确保 Spring
  能找到并加载这些配置。
    - ![img_8.png](img_8.png)
    - ![img_9.png](img_9.png)

### Spring 和 Mybatis 需要整合

- ![img_4.png](img_4.png)

### sqlMapConfig.xml

- 设置别名
    - ![img_13.png](img_13.png)
- 再到 applicationContext.xml 进行配置
    - ![img_12.png](img_12.png)

## 代理

## AOP

- 步骤
    - 依赖
        - ![img_16.png](img_16.png)
    - 写类
        - ![img_19.png](img_19.png)
    - 添加配置 (applicationContext.xml)
        - ![img_18.png](img_18.png)
        - ![img_17.png](img_17.png)
- 通知类型 (写在 第二步 写的那个aop 文件夹 的类中 也是 添加配置的那个类)
    - ![img_20.png](img_20.png)
    - 前置通知
    - 执行结束通知
    - 返回通知
    - 异常通知
    - 环绕通知 (相当于 4合1 通知)
        - 继续连接点
            - ![img_27.png](img_27.png)
                - 返回值是 Object
        - 获得参数
            - ![img_26.png](img_26.png)

## 日志打印

- 这种实现方式 会将内容 保留到 本地日志文件中 (如果有配置的话)
- 代码实现
    - ![img_22.png](img_22.png)
    - ``````
      Log4j 提供了以下日志级别，从高到低依次为：

      FATAL：记录非常严重的错误，导致程序中止运行。
      ERROR：记录错误事件，但程序可以继续运行。
      WARN：记录可能会出现问题的警告信息。
      INFO：记录一般信息，描述程序的运行状态。
      DEBUG：记录详细信息，用于调试。
      TRACE：记录更为详细的信息，通常用于跟踪程序的执行流程。
- 用注解实现
    - ![img_23.png](img_23.png)
    - ![img_24.png](img_24.png)

## 报错处理

- ajax 要配置 (applicationContext.xml)
    - ![img_3.png](img_3.png)

- ![img_14.png](img_14.png)

## 截图寄存处
