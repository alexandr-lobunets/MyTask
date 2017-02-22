FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp

# Installation:
# Import MongoDB public GPG key AND create a MongoDB list file
#RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
#RUN echo "deb http://repo.mongodb.org/apt/ubuntu $(cat /etc/lsb-release | grep DISTRIB_CODENAME | cut -d= -f2)/mongodb-org/3.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-3.2.list
# Update apt-get sources AND install mongodb

#RUN echo "@testing http://dl-4.alpinelinux.org/alpine/edge/testing" >> /etc/apk/repositories && \
#    apk upgrade --update && \
#    apk add mongodb@testing
## Create the MongoDB data directory
#RUN mkdir -p /data/db
## Expose port 27017 from the container to the host
#EXPOSE 27017
#
## Set usr/bin/mongod as the dockerized entry-point application
#ENTRYPOINT ["sh", "/usr/bin/mongod"]

ADD my-task-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
