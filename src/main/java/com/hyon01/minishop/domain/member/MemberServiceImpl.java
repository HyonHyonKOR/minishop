package com.hyon01.minishop.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void join(Member member) {
       log.info("서비스 진입 : {}", member);
       memberRepository.findById(member.getMemberId())
                       .ifPresent(m-> {throw new IllegalStateException("이미 존재하는 회원입니다");});
       memberRepository.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public Member findMemberInfo(String memberId) {
        log.info("서비스 진입 : {}", memberId);
        return memberRepository.findById(memberId)
                .orElse(null);
    }

    @Override
    @Transactional
    public void updateInfo(Member member) {
        log.info("{} 서비스 진입 ", member.getMemberId());
        memberRepository.update(member);
    }

    @Override
    @Transactional
    public void withdraw(String memberId, String memberPw) {
        log.info("{} 서비스 진입 ", memberId);
        Optional<Member> entity = memberRepository.findById(memberId)
                .filter(m -> m.getMemberPw().equals(memberPw));
        entity.ifPresentOrElse(
                member -> memberRepository.deleteById(memberId),
                () -> { throw new IllegalStateException("비밀번호가 일치하지 않습니다."); }
        );
    }

    @Override
    public List<Member> findAllMembers() {
        log.info("회원목록 조회 서비스 진입 ");
        return memberRepository.findAll();
    }


}
