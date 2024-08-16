# Note 240816

## Review

## Vue3

### 路由

- 安装路由 , 加依赖
    - ![img_5.png](img_5.png)
- 配置 Vue router文件
    - router/index.js
        - ![img_6.png](img_6.png)
- main.js
    - ![img_7.png](img_7.png)
- App.vue
    - ![img_8.png](img_8.png)

- 配置多个路由
    - router/index.js
        - ![img_9.png](img_9.png)
        - 注意 : 
          - history:createWebHistory()
            - 使用 HTML5 History API 进行路由管理，URL 看起来更干净，没有哈希 (#) 符号。
          - history:createWebHashHistory()
            - 使用 URL 哈希部分进行路由管理，适合不支持 HTML5 History API 的浏览器。
      - App.vue
        - ![img_10.png](img_10.png)
- 父子关系
    - router/index.js
        - ![img_11.png](img_11.png)
    - New.vue
        - ![img_12.png](img_12.png)

## 报错处理

- 配置 Swagger 单元测试 会报错
    - ![img.png](img.png)
    - 方式二
        - ![img_4.png](img_4.png)

- 关于 日期的转换 （Date 转换成 json 格式 ）
    - 请求：@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    - 响应：@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 添加在 对应的Date属性上面
    - ![img_1.png](img_1.png)
    - ![img_2.png](img_2.png)
    - ![img_3.png](img_3.png)

## 截图寄存处