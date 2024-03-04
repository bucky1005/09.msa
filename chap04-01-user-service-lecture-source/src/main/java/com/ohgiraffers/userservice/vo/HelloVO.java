package com.ohgiraffers.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HelloVO {

    @Value("${swcamp.message}")
    private String message;

}
