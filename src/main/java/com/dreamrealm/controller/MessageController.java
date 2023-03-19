package com.dreamrealm.controller;


import com.dreamrealm.DTO.MessageDTO;
import com.dreamrealm.model.Message;
import com.dreamrealm.repository.MessageRepo;
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

    @Autowired
    MessageRepo messageRep;
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

    @RequestMapping(value = "addMessage", method = RequestMethod.POST)
    public boolean addMessage(@Valid @RequestBody Message message){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        MessageDTO messageAdd = new MessageDTO();
        messageAdd.setDescription(message.getDescription());
        messageAdd.setTitle(message.getTitle());
        messageAdd.setUsername(message.getUsername());
        messageAdd.setDownVotes(message.getDownVotes());
        messageAdd.setUpVotes(message.getUpVotes());
        messageRep.save(messageAdd);
        return true;
    }

    @RequestMapping(value= "getAllMessages", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMessages() {
        List<MessageDTO> messages = (List<MessageDTO>) messageRep.findAll();
        return ResponseEntity.ok()
                .body(messages);
    }

}
