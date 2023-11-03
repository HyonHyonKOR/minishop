package com.hyon01.minishop.web.member;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.hyon01.minishop.web.member.MemberValidationGroup.*;

@Data
public class MemberAddForm {

    @NotBlank(message = "아이디를 입력해주세요.",groups = NotBlankGroup.class)
    @Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "잘못된 아이디 형식입니다.",groups = PatternGroup.class)
    private String memberId;

    @NotBlank(message = "비밀번호를 입력해주세요.",groups = NotBlankGroup.class)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}", message = "잘못된 비밀번호 형식입니다.",groups = PatternGroup.class)
    private String memberPw;

    @NotBlank(message = "비밀번호를 한 번 더 입력해주세요.",groups = NotBlankGroup.class)
    private String memberPw2;

    @NotBlank(message = "이름을 입력해주세요.",groups = NotBlankGroup.class)
    private String memberName;

    @NotBlank(message = "이메일을 입력해주세요.",groups = NotBlankGroup.class)
    @Email(message = "유효하지 않은 이메일 형식입니다.",groups = PatternGroup.class)
    private String memberEmail;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.",groups = NotBlankGroup.class)
    @Pattern(regexp = "^[0-9]{10,11}$", message = "10자 또는 11자의 숫자만 입력 가능합니다",groups = PatternGroup.class)
    private String memberHp;

    @NotBlank(message = "우편번호를 입력해주세요.",groups = NotBlankGroup.class)
    @Pattern(regexp = "[0-9]{5,10}", message = "5자 이상 10자 이하여야 합니다.",groups = PatternGroup.class)
    private String memberAddress1;

    @NotBlank(message = "기본 주소를 입력해주세요.",groups = NotBlankGroup.class)
    private String memberAddress2;

    private String memberAddress3;


}
