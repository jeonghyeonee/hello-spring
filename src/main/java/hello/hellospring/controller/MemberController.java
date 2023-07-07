package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return  "redirect:/";    //회원가입이 끝났으니 홈화면으로 보내는 것임
    }
    @GetMapping("/members")
    public String list(Model model){
         List<Member> members  = memberService.findMembers();
         model.addAttribute("members", members);
         return  "members/memberList";
         //list() 메소드에서는 MemberService의 findMembers() 메소드를 호출하여 회원 목록을 가져온 다음, model.addAttribute("members", members)를
        // 사용하여 members라는 이름으로 Model 객체에 회원 목록을 추가합니다. 이렇게 하면, 뷰에서 members라는 이름으로 Model 객체에 추가된 회원 목록에 접근할 수 있게 됩니다.

    }






}
