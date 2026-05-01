FROM eclipse-temurin:17-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src
COPY Wallet_MainDB /app/wallet

ENV TNS_ADMIN=/app/wallet

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

COPY --from=buildstage /app/target/ms-citas-medicas-0.0.1-SNAPSHOT.jar /app/app.jar

COPY Wallet_MainDB /app/wallet

ENV TNS_ADMIN=/app/wallet

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]