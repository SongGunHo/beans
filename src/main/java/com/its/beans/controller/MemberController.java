package com.its.beans.controller;

import com.its.beans.dto.MemberDTO;
import com.its.beans.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(MemberDTO memberDTO){
         Long save = memberService.save(memberDTO);
        return "login";
    }
    @GetMapping("/login-form")
    public String loginForm(){

        return "login";
    }
    @PostMapping("/login")
    public String login(MemberDTO memberDTO,HttpSession session,Model model) {
        MemberDTO login = memberService.login(memberDTO);
        List<MemberDTO> all = memberService.findAll();
        if (login != null) {
            session.setAttribute("login", login.getId());
            session.setAttribute("ail", login);
            model.addAttribute("all",all);
            return "list";
        }else {
            return "login";
        }
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
         List<MemberDTO> all = memberService.findAll();
         model.addAttribute("all",all);
         return "list";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable("id")Long id ){
         MemberDTO byId =memberService.findById(id);
         return "detail";
    }
    @GetMapping("/{id}")
    public String delate(@PathVariable("id")Long id){
        memberService.delate(id);
        return "index";
    }
    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable("id")Long id ,Model model){
         MemberDTO byId =memberService.findById(id);
         model.addAttribute("Update",byId);
         return "update";
    }
    @PostMapping("/update")
    public String update( MemberDTO memberDTO){
        memberService.update(memberDTO);
        return "list";
    }
    @GetMapping("/mypages-form")
    public String mypagesForm(){
        return "mypages";
    }
    @PostMapping("/myPages/{id}")
    public String myPages(@PathVariable("id")Long id){
         MemberDTO byId = memberService.findById(id);
         return "index";
    }
    @GetMapping("/admin-form")
    public String adminForm(){
        return "admin";
    }
    @PostMapping("/admin")
    public String admin(MemberDTO memberDTO){
         List<MemberDTO> all =memberService.findAll();
         return "admin";
    }
    @GetMapping("/logout")
    public String logout(MemberDTO memberDTO,HttpSession session){
        MemberDTO login = memberService.login(memberDTO);
        session.setAttribute("ail", login);
        return "index";
    }
    @GetMapping("/emailCheck")
    public @ResponseBody String emailCheck(@RequestParam String memberEmail){
         String checkResult = memberService.email(memberEmail);
         return checkResult;
    }
}
