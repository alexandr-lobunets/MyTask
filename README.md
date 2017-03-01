# MyTask <img src="https://travis-ci.org/alexandr-lobunets/MyTask.svg?branch=master"/> [![CodeFactor](https://www.codefactor.io/repository/github/alexandr-lobunets/mytask/badge)](https://www.codefactor.io/repository/github/alexandr-lobunets/mytask)
Portal with students and their grades


Requirements:

1. Spring Boot
2. Gradle
3. MongoDB database
4. Add compiled jar to Docker container
5. Output data by Spring ThymeLeaf + Bootstrap



http://dev-pages.info/how-to-run-spring-boot-and-mongodb-in-docker-container/



docker build my_task .

docker network create task_net

docker run --name spring-demo-mongo --network=task_net -v /home/ubuntu/mongo-data:/data/db -d mongo

docker run test --network=task_net -p 8080:8080
