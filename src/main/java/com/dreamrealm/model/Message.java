package com.dreamrealm.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Message {
    public String sender;
    public String title;
    public String description;
    public Integer upVotes;
    public Integer downVotes;
    public LocalDateTime dateOfCreation;
}

