package com.example.fyt_backend.repository;

import com.example.fyt_backend.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //id와 member 넣기
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
