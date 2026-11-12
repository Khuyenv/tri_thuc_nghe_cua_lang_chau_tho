# 1. Giai đoạn Build JAR
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B
COPY src ./src
RUN ./mvnw clean package -DskipTests

# 2. Giai đoạn Khởi chạy
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENV PORT=8080
EXPOSE 8080
# Chạy app và lắng nghe cổng động do Cloud cấp phát
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -Djava.security.egd=file:/dev/./urandom -jar app.jar"]
