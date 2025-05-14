package com.example.fyt_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class GuestBook {

    private Long id;

    private Long ownerId;

    public GuestBook(Long id, Long ownerId) {
        this.id = id;
        this.ownerId = ownerId;
    }

    private List<Comment> comments;

    public void addComment(Comment comment) {
        if(comments == null){
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }


    public Comment findByCommentId(Long commentId){
        return comments.stream().
                filter(comment -> comment.getId().equals(commentId))
                .findFirst()
                .orElse(null);
    }

    public Comment findByWriterId(Long writerId) {
        return comments.stream()
                .filter(comment -> comment.getWriterId().equals(writerId)) //getWriterId와 writerId가 같은게 있다면
                .findFirst() //찾은것중에 첫번째를 반환하고
                .orElse(null); // 없다면 Null 반환
    }
}
