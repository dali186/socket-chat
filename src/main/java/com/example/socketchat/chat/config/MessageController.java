package com.example.socketchat.chat.config;

import com.example.socketchat.chat.message.ChatMessage;
import com.example.socketchat.chat.message.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/test")
    public void message(ChatMessage chatMessage) {
        chatMessage.setCreatedAtNow();
        simpMessageSendingOperations.convertAndSend("/sub/room/" + chatMessage.getRoomId(), chatMessage);
        chatMessageService.saveChat(chatMessage);
    }
}
