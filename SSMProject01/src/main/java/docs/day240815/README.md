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

## 报错处理

## 截图寄存