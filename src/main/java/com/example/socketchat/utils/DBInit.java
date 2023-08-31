package com.example.socketchat.utils;

import com.example.socketchat.user.Member;
import com.example.socketchat.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DBInit {

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDB(MemberRepository memberRepository){
        return args -> {
            Member member = Member.builder()
                    .username("member")
                    .password(passwordEncoder.encode("1234"))
                    .role("user")
                    .build();

            Member admin = Member.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("1234"))
                    .role("admin")
                    .build();

            memberRepository.saveAll(Arrays.asList(member, admin));
        };
    }
}
