FROM bellsoft/liberica-openjre-alpine:21.0.5-11
WORKDIR /authorization
COPY target/*.jar AuthorizationService.jar
COPY src/main/resources/application.properties application.properties
COPY .env .env
ENTRYPOINT ["java", "-jar", "AuthorizationService.jar", "--spring.config.location=classpath:/application.properties"]