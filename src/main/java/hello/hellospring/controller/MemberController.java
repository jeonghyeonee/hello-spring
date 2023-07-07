package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //스프링이 관리함 -> 스프링 빈에 등록 -> 스프링 컨테이너에 등록해서 스프링이 관리할 수 있도록 함 .
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return  "members/createMemberForm";
    }
    @PostMapping
    public  String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return  "redirect:/";    //회원가입이 끝났으니 홈화면으로 보내는 것임
    }




}
