# Note 240802
## Review

## 工厂类
- 创建对象的方法
  - 静态方法
    - ![img.png](img.png)
  - 普通方法
    - ![img_1.png](img_1.png)
  - 按需加载
    - 只有在使用 `applicationContext.getBean()` 才调用构造函数
      - ![img_3.png](img_3.png)
  - 预加载
    - 单例模式（整个Spring容器中 有且仅有一份 默认 在 配置加载后（applicaitonContext对象创建的时候））被创建
      - ![img_4.png](img_4.png)

### 自动注入 
- autowire=""
  - byName
    - ![img_6.png](img_6.png)
  - byType
    - ![img_5.png](img_5.png)

### 通过 扫描 + 注解 
- 传统
  - ![img_9.png](img_9.png)
- 通过 注解 + 扫描
  - 在 applicationContext.xml 里
    - ![img_10.png](img_10.png)
    - ![img_29.png](img_29.png)
- 主键扫描
  - ![img_7.png](img_7.png)
- 注解 
  - ![img_8.png](img_8.png)
    - 有四个: (写在类上面)
    - 控制层 @Controller
    - 业务逻辑层 @Service
    - 数据访问层 @Repository
    - 其他层(工具类) @Component
  - 自动注入
    - @Resource (可以不用写 get set 方法) 通过 反射实现的  

- 通过扫描+注解的方式 取代了原来的逐个 配置bean标签方式，更加简便
  - 如何获得 Bean 对象 
    - 如何获得这个bean ，getBean
      - 1 没有其他配置；默认  类名首字母小写
        - ![img_30.png](img_30.png)
      - 2 如果在@Controller(“名字”) 通过 名字
        - ![img_31.png](img_31.png)
      - 3 直接用类名.class 的方式获得（推荐）
        - ![img_32.png](img_32.png)
      

- 传统 与 注解+扫描的方式 的区别
  - ``````
    普通写法（配置bean标签）和注解+扫描写法的对比
    1.普通写法 每个类都要在xml中配置一个 bean标签
      新的写法 只要在xml中添加对应的依赖（.xsd 等）以及加入扫描标签即可，
      并且要在类上方写上对应的注解（
      四个注解：
        控制层 @Controller
        业务逻辑层 @Service
        数据访问层 @Repository
        其他层（比如 工具类等等）  @Component
      ）
      （一劳永逸）
    2 普通写法：存在属性注入的时候，属性需要提供set方法
      新的写法：存在属性注入的时候，属性不用提供set方法（系统通过反射获得）
    3 普通写法，要在bean中配置 ref或者 通过 autowire="byType"自动注入
      新的写法：不用修改xml文件，只需要再对应的属性上方写上@Resource
          
- ``````
  关于使用注解版的 自动注入 注意实现：
  一、 如果只存在一个对应类型的实现类，直接用即可（相当于是 之前设置的 byType）
  二、 如果存在 多个 同类型的实现类：怎么区分？
  1 通过 通过属性名来判定（ 属性名等于 对应 实现类的首字母小写 方式 ） 缺点：一处修改，处处修改
  2 在@Resource后面加个属性：name值 等于 对应 实现类的首字母小写
  缺点：如果当前方法是我写的，实现类是别人写的，我不能因为别人的修改，一直我的代码
  3 修改实现类上的注解 比如 ：@Service("名字") 名字 和我的属性名同名，则使用该 实现类（注入该实现类的对象）（推荐）



### SpringMVC
- 创建SpringMVC
  - 创建项目
    - ![img_13.png](img_13.png)
  - 导入 依赖
    - ![img_14.png](img_14.png)
    - ![img_15.png](img_15.png)
  - 配置 applicationContext.xml
    - ![img_17.png](img_17.png)
  - 修改配置 web.xml
    - ![img_18.png](img_18.png)
- 流程图
  - ![img_11.png](img_11.png)

- 控制层
  - ``````
    在controller包下，创建一个普通的类：
    运用Spring中的知识，我们可以在这里配上 @Controller注解
    这样就可以被 前置控制器识别到（确切的来说是 处理器映射 到）
    
  - ![img_20.png](img_20.png)
  - ![img_21.png](img_21.png)
- 关于返回页面
  - 有两种写法：
    - 方式一
      - 一种是直接返回字符串：SpringMVC 会识别到 这个一个路径，然后调用 视图解析器 找到对应的jsp页面
        - ![img_22.png](img_22.png)
      - 字符串只需要写 jsp文件名，不用写后缀，后缀由视图解析器帮你拼接
        - ![img_23.png](img_23.png)
      - 代码如下
        - ![img_25.png](img_25.png)
    - 方式二 (推荐)
      - ![img_26.png](img_26.png)
      - 关于 获得 参数（前端发送到控制层的数据：）
        - ![img_27.png](img_27.png)
      - 响应数据（传值到jsp页面中显示）：
        - ![img_28.png](img_28.png)
      - 前端页面的获得和请求同 jspServlet一样
        

### 报错
- 空 Bean 报错
  - ![img_2.png](img_2.png)
- 在 Spring 版本为 6.1.10 下的报错
  - ![img_12.png](img_12.png)
- ![img_16.png](img_16.png)