# 镜像基于什么基础镜像-基于jdk17+
FROM openjdk:17-jdk-alpine

# 将编译后的文件复制到镜像中，用于运行
ADD target/demo02-0.0.1-SNAPSHOT.jar /app.jar

# 设置启动命令
ENTRYPOINT ["java","-jar","/app.jar"]

