package com.example.fyt_backend.example.car;

import lombok.Getter;

@Getter
public class Bmw implements Car{

    private String name = "bmw";

    @Override
    public String move() {
        return "bmw로 운전중입니다.";
    }
}
