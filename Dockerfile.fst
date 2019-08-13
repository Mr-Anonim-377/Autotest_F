from registry.skidex.ru/skidex/site/autotests:4817a6f981e9186e4c401cd3e2576656dad62210

COPY . /data

# Make & install autotest artifact
RUN mvn clean && \
    mvn compile && \
    mvn package

# Default configuration
ENV DISPLAY :20.0
ENV SCREEN_GEOMETRY "1440x900x24"
ENV CHROMEDRIVER_PORT 4444
ENV CHROMEDRIVER_WHITELISTED_IPS "127.0.0.1"
ENV CHROMEDRIVER_URL_BASE ''
ENV CHROMEDRIVER_EXTRA_ARGS ''

RUN java -jar target/AutoTest-1.0-SNAPSHOT-jar-with-dependencies.jar