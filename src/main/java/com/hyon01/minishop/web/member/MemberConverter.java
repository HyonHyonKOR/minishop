package com.hyon01.minishop.web.member;

import com.hyon01.minishop.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberConverter {

    public Member addFormToMember(MemberAddForm memberAddForm){
        log.info("컨버터 진입 : {}", memberAddForm);
        Member member = new Member();
        member.setMemberId(memberAddForm.getMemberId());
        member.setMemberPw(memberAddForm.getMemberPw());
        member.setMemberName(memberAddForm.getMemberName());
        member.setMemberEmail(memberAddForm.getMemberEmail());
        member.setMemberHp(memberAddForm.getMemberHp());
        member.setMemberAddress1(memberAddForm.getMemberAddress1());
        member.setMemberAddress2(memberAddForm.getMemberAddress2());
        member.setMemberAddress3(memberAddForm.getMemberAddress3());
        return member;
    }

    public MemberUpdateForm MembertoUpdateForm(Member member){
        log.info("컨버터 진입 : {}", member);
        MemberUpdateForm memberUpdateForm = new MemberUpdateForm();
        memberUpdateForm.setMemberId(member.getMemberId());
        memberUpdateForm.setMemberName(member.getMemberName());
        memberUpdateForm.setMemberEmail(member.getMemberEmail());
        memberUpdateForm.setMemberHp(member.getMemberHp());
        memberUpdateForm.setMemberAddress1(member.getMemberAddress1());
        memberUpdateForm.setMemberAddress2(member.getMemberAddress2());
        memberUpdateForm.setMemberAddress3(member.getMemberAddress3());
        memberUpdateForm.setMemberAccount(member.getMemberAccount());
        memberUpdateForm.setMemberPoint(member.getMemberPoint());
        return memberUpdateForm;
    }

    public Member updateFormToMember(MemberUpdateForm memberUpdateForm){
        log.info("컨버터 진입 : {}", memberUpdateForm);
        Member member = new Member();
        member.setMemberId(memberUpdateForm.getMemberId());
        member.setMemberPw(memberUpdateForm.getMemberPw());
        member.setMemberName(memberUpdateForm.getMemberName());
        member.setMemberEmail(memberUpdateForm.getMemberEmail());
        member.setMemberHp(memberUpdateForm.getMemberHp());
        member.setMemberAddress1(memberUpdateForm.getMemberAddress1());
        member.setMemberAddress2(memberUpdateForm.getMemberAddress2());
        member.setMemberAddress3(memberUpdateForm.getMemberAddress3());
        member.setMemberAccount(memberUpdateForm.getMemberAccount());
        member.setMemberPoint(memberUpdateForm.getMemberPoint());
        return member;
    }

}
