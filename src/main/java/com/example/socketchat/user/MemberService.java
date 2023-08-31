package com.example.socketchat.user;

import com.example.socketchat.chat.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
