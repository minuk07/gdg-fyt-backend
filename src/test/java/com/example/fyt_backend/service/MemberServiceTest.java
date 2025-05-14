package com.example.fyt_backend.service;

import com.example.fyt_backend.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private final MemberService memberService = new MemberService();

    @Test
    void join() {

        //given - test에 필요한 재료들
        Member member = new Member(1L, "이민욱", "1234");

        //when - 어느 부분에서 이 test를 하고 싶은지
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then - 검증
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}