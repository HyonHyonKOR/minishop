package com.hyon01.minishop.web.member;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class MemberDeleteForm {

    private String memberId;

    @NotEmpty(message="비밀번호를 입력해주세요")
    private String memberPw;
    @NotBlank(message = "비밀번호를 한 번 더 입력해주세요.")
    private String memberPw2;
}