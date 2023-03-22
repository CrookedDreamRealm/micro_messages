package com.dreamrealm.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Message {
    public String username;
    public String title;
    public String description;
    public Integer upVotes;
    public Integer downVotes;
    public LocalDateTime dateOfCreation;
}

