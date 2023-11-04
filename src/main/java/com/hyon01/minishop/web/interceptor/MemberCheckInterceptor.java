package com.hyon01.minishop.web.interceptor;
import com.hyon01.minishop.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class MemberCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Member member =  (Member)session.getAttribute("loginMember");

        String currentId = member.getMemberId();
        String requestedMemberId = null;

        String requestURI = request.getRequestURI();
        String[] path = requestURI.split("/");

        //URI 경로에서 식별자 추출
        if(path.length > 2 && path[1].equals("members")){
            requestedMemberId = path[2];
        }

        //현재 사용자의 ID와 요청된 멤버ID가 다르면 정보 차단
        if(requestedMemberId!=null && !currentId.equals(requestedMemberId)){
        log.warn("{}로부터 {} 정보에 잘못된 접근을 요청", currentId,requestedMemberId);
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        return false;
        }

        return true;
    }
}
