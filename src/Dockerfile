FROM gradle:jdk17
LABEL authors="pzoli"
RUN apt -y update && apt -y upgrade
RUN useradd -m -g users -s /bin/bash pzoli
RUN echo "pzoli:example"|chpasswd
RUN apt -y install openssh-server nmap nano git
WORKDIR /home/pzoli
COPY start-commands.sh start-commands.sh
RUN ["chmod", "+x", "start-commands.sh"]
USER pzoli
RUN git clone https://github.com/pzoli/kafkaconsumer.git
RUN git clone https://github.com/pzoli/kafkaproducer.git
RUN echo "export JAVA_HOME=/opt/java/openjdk">>.profile
RUN echo "export PATH=$PATH">>.profile
USER root
EXPOSE 22 8080
ENTRYPOINT ["./start-commands.sh"]
