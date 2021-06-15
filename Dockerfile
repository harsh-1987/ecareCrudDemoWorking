FROM openjdk:8-jdk-alpine
LABEL maintainer="harsh.mishra@synechron.com"
ADD target/ecareCrudDemo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
