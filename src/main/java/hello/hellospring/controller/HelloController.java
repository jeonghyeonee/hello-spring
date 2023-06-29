package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!"); //data가 hello.html에서 치환됨

        return "hello";

        //return hello에서 templates 밑에 있는 hello.html을 찾아서 들어감. 뷰 리졸버가 화면을 찾아서 처리함.
        //기본 세팅 : resources:templates/+(viewname)+.html이 열리게 됨.
    }

    //@RequestParam("name")은 요청 파라미터 중에서 "name"이라는 이름의 값을 가져와서 name 파라미터에 할당하는 것을 의미합니다. 즉, 요청 URL에서 name 파라미터의 값을 가져와서 해당 메서드의 name 파라미터에 전달합니다.
    //
    //Model 객체는 데이터를 뷰로 전달하는 데 사용됩니다. model.addAttribute("name", name)은 "name"이라는 이름으로 name 변수의 값을 모델에 추가합니다. 이렇게 모델에 데이터를 추가하면 뷰에서 해당 데이터를 사용할 수 있게 됩니다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")  String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
