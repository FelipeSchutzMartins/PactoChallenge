FROM maven:3.9.6-eclipse-temurin-17 as maven

RUN mkdir /pacto-back
WORKDIR /pacto-back

COPY pom.xml /pacto-back
COPY src /pacto-back/src
RUN mvn -f /pacto-back/pom.xml clean package

EXPOSE 8080
CMD ["java","-jar","/pacto-back/target/pacto-1.war"]