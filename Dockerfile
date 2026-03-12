FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/scientific-calculator.jar /app/scientific-calculator.jar

CMD ["sh", "-c", "java -jar /app/scientific-calculator.jar]
