package com.example.fyt_backend.service;

import com.example.fyt_backend.domain.Comment;
import com.example.fyt_backend.domain.GuestBook;
import com.example.fyt_backend.domain.Member;
import com.example.fyt_backend.domain.policy.OwnerOnlySecretPolicy;
import com.example.fyt_backend.domain.policy.SecretPolicy;
import com.example.fyt_backend.repository.GuestBookRepository;
import com.example.fyt_backend.repository.MemoryGuestBookRepository;

public class GuestBookService {

    private final GuestBookRepository guestBookRepository = new MemoryGuestBookRepository();
    private final SecretPolicy secretPolicy = new OwnerOnlySecretPolicy();

    //guestBook 저장.
    public void createGuestBook(GuestBook guestbook) {
        guestBookRepository.save(guestbook);
    }

    public void addComment(Long guestBookId, Comment comment) {
        GuestBook guestBook = guestBookRepository.findById(guestBookId);
        guestBook.addComment(comment);
    }

    public String read(Long guestBookId, Long commentId, Member viewer) {

        GuestBook guestBook = guestBookRepository.findById(guestBookId);
        Comment comment = guestBook.findByCommentId(commentId);

        if (comment == null) {
            throw new IllegalArgumentException("존재하지 않는 댓글입니다");
        }

        if (!secretPolicy.canRead(comment, viewer, guestBook.getOwnerId())) {
            return "[비밀 댓글입니다]";
        }

        return comment.getContent();

    }

}
