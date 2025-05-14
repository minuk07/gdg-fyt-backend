package com.example.fyt_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comment {

    private Long id;

    private Long guestBookId;

    private Long writerId;

    private boolean isSecret;

    private String content;
}
