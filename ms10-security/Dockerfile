FROM gradle:7.4.1-jdk11 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/ms10-sec.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ms10-sec.jar"]