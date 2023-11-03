package com.hyon01.minishop.domain.member;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String memberHp;
    private String memberAddress1;
    private String memberAddress2;
    private String memberAddress3;
    private Integer memberLevel;
    private Date memberRegDate;
    private Integer memberAccount;
    private Integer memberPoint;
}
