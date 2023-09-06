package com.example.socketchat.chat.chatroom;

import com.example.socketchat.chat.message.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatRoomRepository {

    private final EntityManager entityManager;

    public List<ChatMessage> findChatRoomMessages(Long roomId) {
        Query query = entityManager.createQuery(
                "SELECT c FROM ChatMessage c WHERE c.roomId = :roomId", ChatMessage.class
        );
        query.setParameter("roomId", roomId);

        return query.getResultList();
    }
}
