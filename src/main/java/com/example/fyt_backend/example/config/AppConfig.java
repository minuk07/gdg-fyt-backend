package com.example.fyt_backend.example.config;

import com.example.fyt_backend.example.car.Bently;
import com.example.fyt_backend.example.car.Car;
import com.example.fyt_backend.example.driver.Driver;
import com.example.fyt_backend.example.driver.Minwook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 bean 설정
public class AppConfig {

    //bean - 스프링에 등록된 객체

    //의존성 주입
    @Bean //스프링 컨테이너에 객체를 등록하겠다.
    public Car car(){
        return new Bently();
    }

    @Bean
    public Driver driver(){
        return new Minwook(car());
    }
}
