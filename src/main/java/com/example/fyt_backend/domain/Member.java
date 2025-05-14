package com.example.fyt_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Member {

    private Long id;

    private String name;

    private String password;

}
