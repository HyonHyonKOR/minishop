package com.hyon01.minishop.domain.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void save(Member member);
    Member findById(String memberId);
    void update(Member member);
    void deleteById(String memberId);
    List<Member> findAll();
}
