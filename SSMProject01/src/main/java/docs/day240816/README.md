# Note 240816

## Review

## 报错处理

- 配置 Swagger 单元测试 会报错
    - ![img.png](img.png)

- 关于 日期的转换 （Date 转换成 json 格式 ）
    - 请求：@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    - 响应：@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 添加在 对应的Date属性上面
    - ![img_1.png](img_1.png)
    - ![img_2.png](img_2.png)
    - ![img_3.png](img_3.png)
## 截图寄存处