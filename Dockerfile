#terminal: ./gradlew clean build -x test   - gera .jar da app
#terminal: docker compose up -d --build    - cria o container
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY build/libs/helloAws-0.0.1-SNAPSHOT.jar .
COPY newrelic/newrelic.jar .
COPY newrelic/newrelic.yml .
EXPOSE 80
CMD ["java", "-javaagent:newrelic.jar", "-jar", "helloAws-0.0.1-SNAPSHOT.jar"]