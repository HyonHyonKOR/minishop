package com.hyon01.minishop.web.member;

import com.hyon01.minishop.domain.member.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberConverter memberConverter;
    private final MemberService memberService;

    @GetMapping(value = "/add")
    public String goToSignInPage(Model model){
        model.addAttribute("memberAddForm",new MemberAddForm());
        return "members/addForm";
    }

    @PostMapping(value = "/add")
    public String addMember(@Validated(MemberValidationSequence.class) @ModelAttribute MemberAddForm memberAddForm, BindingResult bindingResult) {
        //DTO -> Domain (MemberConverter를 통해 역할 분리)

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "members/addForm";
        }
            //필드 에러1 (비밀번호와 비밀번호 확인이 일치하지 않는 경우)
        if (!memberAddForm.getMemberPw().equals(memberAddForm.getMemberPw2())) {
            bindingResult.rejectValue("memberPw2",null, "비밀번호가 일치하지 않습니다.");
            return "members/addForm";
        }

            log.info("{} 컨트롤러 진입 ", memberAddForm);
            Member member = memberConverter.addFormToMember(memberAddForm);

            //예외 처리 (중복 아이디 처리)
            try {
                memberService.join(member);
                return "redirect:/members/addSuccess";
            } catch (IllegalStateException e) {
                bindingResult.rejectValue("memberId",  e.getMessage());
                return "members/addForm";
            }
        }

    @GetMapping(value = "/addSuccess")
    public String goToSignInSuccessPage(){
           return "members/addFormSuccess";
        }

    @GetMapping(value = "/{memberId}/update")
    public String goToUpdatePage(@PathVariable("memberId") String memberId, Model model) {
        Member member = memberService.findMemberInfo(memberId);
        model.addAttribute("memberUpdateForm",memberConverter.MembertoUpdateForm(member));
        return "members/updateForm";
    }

    @PostMapping(value = "/{memberId}/update")
    public String updateMember(@Validated(MemberValidationSequence.class) @ModelAttribute MemberUpdateForm memberUpdateForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        //DTO -> Domain (MemberConverter를 통해 역할 분리)

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "members/updateForm";
        }
        //필드 에러1 (비밀번호와 비밀번호 확인이 일치하지 않는 경우)
        if (!memberUpdateForm.getMemberPw().equals(memberUpdateForm.getMemberPw2())) {
            bindingResult.rejectValue("memberPw2", null,"비밀번호가 일치하지 않습니다.");
            return "members/updateForm";
        }

        log.info("{} 컨트롤러 진입 ", memberUpdateForm);
        Member member = memberConverter.updateFormToMember(memberUpdateForm);

        memberService.updateInfo(member);
        redirectAttributes.addFlashAttribute("memberModSuccess", "회원 정보가 업데이트되었습니다.");
        return "redirect:/members/{memberId}/update";
    }

    @GetMapping(value = "/{memberId}/delete")
    public String goToDeletePage(@PathVariable("memberId") String memberId, Model model){
        model.addAttribute("memberDeleteForm",new MemberDeleteForm());
        return "members/deleteForm";
    }



    @PostMapping(value = "/{memberId}/delete")
    public String deleteMember(@PathVariable("memberId") String memberId, @ModelAttribute MemberDeleteForm memberDeleteForm, BindingResult bindingResult, HttpServletRequest request){

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "members/deleteForm";
        }
        //필드 에러1 (비밀번호와 비밀번호 확인이 일치하지 않는 경우)
        if (!memberDeleteForm.getMemberPw().equals(memberDeleteForm.getMemberPw2())) {
            bindingResult.rejectValue("memberPw2",null, "비밀번호가 일치하지 않습니다.");
            return "members/deleteForm";
        }


            log.info("{} 컨트롤러 진입 ", memberDeleteForm);

        //예외 처리 (회원 아이디의 비밀번호가 일치하지 않을 경우)
            try {
                memberService.withdraw(memberDeleteForm.getMemberId(), memberDeleteForm.getMemberPw2());
                HttpSession session = request.getSession(false);
                session.invalidate();
                return "redirect:/members/deleteSuccess";
            }catch (IllegalStateException e){
                bindingResult.rejectValue("memberPw",  e.getMessage());
                return "members/deleteForm";
         }
    }

    @GetMapping(value = "/deleteSuccess")
    public String goToDeleteSuccessPage(){
        return "members/deleteFormSuccess";
    }


 

    @GetMapping(value ="/admin/members")
    public String goToMemberListPage(){
        return "members/memberList";
    }


}