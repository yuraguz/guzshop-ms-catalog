FROM openjdk:21-slim
ENV TZ="Europe/Moscow"

COPY ms-catalog-impl/target/*.jar ms-catalog.jar
ENTRYPOINT exec java $JAVA_ARG -jar /ms-catalog.jar
