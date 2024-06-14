# Use an official OpenJDK base image

FROM openjdk:17.0.1-jdk-slim



# Set the working directory inside the container

WORKDIR /app



# Copy the compiled JAR file into the container

COPY target/etudiant*.jar app.jar



# Expose the port the app runs on

EXPOSE 8080



# Define the command to run the app when the container starts

CMD ["java", "-jar", "app.jar"]