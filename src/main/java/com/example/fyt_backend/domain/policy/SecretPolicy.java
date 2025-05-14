package com.example.fyt_backend.domain.policy;


import com.example.fyt_backend.domain.Comment;
import com.example.fyt_backend.domain.Member;

public interface SecretPolicy {

    boolean canRead(Comment comment, Member viewer, Long ownerId);
}
