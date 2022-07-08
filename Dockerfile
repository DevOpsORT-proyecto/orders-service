#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/orders-service-example-0.0.1-SNAPSHOT.jar /usr/local/lib/orders-service-example.jar
EXPOSE 8080
ENV paymentsUrl="paymentsUrl"
ENV shippingUrl="shippingUrl"
ENV productsUrl="productsUrl"
CMD java -jar /usr/local/lib/orders-service-example.jar ${paymentsUrl} ${shippingUrl} ${productsUrl}
