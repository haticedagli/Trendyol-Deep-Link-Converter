FROM openjdk:16
MAINTAINER haticeetoglu
VOLUME /tmp
EXPOSE 8080
ADD target/deeplink-converter-1.0.0.jar deeplinkconverterdocker.jar
ENTRYPOINT ["java","-jar","/deeplinkconverterdocker.jar"]