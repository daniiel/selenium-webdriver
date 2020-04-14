FROM openjdk:8u212-jre-alpine
WORKDIR /usr/share/selenium
COPY ["build/libs/libs", "libs"]
COPY [ "build/libs/selenium-project.jar",       \
       "build/libs/selenium-project-tests.jar", \
       "./"]
COPY ["src/test/resources/*.xml", "./"]
ENTRYPOINT java -cp selenium-project.jar:selenium-project-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
