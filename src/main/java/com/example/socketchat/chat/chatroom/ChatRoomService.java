package com.example.socketchat.chat.chatroom;

import com.example.socketchat.chat.message.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public List<ChatMessage> getChatMessages(Long roomId) {
        return chatRoomRepository.findChatRoomMessages(roomId);
    }

}
