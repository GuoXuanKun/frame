# Note 240823

## Review

## 权限控制 (登录校验)

- 前端后端都要做
- 后端
    - 准备工作
        - entity
            - Result.java
        - controller
            - ![img.png](img.png)
    - 拦截器
        - 预防问 , 获得 token 的操作
- 前端
    - 准备工作
        - Token 工具
            - ![img_1.png](img_1.png)
    - 路由守护
        - ![img_2.png](img_2.png)
    - Axios 的 请求 和 拦截器
        - ![img_5.png](img_5.png)
        - 响应
            - ![img_6.png](img_6.png)
    - 登录界面
        - ![img_8.png](img_8.png)
    - 状态管理
        - 准备工作: 确保有装 pinia
            - ![img_9.png](img_9.png)
            - ``````
              npm i pinia@latest
              npm i pinia-plugin-persistedstate@latest
              
            - ![img_10.png](img_10.png)
            - ![img_11.png](img_11.png)
        - 登录成功后，将 tno  和 tname保存到 状态管理中
          - ![img_12.png](img_12.png)
          - ![img_13.png](img_13.png)
          - ![img_14.png](img_14.png)
          - ![img_15.png](img_15.png)

### 获取 Store 的数据

- ![img_7.png](img_7.png)

## 报错处理

## 截图寄存处