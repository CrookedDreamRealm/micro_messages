package com.dreamrealm.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity(name="message")
public class MessageDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    public String sender;
    public String title;
    public String description;
    public Integer upVotes;
    public Integer downVotes;
    public LocalDateTime dateOfCreation;
}
