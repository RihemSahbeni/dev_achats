FROM adoptopenjdk/openjdk11
COPY target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/TPachatProject-1.0.jar"]
