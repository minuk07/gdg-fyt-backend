package com.example.fyt_backend.repository;

import com.example.fyt_backend.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}
