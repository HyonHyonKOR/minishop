package com.hyon01.minishop.domain.login;

import com.hyon01.minishop.domain.member.Member;

public interface LoginService {
    Member login(String memberId,String memberPw);
}
