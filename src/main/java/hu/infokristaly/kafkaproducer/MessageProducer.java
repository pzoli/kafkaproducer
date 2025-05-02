package hu.infokristaly.kafkaproducer;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
   	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
    	kafkaTemplate.send("test",0, Instant.now().toEpochMilli(),"0", msg);
	}

}
