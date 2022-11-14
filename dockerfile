FROM openjdk:11
EXPOSE 8089
COPY target/tpAchatProjectachat-1.0.jar tpAchatProjectachat.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]