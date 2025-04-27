FROM openjdk

WORKDIR /app

COPY CopsbootApplication.java /app

RUN javac CopsbootApplication.java

CMD ["java", "CopsbootApplication"]
