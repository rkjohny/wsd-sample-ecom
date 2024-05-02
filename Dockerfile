FROM openjdk:17-alpine

COPY ./build/libs/ecom-0.0.1-SNAPSHOT.jar /app/ecom.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "ecom.jar"]