package com.hyon01.minishop.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository{

    private final MemberMapper memberMapper;
    @Override
    public void save(Member member) {
        log.info("{} 레퍼지토리 진입 ", member.getMemberId());
        memberMapper.save(member);
    }

    @Override
    public void update(Member member) {
        log.info("{} 레퍼지토리 진입 ", member.getMemberId());
        memberMapper.update(member);
    }

    @Override
    public void deleteById(String memberId) {
        log.info("{} 레퍼지토리 진입 ", memberId);
        memberMapper.deleteById(memberId);
    }

    @Override
    public Optional<Member> findById(String memberId) {
        log.info("{} 레퍼지토리 진입 ", memberId);
        return Optional.ofNullable(memberMapper.findById(memberId));
    }

    @Override
    public List<Member> findAll() {
        log.info("회원목록 조회 레퍼지토리 진입 ");
        return memberMapper.findAll();
    }


}
