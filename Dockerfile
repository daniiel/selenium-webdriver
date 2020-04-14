FROM openjdk:8u212-jre-alpine
RUN apk add curl jq
WORKDIR /usr/share/selenium
COPY [ "build/libs/libs", "libs" ]
COPY [ "build/libs/selenium-project.jar",       \
       "build/libs/selenium-project-tests.jar", \
       "./" ]
COPY [ "src/test/resources/*.xml",               \
       "healthcheck.sh", "./" ]
ENTRYPOINT sh healthcheck.sh
