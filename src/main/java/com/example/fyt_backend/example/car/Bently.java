package com.example.fyt_backend.example.car;

import lombok.Getter;

@Getter
public class Bently implements Car{

    private String name = "bently";

    @Override
    public String move() {
        return "bently로 운전중입니다.";
    }
}
