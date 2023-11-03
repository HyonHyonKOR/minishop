package com.hyon01.minishop.web.login;

import com.hyon01.minishop.domain.login.LoginService;
import com.hyon01.minishop.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/login")
    public String navigateLoginPage(@ModelAttribute("loginForm") LoginForm loginForm){
        return "login/loginForm";
    }

    @PostMapping(value = "/login")
    public String processLogin(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Member loginMember = loginService.login(loginForm.getMemberId(), loginForm.getMemberPw());

        if(loginMember == null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //세션이 있으면 있는 세션 반환, 없으면 신규 생성
        HttpSession session = request.getSession();
        session.setAttribute("loginMember",loginMember);
        session.setMaxInactiveInterval(1800);

        //로그인 성공 처리
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
