package com.its.beans.controller;

import com.its.beans.dto.SuppliesDTO;
import com.its.beans.service.SuppliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/supplies")
public class SuppliesController {
    private final SuppliesService suppliesService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(SuppliesDTO suppliesDTO){
        suppliesService.save(suppliesDTO);
        return "redirect:/supplies";
    }
    @GetMapping("/list")
    public String list(Model model){
         List<SuppliesDTO> all =suppliesService.findAll();
        System.out.println("model = " + model);
         model.addAttribute("list",all);
         return "list";
    }
    @GetMapping("/{id]")
    public String detail(@PathVariable("id")Long id){
         SuppliesDTO suppliesDTO =suppliesService.finById(id);
         return "detail";
    }
    
}
