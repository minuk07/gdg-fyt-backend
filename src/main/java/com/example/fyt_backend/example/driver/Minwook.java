package com.example.fyt_backend.example.driver;

import com.example.fyt_backend.example.car.Bently;
import com.example.fyt_backend.example.car.Car;
import lombok.Getter;

@Getter
public class Minwook implements Driver {

    private Car car; //구체화된 클래스가 아님. 인터페이스임 -> Null point exception
    private String name = "이민욱";

    public Minwook(Car car) { //생성자 주입
        this.car = car;
    }

    @Override
    public String drive() {
        return this.getName() + "이 " + car.move();
    }
}
