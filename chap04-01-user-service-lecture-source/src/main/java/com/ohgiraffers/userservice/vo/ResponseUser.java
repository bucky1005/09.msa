package com.ohgiraffers.userservice.vo;

import lombok.Data;

/* 설명. 사용자에게 보여줄 값
        사용자에게 전달할 내용들을 담은 VO 객체 */
@Data
public class ResponseUser {
    private String name;
    private String email;
    private String userId;

    /* 설명. FeignClient 이후(다른 도메인 서버와 통신해서 값을 가져온 이후) 추가할 것 */
//    private List<ResponseOrder> orders;

}
