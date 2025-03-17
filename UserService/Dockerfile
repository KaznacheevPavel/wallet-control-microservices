FROM bellsoft/liberica-openjre-alpine:21.0.5-11
WORKDIR /user-service
COPY target/*.jar UserService.jar
COPY src/main/resources/application.properties src/main/resources/application.properties
COPY src/main/resources/secret.properties src/main/resources/secret.properties
ENTRYPOINT ["java", "-jar", "UserService.jar", "--spring.config.location=classpath:/application.properties"]