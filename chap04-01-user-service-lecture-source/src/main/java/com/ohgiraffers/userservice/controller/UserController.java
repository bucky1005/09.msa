package com.ohgiraffers.userservice.controller;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.vo.HelloVO;
import com.ohgiraffers.userservice.vo.RequestUser;
import com.ohgiraffers.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    private Environment env;
    private HelloVO helloVO;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(Environment env, HelloVO helloVO, ModelMapper modelMapper) {
        this.env = env;
        this.helloVO = helloVO;
        this.modelMapper = modelMapper;
    }

    /* 설명. yml 파일에 작성한 설정값을 불러오는 2가지 방법
    *   1. Environment를 의존성 주입 받아 getProperty로 설정 키 값을 작성해 불러오는 방법
    *   2. @Value를 활용해 필드로 주입받고 활용하는 방법 */

    /* 설명 1. Environment를 활용해 설정값 불러오기(getProperty) */
    @GetMapping("/health_check")
    public String status() {
        return "Server at " + env.getProperty("local.server.port")
                + ", swcamp.message: " + env.getProperty("swcamp.message");
    }

    /* 설명 2. @Value를 활용해 설정값 주입받기(getter) */
    @GetMapping("/do_msa")
    public String doMsa() {
        return helloVO.getMessage();
    }

    /* 설명. 회원가입(POST - /users) */
    /* 메모. 회원가입에 성공한 회원의 정보를 화면에 뿌려주도록 기능 구현 */
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> registUser(@RequestBody RequestUser user) {

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        System.out.println("userDTO = " + userDTO);

        ResponseUser responseUser = new ResponseUser();
        responseUser.setName("응답 확인!");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
