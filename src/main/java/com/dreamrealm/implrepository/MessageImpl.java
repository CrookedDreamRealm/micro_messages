package com.dreamrealm.implrepository;

import com.dreamrealm.model.Message;
import com.dreamrealm.repository.MessageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageImpl implements MessageRepository {
    List<Message> messages = new ArrayList<>();
    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public Boolean createMessages(Message msg) {
        messages.add(msg);
        return true;
    }
}
