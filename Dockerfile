FROM eclipse-temurin:21.0.4_7-jre-ubi9-minimal
LABEL authors="apro"
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} charge-detail-service.jar
ENTRYPOINT ["java", "-jar", "charge-detail-service.jar"]