FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk add --no-cache curl fontconfig graphviz ttf-dejavu \
    && curl -O https://noto-website.storage.googleapis.com/pkgs/NotoSansCJKjp-hinted.zip \
    && mkdir -p /usr/share/fonts/NotoSansCJKjp \
    && unzip NotoSansCJKjp-hinted.zip -d /usr/share/fonts/NotoSansCJKjp/ \
    && rm NotoSansCJKjp-hinted.zip \
    && fc-cache -fv
COPY . .
VOLUME ["/docs"]
ENTRYPOINT ["java", "-jar", "./lib/plantuml/plantuml-1.2021.14.jar", "output", "-o", "../docs/uml"]
