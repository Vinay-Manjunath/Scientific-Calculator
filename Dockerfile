FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/Scientific_Calculator-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

CMD ["sh", "-c", "java -jar /app/scientific-calculator.jar && tail -f /dev/null"]
