package pl.uken.krakow.client_rabitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pl.uken.krakow.client_rabitmq.model.Message;

@Service
public class MessageSenderService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderService.class);

    public void sendMessage(String queueName, Message message){
    }

    public void sendMessage(String message){
    }

    public void sendJsonMessage(Message msg){
    }
}
