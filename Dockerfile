FROM openjdk:17
EXPOSE 8080
ADD target/currency-exchange-service-0.0.1-SNAPSHOT.jar currency-exchange.jar
ENTRYPOINT ["java","-jar","currency-exchange.jar"]