FROM gradle AS build
WORKDIR /app
COPY . .
RUN gradle clean build

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/ms10-demo1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ms10-demo1.jar"]