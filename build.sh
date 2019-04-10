#!/usr/bin/env sh

./gradlew build


sudo $(aws ecr get-login --no-include-email --region cn-northwest-1)

sudo docker build -t parking-service .
sudo docker tag parking-service:latest 076880417388.dkr.ecr.cn-northwest-1.amazonaws.com.cn/parking-service:latest
sudo docker push 076880417388.dkr.ecr.cn-northwest-1.amazonaws.com.cn/parking-service:latest
