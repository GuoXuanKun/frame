# Note 240726
## 动态 sql
- Link : `https://mybatis.org/mybatis-3/zh_CN/dynamic-sql.html`
- 注意 : Dao层 无论是 一个或多个参数 , 都要加 @param 否则 无法识别 , 会报错
- 多分支语句
  - ![img_1.png](img_1.png)
  - ![img_2.png](img_2.png)
  - ![img_3.png](img_3.png)
  - ![img_4.png](img_4.png)
- where 的运用
  - ![img_5.png](img_5.png)
- Trim 的运用 
  - ![img_6.png](img_6.png)
  - ![img_9.png](img_9.png)
- set 的运用
  - ![img_7.png](img_7.png)
  - ![img_8.png](img_8.png)
- foreach 的运用
  - ![img_10.png](img_10.png)
  - ![img_11.png](img_11.png)
  - ![img_12.png](img_12.png)
  - ![img_13.png](img_13.png)
  - ![img_14.png](img_14.png)

## 报错处理
- 用 动态 sql 时需要注意 :  Dao层 无论是 一个或多个参数 , 都要加 @param 否则 无法识别 , 会报错
- MyBatis 从 某 版本 开始 ， 可以 使用 ${} 形式 来 接受 参数 ， 而 不 需要 使用 @Param 注解 。
  - ![img.png](img.png)