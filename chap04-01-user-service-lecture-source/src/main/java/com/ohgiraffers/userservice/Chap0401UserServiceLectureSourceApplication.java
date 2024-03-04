package com.ohgiraffers.userservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient      // 이게 있어야 gateway가 해당 서버를 인식할 수 있음.
public class Chap0401UserServiceLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0401UserServiceLectureSourceApplication.class, args);
    }

    /* 설명. ModelMapper를 빈으로 등록(필요하면 의존성 주입 가능)
        Spring이 알아서 객체 만들어서 주입해달라고. */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
