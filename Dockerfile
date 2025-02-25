FROM maven:3.9.6-eclipse-temurin-21 AS build
#RUN mkdir -p /usr/src/app
#WORKDIR /usr/src/app
ADD target/*.jar docker-api.jar
#RUN mvn package
ENTRYPOINT ["java","-jar","docker-api.jar"]



#FROM eclipse-temurin:21-jdk
#RUN mkdir -p /usr/src/app
#WORKDIR /usr/src/app
#COPY --from=build /usr/src/app/target/UrbanFlow-BackEnd-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java","-jar","app.jar"]

#ENV JDBC_DATABASE_URL=jdbc:postgresql://host:porta/urbanflow_db
#ENV JDBC_DATABASE_USERNAME=usuario
#ENV JDBC_DATABASE_PASSWORD=senha