package com.hyon01.minishop.domain.member;


public interface MemberService {

   void join(Member member);

   Member findMemberInfo(String memberId);

   void updateInfo(Member member);

   void withdraw(String memberId, String memberPw);

}