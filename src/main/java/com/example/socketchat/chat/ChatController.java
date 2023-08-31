package com.example.socketchat.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/chat")
    public ChatRoom createRoom(@RequestBody String name) {
        return chatService.createRoom(name);
    }

    @GetMapping("/chat/room")
    public String findAllRoom(Model model) {
        model.addAttribute("rooms", chatService.findAllRoom());
        return "/chatroom";
    }
}