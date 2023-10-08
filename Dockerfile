#terminal: ./gradlew clean build -x test   - gera .jar da app
#terminal: docker compose up -d --build    - cria o container
FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
COPY build/libs/helloAws-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "helloAws-0.0.1-SNAPSHOT.jar"]