package com.dreamrealm.repository;

import com.dreamrealm.DTO.MessageDTO;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<MessageDTO, Integer> {

}