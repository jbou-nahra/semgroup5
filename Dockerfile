FROM openjdk:latest
COPY ./target/group5-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group5-0.1.0.2-jar-with-dependencies.jar"]