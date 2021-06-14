FROM openjdk:11-jdk
EXPOSE 9090
ARG JAR_FILE=target/ecareCrudDemo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} EcarePODFinal.jar
ENTRYPOINT ["java","-jar","/EcarePODFinal.jar"]
