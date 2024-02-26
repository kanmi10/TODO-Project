package com.test.todo.member;

import lombok.Data;

/**
 * 
 * MemberDTO 클래스입니다.
 * 
 * 회원 관련 데이터 getter, setter
 * 
 * @author 김경현
 *
 */
@Data
public class MemberDTO {
    private String email;
    private String pw;
    private String nickname;
    private String active;
    private String message;
    
    //memberInfo
    private String category;
    private String seq;
    private String image;
    
    private String theme;
    private String fonttype;

    private String subToDo;
    private String timeTable;
    private String timeCal;
    private String timeCir;
    
   
}
































