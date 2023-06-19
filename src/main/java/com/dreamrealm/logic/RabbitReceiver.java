package com.dreamrealm.logic;

import com.dreamrealm.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitReceiver {

    @Autowired
    MessageRepository messageRep;
    private final RabbitTemplate rabbitTemplate;

    public RabbitReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Autowired
    MessageLogic messageLogic;

    @RabbitHandler
    @RabbitListener(queues = {"q.deleteInfoMessage"})
    public void onOfferRegistration(String event)  {
        log.info("Delete account Event Received: {}", event);
        //executeRegistration(event);
        //rabbitTemplate.convertAndSend("x.post-registration","", event);
        System.out.println(event);
        messageLogic.removeUserFromMessage(event);
        log.info("Account: {}", event);
    }

    /*@RabbitListener(queues = {"q.fall-back-registration"})
    public void onRegistrationFailure(Offer failedRegistration){
        log.info("Executing fallback for failed registration {}", failedRegistration);
    }*/

    private void executeRegistration(String event) {
        log.info("Executing offer Registration Event: {}", event);

        throw new RuntimeException("Registration Failed");

    }
}
