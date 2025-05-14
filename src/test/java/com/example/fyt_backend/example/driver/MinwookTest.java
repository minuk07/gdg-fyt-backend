package com.example.fyt_backend.example.driver;

import com.example.fyt_backend.example.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MinwookTest {

    @Test
    void drive() {

        //given
        //AppConfig appConfig = new AppConfig();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig class를 보고 적혀져 있는대로 적용해라. application context에서 꺼내옴
        Driver minwookLee = context.getBean("driver", Driver.class); //AppConfig에서 지정해줌. (의존성 주입)

        //when
        String content = minwookLee.drive();

        //then
        Assertions.assertThat(content).isEqualTo("이민욱이 bently로 운전중입니다.");
    }
}