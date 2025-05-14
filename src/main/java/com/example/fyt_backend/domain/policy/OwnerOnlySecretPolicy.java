package com.example.fyt_backend.domain.policy;

import com.example.fyt_backend.domain.Comment;
import com.example.fyt_backend.domain.Member;

public class OwnerOnlySecretPolicy implements SecretPolicy {

    @Override
    public boolean canRead(Comment comment, Member viewer, Long ownerId) {

        if (!comment.isSecret()) {
            return true;
        }

        if (viewer == null) {
            return false;
        }

        return viewer.getId().equals(ownerId); //보려는 사람의 id와 ownerId가 같은경우에만 true를 반환.
    }
}
