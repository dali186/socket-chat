package com.example.socketchat.chat.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Transactional
    public void saveChat(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }
}
