package com.dreamrealm.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity(name="message")
public class MessageDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    public String username;
    public String title;
    public String description;
    public Integer upVotes;
    public Integer downVotes;
    public LocalDateTime dateOfCreation;
}
