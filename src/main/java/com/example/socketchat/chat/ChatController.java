package com.example.socketchat.chat;

import com.example.socketchat.chat.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomService chatRoomService;

    @GetMapping("/chatroom/{roomId}")
    public String enterChatRoom(@PathVariable Long roomId, Model model) {
        model.addAttribute("roomChats", chatRoomService.getChatMessages(roomId));

        return "chatroom";
    }
}
