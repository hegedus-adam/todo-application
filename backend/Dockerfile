# Use maven to compile the java application.
FROM maven:3-jdk-11-slim AS build-env

# Set the working directory to /app
WORKDIR /app

# copy the pom.xml file to download dependencies
COPY pom.xml ./

# download dependencies as specified in pom.xml
# building dependency layer early will speed up compile time when pom is unchanged
RUN mvn verify --fail-never

# Copy the rest of the working directory contents into the container
COPY . ./

# Compile the application.
RUN mvn -Dmaven.test.skip=false package

# Build runtime image.
FROM openjdk:11-jre-slim

# Copy the compiled files over.
COPY --from=build-env /app/target/ /app/

# Starts java app with port 8080.
CMD ["java", "-jar", "/app/todo-0.0.1-SNAPSHOT.jar"]
