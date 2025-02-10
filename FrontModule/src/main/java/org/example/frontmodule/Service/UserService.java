package org.example.frontmodule.Service;

import jakarta.servlet.http.HttpSession;
import org.example.frontmodule.Models.UserTemp;
import org.example.frontmodule.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("status")
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<User> users = restTemplate.getForObject("http://localhost:8080/all", List.class);
        model.addAttribute("users", users);
        return "Home";
    }

    @PostMapping("/delete/{id}")
    public String getAll(@PathVariable("id") Long id, Model model) {
        ResponseEntity<Integer> status = restTemplate.exchange("http://localhost:8080/delete/" + id, HttpMethod.DELETE, null, Integer.class);
        model.addAttribute("status", status.getStatusCode() == HttpStatusCode.valueOf(200) ? "User deleted : " +id : "Failed to delete");
        return "redirect:/all";

    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UserTemp user, Model model) {
        System.out.println(user);
        System.out.println(user.getName());

        User temp = restTemplate.postForObject("http://localhost:8080/save", user, User.class);
        model.addAttribute("status", "User saved with id " + temp.getId());
        return "redirect:/all";
    }
}
