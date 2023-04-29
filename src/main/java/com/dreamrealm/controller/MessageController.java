package com.dreamrealm.controller;


import com.dreamrealm.DTO.MessageDTO;
import com.dreamrealm.logic.MessageLogic;
import com.dreamrealm.model.Message;
import com.dreamrealm.repository.MessageRepo;
import com.dreamrealm.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/message")
@RestController
public class MessageController {
   @Autowired
   MessageRepository messageRepo;

   @Autowired
   MessageLogic messageLogic;
   @RequestMapping(value = "/test", method = RequestMethod.GET)
   public ResponseEntity<?> get(){
        return ResponseEntity.ok().body("test");
   }

    @RequestMapping(value = "createMessage", method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(@Valid @RequestBody Message message){
        Boolean response = messageRepo.createMessages(message);
        return ResponseEntity.ok()
                .body(response);
    }

    @RequestMapping(value= "getMessages", method = RequestMethod.GET)
    public ResponseEntity<?> getMessages() {
        List<Message> messages = messageRepo.getMessages();
        return ResponseEntity.ok()
                .body(messages);
    }

    @RequestMapping(value = "addMessage", method = RequestMethod.POST)
    public ResponseEntity<?> addMessage(@Valid @RequestBody Message message){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Boolean response = messageLogic.createMessages(message);
        return ResponseEntity.ok()
                .body(response);
    }

    @RequestMapping(value= "getAllMessages", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMessages() {
        List<Message> messages = messageLogic.getAllMessages();
        return ResponseEntity.ok()
                .body(messages);
    }
}
