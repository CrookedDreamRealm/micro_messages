package com.dreamrealm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    public String username;
    public String title;
    public String description;
    public Integer upVotes;
    public Integer downVotes;
}

