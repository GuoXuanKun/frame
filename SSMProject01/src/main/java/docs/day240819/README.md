# Note 240819

## Vue3

### 状态管理

- Pinia
    - 引入 Pinia
        - 官网 : https://pinia.vuejs.org/zh/
        - 安装 pinia
            - npm install pinia@latest
    - main.js
        - ![img_6.png](img_6.png)
    - 路由
        - 引入 : npm i vue-router@latest
        - 新建 touter 文件夹
            - 新建 index.js
                - ![img_3.png](img_3.png)
                - ![img_12.png](img_12.png)
    - 在 src 文件夹下 创建一个 stores 文件夹
        - 新建一个文件 (比如 : countStore.js)
            - ![img_8.png](img_8.png)
        - studentStore.js
            - ![img_11.png](img_11.png)
    - Components 文件夹下
        - Test1.vue
            - ![img_19.png](img_19.png)
        - Test2.vue
            - ![img_20.png](img_20.png)
        - Test3.vue
            - ![img_21.png](img_21.png)
    - App.vue
        - ![img_5.png](img_5.png)
        - ![img_13.png](img_13.png)

    - 持久化
        - 官网 : https://prazdevs.github.io/pinia-plugin-persistedstate/zh/guide/
        - 引入
            - npm i pinia-plugin-persistedstate@latest
        - main.js
            - ![img_16.png](img_16.png)
        - stores 文件下
            - 方式一
                - 要 持久化 的 状态文件 比如 countStore.js
                    - ![img_15.png](img_15.png)
                    - 这种写法默认保存在 localstorage (持久的 , 除非手动清除)
            - 方式二
                - 要 持久化 的 状态文件 比如 studentStore.js
                    - ![img_17.png](img_17.png)
                    - 或者
                        - ![img_18.png](img_18.png)

## 报错处理

## 截图寄存处