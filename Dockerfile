FROM openjdk:23-slim
COPY target/hyremap-0.0.1-SNAPSHOT.jar hyremap-0.0.1.jar
ENTRYPOINT ["java","-jar","/hyremap-0.0.1.jar"]
