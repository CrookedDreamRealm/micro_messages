package com.dreamrealm.controller;


import com.dreamrealm.model.Message;
import com.dreamrealm.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepo;
   @RequestMapping(value = "/test", method = RequestMethod.GET)
   public ResponseEntity<?> get(){
        return ResponseEntity.ok().body("test");
   }

    @RequestMapping(value = "createMessage", method = RequestMethod.POST)
    public boolean createMessage(@Valid @RequestBody Message message){
        messageRepo.createMessages(message);
        return true;
    }

    @RequestMapping(value= "getMessages", method = RequestMethod.GET)
    public ResponseEntity<?> getMessages() {
        List<Message> messages = messageRepo.getMessages();
        return ResponseEntity.ok()
                .body(messages);
    }
}
