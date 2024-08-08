# Note 240808

## Review

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

## 报错处理

- ajax 要配置 (applicationContext.xml)
    - ![img_3.png](img_3.png)

- ![img_14.png](img_14.png)

## 截图寄存处
