# syntax = docker/dockerfile:experimental
FROM gradle:7.1.1-jdk16 AS build
WORKDIR  /home/gradle
COPY --chown=gradle:gradle build.gradle  settings.gradle ./

RUN mkdir -p src/main/java/ie/hunt/sb/hello
# Trigger compile with no java on the compile path
# this triggers download of dependencies which can be
# cached. I can't see a nicer way to do this
RUN gradle compileJava --no-daemon

# prevent caching of src/main/java/ie/hunt/sb/hello/GVersion.java 
RUN rm -rf src

# Copy the src in and run a proper compile/build executable jar file
COPY --chown=gradle:gradle src ./src
RUN gradle bootJar --no-daemon

FROM openjdk:16-alpine3.13

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]