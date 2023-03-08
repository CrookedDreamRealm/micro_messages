package com.dreamrealm.repository;

import com.dreamrealm.model.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> getMessages();
    Boolean createMessages(Message msg);
}
