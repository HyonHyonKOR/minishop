package com.hyon01.minishop.domain.login;
import com.hyon01.minishop.domain.member.Member;
import com.hyon01.minishop.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final MemberRepository memberRepository;

    /**
     * @return null 로그인 실패
     */

    @Override
    @Transactional(readOnly = true)
    public Member login(String memberId,String memberPw) {
       return memberRepository.findById(memberId)
        .filter(m -> m.getMemberPw().equals(memberPw))
        .orElse(null);
    }

}
