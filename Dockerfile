FROM openjdk:8-alpine
EXPOSE 9000
RUN mkdir jverify
WORKDIR jverify
ADD target/verify-1.0-SNAPSHOT.jar .
ADD prod.properties .
ADD prod.keystore .
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "verify-1.0-SNAPSHOT.jar"]
