package com.hyon01.minishop.domain.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    void update(Member member);
    void deleteById(String memberId);
    Optional<Member> findById(String memberId);
//  Optional<Member> findByName(String memberName);
//  List<Member> findAll();
}
