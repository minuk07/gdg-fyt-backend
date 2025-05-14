package com.example.fyt_backend.service;

import com.example.fyt_backend.domain.Member;
import com.example.fyt_backend.repository.MemberRepository;
import com.example.fyt_backend.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //MemoryRepository, MemoryMemberRepository 모두 의존하고 있음.

    public void join(Member member){
        memberRepository.save(member);
    }

    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }
}
