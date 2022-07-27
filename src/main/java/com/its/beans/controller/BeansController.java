package com.its.beans.controller;

import com.its.beans.dto.BeansDTO;
import com.its.beans.service.BeansService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Beans")
public class BeansController {
    private final BeansService beansService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(BeansDTO beansDTO){
         Long save = beansService.save(beansDTO);
        return "redirect:/menu";
    }
    @GetMapping("/list")
    public String findAll(Model model){
         List<BeansDTO> all =beansService.findAll();
         model.addAttribute("all",all);
         return "list";
    }
    @GetMapping("{id}")
    public String detail(@PathVariable("id")Long id){
         BeansDTO byId = beansService.findById(id);
         return "detail";
    }
    @GetMapping("{id}")
    public String delate(@PathVariable("id")Long id){
        beansService.delate(id);
    return "index";
    }
    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable("id")Long id ,Model model){
         BeansDTO byId = beansService.findById(id);
         model.addAttribute("byId",byId);
         return "update";
    }
    @PostMapping("/update")
    public String update(BeansDTO beansDTO){
        beansService.update(beansDTO);
        return "update";
    }

}
