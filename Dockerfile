FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
RUN ./gradlew build -x test
EXPOSE 8082
CMD ["java", "-jar", "build/libs/timezone-0.0.1-SNAPSHOT.jar"]
