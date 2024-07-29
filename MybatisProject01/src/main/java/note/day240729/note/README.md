# Note 240729
## Review 

### resultMap
- ````
    1. resultMap

    resultMap 是 MyBatis 的一个重要元素，用于指定 SQL 查询结果如何映射到 Java 对象。它允许你定义复杂的对象映射，包括一对多、多对多的关系。
    主要属性及其意义：

    id:
        意义：唯一标识 resultMap 的标识符。
        用途：在其他映射中引用该 resultMap。

    type:
        意义：指定 resultMap 映射的 Java 类类型。
        用途：告诉 MyBatis 结果映射到哪个类型的对象。
  
    子元素：

    <id>:
        意义：指定映射对象的主键字段。
        用途：用于唯一标识对象的字段。
        属性：
            property：映射到 Java 对象的属性名。
            column：数据库列名。

    <result>:
        意义：指定其他字段的映射。
        用途：将 SQL 查询结果中的字段映射到 Java 对象的属性。
        属性：
            property：映射到 Java 对象的属性名。
            column：数据库列名。
            javaType：可选，指定 Java 类型（用于自定义类型）。

    <association>:
        意义：用于映射嵌套的对象。
        用途：处理一对一关系。
        属性：
            property：嵌套对象的属性名。
            resultMap：引用另一个 resultMap，用于映射嵌套对象。

    <collection>:
        意义：用于映射集合属性。
        用途：处理一对多关系。
        属性：
            property：集合属性的名称。
            ofType：集合元素的类型。
            resultMap：引用另一个 resultMap，用于映射集合中的每个元素。

### resultMap 的 collection
- ``````
    collection 元素用于在 resultMap 中定义如何映射集合属性。它通常用于处理一对多关系，将 SQL 查询结果中的多个记录映射到 Java 对象的集合属性中。
    主要属性及其意义：

    property:
        意义：Java 对象中集合属性的名称。
        用途：指定要映射的集合属性。

    ofType:
        意义：集合元素的类型。
        用途：指定集合中元素的 Java 类，用于告诉 MyBatis 如何将查询结果中的每一项映射为该类型的对象。

    resultMap:
        意义：指定一个 resultMap，用于定义如何将集合中的每个元素映射到相应的 Java 对象。
        用途：指定一个 resultMap，用于定义如何处理集合中的每个项，以便将 SQL 查询结果中的每个记录映射为集合元素。

### 动态 sql
- `<标签>` 要做逻辑运算 用 `and` `or`

### 懒加载 ( 面试 工程量大时 常用 )
- 一对一
- 一对多
- 懒加载 总配置 放在哪里
- 依赖 
- 三档 懒加载


