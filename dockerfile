FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test
ENTRYPOINT ["java", "-jar", "build/libs/app.jar"]