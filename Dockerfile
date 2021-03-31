FROM openjdk:11.0.10-jdk-buster

RUN set -x && \
    addgroup --gid 1000 appuser && \
    adduser --uid 1000 --disabled-password --gecos "" --ingroup appuser appuser
USER appuser
ADD app /app
WORKDIR /app
RUN ./gradlew --project-cache-dir /tmp/gradle-cache build