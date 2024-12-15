package pl.uken.krakow.client_rabitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pl.uken.krakow.client_rabitmq.model.Message;

@Service
public class MessageReciverService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReciverService.class);

    public void reciveMessage(String message){
    }


    public void reciveJsonMessage(Message msg){
    }
}
