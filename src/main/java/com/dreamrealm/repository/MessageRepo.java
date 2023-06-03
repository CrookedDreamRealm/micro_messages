package com.dreamrealm.repository;

import com.dreamrealm.DTO.MessageDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<MessageDTO, Integer> {
    List<MessageDTO> findBySender(String sender);
}