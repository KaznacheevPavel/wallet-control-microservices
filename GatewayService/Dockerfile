FROM bellsoft/liberica-openjre-alpine:21.0.5-11
WORKDIR /gateway-service
COPY target/*.jar GatewayService.jar
COPY src/main/resources/application.yaml src/main/resources/application.yaml
ENTRYPOINT ["java", "-jar", "GatewayService.jar", "--spring.config.location=classpath:/application.yaml"]