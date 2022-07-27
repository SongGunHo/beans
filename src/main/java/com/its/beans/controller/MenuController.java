package com.its.beans.controller;

import com.its.beans.dto.MenuDTO;
import com.its.beans.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;
    @GetMapping("/save-form")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(MenuDTO menuDTO){
         menuService.save(menuDTO);
         return "redirect:/menu";
    }
    @GetMapping("/list")
    public String list(Model model){
         List<MenuDTO> all = menuService.findAll();
         model.addAttribute("all",all);
         return "detail";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable("id")Long id){
        MenuDTO byId = menuService.findById(id);
        return "detail";
    }
    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable("id")Long id ,Model model){
         MenuDTO byId = menuService.findById(id);
         model.addAttribute("byId",byId);
         return "update";
    }
    @PostMapping("/update")
    public String update(MenuDTO menuDTO){
        menuService.update(menuDTO);
        return "update";
    }
    @GetMapping("/@{id}")
    public String delate(@PathVariable("id")Long id){
        menuService.delate(id);
        return "index";
    }

}
