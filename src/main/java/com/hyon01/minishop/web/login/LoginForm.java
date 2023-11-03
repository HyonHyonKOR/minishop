package com.hyon01.minishop.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty(message="ID를 입력해주세요")
    private String memberId;
    @NotEmpty(message="비밀번호를 입력해주세요")
    private String memberPw;
    private Integer memberLevel;
}
