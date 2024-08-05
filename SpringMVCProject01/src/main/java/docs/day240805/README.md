# Note 240805

## Review

### 有多个实现类

- controller
    - jdk 8 以及 之前
        - @Resource("实现类名") 需要导入新的 jar 包
    - jdk 8 之后 不支持 javax 包
        - ````
          @Autowire
          @Qualifier("实现类名")

    - ``````
        注意。如果对应接口 存在多个实现类，怎么处理呢？
        还是三种方式：
        1 修改属性名（不建议）
        2 在@Autowired 下面 再建一个 新的注解
        @Qualifier("studentServiceImpl2")  括号中的就是 指定的 接口的某个实现类的类名首字母小写
        （和@Resource 最大的区别：原先直接 在 注解后面加一个小括号 name=”xxxx”）
      
        3 修改 @Service("studentService") 小括号的值（和 控制层中的属性名一致）

- ![img_1.png](img_1.png)

## SpringMVC
- SpringMVC web.xml 配置
  - ![img_4.png](img_4.png)
- 添加中文过滤器
  - ![img_3.png](img_3.png)
  - ``````
    标签含义
    servlet 标签：

      <servlet-name>: 定义了 servlet 的名称。
      <servlet-class>: 指定了 DispatcherServlet 的完整类名，即 Spring MVC 中的核心前端控制器。
      <init-param>: 可选的初始化参数，用于指定 Spring MVC 配置文件的位置。这里指定了 contextConfigLocation 参数，告诉 DispatcherServlet 在 /WEB-INF/spring-mvc-servlet.xml 中寻找配置信息。
      <load-on-startup>: 指定 servlet 的启动顺序。设置为 1 表示在应用程序启动时立即加载 DispatcherServlet。

    servlet-mapping 标签：

      <servlet-name>: 指定要映射的 servlet 的名称。
      <url-pattern>: 指定 servlet 的 URL 匹配模式。/ 表示匹配所有的请求，因此 DispatcherServlet 将处理应用程序中所有的请求。    
  
### 报错处理

- @Resource 没法加载出来
    - 解决方案:
        - 加依赖
            - ![img.png](img.png)