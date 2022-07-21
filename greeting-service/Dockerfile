FROM adoptopenjdk:11-jre-hotspot
COPY target/greeting-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","app.jar"]