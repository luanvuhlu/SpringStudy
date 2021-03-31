FROM openjdk:11.0.10-jdk-buster

RUN set -x && \
    addgroup --gid 1000 appuser && \
    adduser --uid 1000 --disabled-password --ingroup appuser appuser
