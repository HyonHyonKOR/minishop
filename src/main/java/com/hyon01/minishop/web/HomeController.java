package com.hyon01.minishop.web;

import com.hyon01.minishop.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homeLogin(@SessionAttribute(name="loginMember", required = false) Member loginMember, Model model){

        //세션에 회원 데이터가 없으면 일반 홈으로 이동
        if(loginMember == null){
            return "home";
        }

        ///회원 세션이 회원 전용 홈으로 이동
        model.addAttribute("member",loginMember);
        return "login-home";

    }
}
