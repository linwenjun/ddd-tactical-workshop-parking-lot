#!/usr/bin/env sh

./gradlew build


$(aws ecr get-login --no-include-email --region cn-northwest-1)
docker build -t parking-service .
docker tag parking-service:latest 076880417388.dkr.ecr.cn-northwest-1.amazonaws.com.cn/parking-service:latest
docker push 076880417388.dkr.ecr.cn-northwest-1.amazonaws.com.cn/parking-service:latest
