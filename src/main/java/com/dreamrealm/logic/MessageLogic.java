package com.dreamrealm.logic;

import com.dreamrealm.DTO.MessageDTO;
import com.dreamrealm.model.Message;
import com.dreamrealm.repository.MessageRepo;
import com.dreamrealm.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageLogic {
    @Autowired
    MessageRepo messageRep;
    public boolean createMessages(Message message){
        try{
            ModelMapper modelMapper = new ModelMapper();
            MessageDTO messageDTO = modelMapper.map(message, MessageDTO.class);
            messageRep.save(messageDTO);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public List<Message> getAllMessages(){
        List<MessageDTO> messageDTO = (List<MessageDTO>) messageRep.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<Message> messages = messageDTO.stream().map(message -> modelMapper.map(message, Message.class)).collect(Collectors.toList());
        return messages;
    }
}
