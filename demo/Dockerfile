FROM maven:3.8.1-jdk-11 as build
COPY pom.xml /build/
COPY src /build/src/
RUN  ls -lR /build && cd /build && mvn clean verify && mvn package

FROM tomcat:10.0.14-jdk11-openjdk
WORKDIR /usr/local/tomcat/webapps

#---- App Insights のエージェントを組み込む場合は以下のコメントを外す ----
#RUN curl -OL  https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.2.11/applicationinsights-agent-3.2.11.jar
#ENV CATALINA_OPTS="-javaagent:/usr/local/tomcat/webapps/applicationinsights-agent-3.2.11.jar"
#COPY ./applicationinsights.json /usr/local/tomcat/webapps/

COPY --from=build /build/target/demo.war /usr/local/tomcat/webapps/demo.war