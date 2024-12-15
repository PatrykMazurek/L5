package pl.uken.krakow.client_rabitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQJSONConfig {
    
    @Value("${rabbitmq.queue.json.name}")
    private String queueJSONName;
    @Value("${rabbit.exchange.json.name}")
    private String exchangeJSONName;
    @Value("${rabbit.routing.json.key}")
    private String routingJSONKey;

    @Bean
    public Queue queueJSON(){
        return new Queue(queueJSONName);
    }
    @Bean
    public TopicExchange exchangeJSON(){
        return new TopicExchange(exchangeJSONName);
    }

    @Bean
    public Binding Jsonbinding(){
        return BindingBuilder.bind(queueJSON()).to(exchangeJSON()).with(routingJSONKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
