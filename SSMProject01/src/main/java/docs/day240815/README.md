# Note 240815

## Review

- ![img_2.png](img_2.png)
- 插值表达式 里面可以用 三目运算符

## Vue3

### 事件处理

- 点击事件
    - 我们可以使用 v-on 指令 (简写为 @) 来监听 DOM 事件，并在事件触发时执行对应的 JavaScript。用法：v-on:click="handler" 或
      @click="handler"。
    - ![img.png](img.png)
    - 弹出框的写法
        - 方法的小括号可以省略
            - ![img_1.png](img_1.png)
- 事件修饰符
    - Vue 为 v-on 提供了事件修饰符。修饰符是用 . 表示的指令后缀，包含以下这些：
        - .stop
            - ![img_3.png](img_3.png)
        - .prevent
            - ![img_4.png](img_4.png)
            - 链式调用
                - ![img_5.png](img_5.png)
        - .self
        - .capture
        - .once
            - ![img_6.png](img_6.png)
        - .passive

### 表单输入绑定

- v-model
    - 双向绑定的
    - ![img_7.png](img_7.png)
    - `<textarea></textarea>`
    - ![img_8.png](img_8.png)
    - 复选框
        - ![img_9.png](img_9.png)
    - 单选框
        - ![img_10.png](img_10.png)
        - 指定 值
            - ![img_18.png](img_18.png)
    - 下拉框
        - ![img_11.png](img_11.png)
        - ![img_12.png](img_12.png)
        - 多选
            - ![img_13.png](img_13.png)
        - 动态反显下拉框
            - ![img_14.png](img_14.png)
            - ![img_15.png](img_15.png)
        - 值绑定
            - ![img_16.png](img_16.png)
        - 修饰符
            - .lazy
                - ![img_17.png](img_17.png)
            - .number
                - 如果你想让用户输入自动转换为数字，你可以在 v-model 后添加 .number 修饰符来管理输入
                    - ![img_19.png](img_19.png)

### 生命周期

- 生命周期
    - ![img_20.png](img_20.png)
- 钩子函数
    - ![img_24.png](img_24.png)..

### 侦听器

- 侦听 一个属性
    - ![img_21.png](img_21.png)
- 侦听 一个对象
    - 深侦听
    - ![img_25.png](img_25.png)
        - 更改对象
            - ![img_27.png](img_27.png)
    - 侦听 对象属性
        - ![img_26.png](img_26.png)
    - 侦听 对象的属性也是对象
        - ![img_28.png](img_28.png)
- 侦听器 死循环
    - ![img_22.png](img_22.png)
- 侦听器 返回值
    - 返回值是 停止函数 , 调用的时候 ,让当前监听器停下来
        - ![img_23.png](img_23.png)

## 报错处理

## 截图寄存