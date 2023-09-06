package com.example.socketchat.chat.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String sender;
    private Long roomId;
    private String data;
    private LocalDateTime createdAt;

    public void setSender(String sender) {this.sender = sender;}

    public void setCreatedAtNow() {this.createdAt = LocalDateTime.now();}
}
