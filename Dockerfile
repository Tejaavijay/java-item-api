FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy everything
COPY . .

# Give execute permission to both mvnw and mvnw.cmd just in case
RUN chmod +x ./mvnw

# Build using mvnw through sh (safer in some environments)
RUN sh mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/javaapi-0.0.1-SNAPSHOT.jar"]
