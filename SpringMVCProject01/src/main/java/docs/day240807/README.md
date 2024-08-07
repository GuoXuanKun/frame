# Note 240807

## Review

- 确认弹出框
    - ![img.png](img.png)
- 输入框不可改
    - ![img_1.png](img_1.png)

## ajax

- `produces = "text/html;charset=UTF-8" 如果传递 不是text(String) 不要加`
    - ![img_2.png](img_2.png)

## 文件上传下载

- 上传
    - 导依赖
        - ![img_3.png](img_3.png)
    - applicationContext.xml 加配置 添加文件的限制（中文 大小）
        - ![img_4.png](img_4.png)
    - 添加 jsp文件 form表单提交 注意 method enctype属性
        - ![img_5.png](img_5.png)
    - 控制层：参数为 MultipartFile 参数，注意 参数名 和 标签name一致
        - ![img_6.png](img_6.png)
    - 主要方法： getOriginalFilename 获得原始名 transferTo 转存到本地
        - ![img_7.png](img_7.png)
        - ![img_8.png](img_8.png)
    - ````
    其他
    UUID
    获得真实路径
    获得后缀
    创建文件夹等等

### 报错处理

### 截图寄存处

