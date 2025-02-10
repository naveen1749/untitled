package org.example.secondfrontmodule.Controller;

import org.example.secondfrontmodule.Model.User;
import org.example.secondfrontmodule.Model.UserTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/all";
    }
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("user", restTemplate.getForObject("http://localhost:8080/all", List.class));
        return "Home";
    }

    @GetMapping("/save")
    public String save(Model model) {
        return "save";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        try{
            ResponseEntity<Integer> i=restTemplate.exchange("http://localhost:8080/delete/"+id, HttpMethod.DELETE,null, Integer.class);
            model.addAttribute("status", "success" + id);
        }catch (Exception e){
            model.addAttribute("status", "Failed "+ id );
        }
        return "redirect:/all";
    }

    @PostMapping("/save")
    public String post(@ModelAttribute UserTemp userTemp, Model model) {
       User user= restTemplate.postForObject("http://localhost:8080/save", userTemp, User.class);
       model.addAttribute("status", "user save with id " + user.getId());
        return "redirect:/all";
    }
}
