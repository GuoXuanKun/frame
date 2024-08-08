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


### Spring 和 Mybatis 需要整合

- ![img_4.png](img_4.png)

## 报错处理

- ajax 要配置 (applicationContext.xml)
    - ![img_3.png](img_3.png)

## 截图寄存处
