package com.example.fyt_backend.domain.policy;

import com.example.fyt_backend.domain.Comment;
import com.example.fyt_backend.domain.Member;

public class OwnerAndWriterSecretPolicy implements SecretPolicy {

    @Override
    public boolean canRead(Comment comment, Member viewer, Long ownerId) {

        if (!comment.isSecret()) {
            return true;
        }

        if (viewer == null) {
            return false;
        }

        return viewer.getId().equals(ownerId) || viewer.getId().equals(comment.getWriterId());
        //보려는 사람의 id와 ownerId가 같은경우와 댓글장석자와 viewer의 id가 같은 경우 true 반환
    }
}
