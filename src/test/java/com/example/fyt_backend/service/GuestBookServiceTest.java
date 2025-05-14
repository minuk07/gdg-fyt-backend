package com.example.fyt_backend.service;

import com.example.fyt_backend.domain.Comment;
import com.example.fyt_backend.domain.GuestBook;
import com.example.fyt_backend.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestBookServiceTest {

    private final GuestBookService guestBookService = new GuestBookService();

    private Member owner;
    private Member visitor;
    private GuestBook guestBook;
    private Comment comment;

    @BeforeEach
    void initData() {
        owner = new Member(1L, "방명록 주인", "1234");

        visitor = new Member(2L, "작성자", "1234");

        guestBook = new GuestBook(1L, 1L);
        guestBookService.createGuestBook(guestBook);

        comment = new Comment(1L, 1L, 2L, true, "잘 보고 갑니다.");
        guestBookService.addComment(comment.getGuestBookId(), comment);
    }

    @Test
    void read() {
        String content = guestBookService.read(guestBook.getId(), comment.getId(), visitor);
        Assertions.assertThat(content).isEqualTo("[비밀 댓글입니다]");

        String ownerView = guestBookService.read(guestBook.getId(), comment.getId(), owner);
        Assertions.assertThat(content).isEqualTo("[비밀 댓글입니다]");
    }
}