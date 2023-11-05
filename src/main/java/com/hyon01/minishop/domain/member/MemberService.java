package com.hyon01.minishop.domain.member;


import java.util.List;

public interface MemberService {

   void join(Member member);

   Member findMemberInfo(String memberId);

   void updateInfo(Member member);

   void withdraw(String memberId, String memberPw);

   List<Member> findAllMembers();
}