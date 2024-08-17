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

- 路径
    - 不加 / 是 相对路径
    - 加 / 是根路径
    - ![img_13.png](img_13.png)
    - 关于二级路径
        - ![img_14.png](img_14.png)
        - ![img_15.png](img_15.png)

- 重定向 (index.js)
    - ![img_16.png](img_16.png)

- 路由跳转
    - ![img_17.png](img_17.png)
    - router.push() 跳转
        - ![img_20.png](img_20.png)
    - 动态路径
        - 使用绑定
            - ![img_21.png](img_21.png)
            - ![img_22.png](img_22.png)
            - ![img_23.png](img_23.png)
            - ![img_24.png](img_24.png)

- 路由传参
    - ![img_29.png](img_29.png)
    - query 查询
        - 步骤
            - ![img_30.png](img_30.png)
            - ![img_31.png](img_31.png)
        - 具体代码
            - index.js
                - ![img_34.png](img_34.png)
            - ![img_35.png](img_35.png)
            - 接收
                - ![img_26.png](img_26.png)
            - router.push() 跳转方式
                - ![img_37.png](img_37.png)
                - ![img_38.png](img_38.png)
    - param
        - 步骤
            - ![img_32.png](img_32.png)
            - ![img_33.png](img_33.png)
            - 具体代码
                - index.js
                    - ![img_28.png](img_28.png)
                - ![img_36.png](img_36.png)
                - 接收
                    - ![img_26.png](img_26.png)
                - router.push() 跳转方式
                    - ![img_37.png](img_37.png)
                    - ![img_39.png](img_39.png)

- 路由守护
    - 全局守护
        - ![img_43.png](img_43.png)
        - 状态管理
            - index.js
                - ![img_46.png](img_46.png)
        - 权限控制
            - ![img_44.png](img_44.png)
            - ![img_45.png](img_45.png)
        - 懒加载
            - index.js
                - ![img_41.png](img_41.png)
        - 销毁问题
            - ![img_42.png](img_42.png)

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