FROM gradle:jdk17
LABEL authors="pzoli"
RUN apt -y update && apt -y upgrade
RUN useradd -m -g users -s /bin/bash pzoli
RUN echo "pzoli:example"|chpasswd
RUN apt -y install openssh-server
RUN apt -y install nmap
RUN apt install git
RUN su pzoli
WORKDIR /home/pzoli
RUN git clone https://github.com/pzoli/kafkaconsumer.git
RUN git clone https://github.com/pzoli/kafkaproducer.git
EXPOSE 22 8080

COPY start-commands.sh start-commands.sh
RUN ["chmod", "+x", "start-commands.sh"]
ENTRYPOINT ["./start-commands.sh"]
