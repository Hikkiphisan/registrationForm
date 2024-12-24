package org.example.validateformdangky.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.example.validateformdangky.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class FormController {
  @GetMapping("/form")
  public String showForm(Model model) {
    model.addAttribute("user", new User());
    return "/index";

//      String lastname;
//      String firstname;
//      String phonenumber;
//      String age;
  }

  @PostMapping("/register")
  public String checkValidation (@Valid @ModelAttribute("user") User user,
                                 BindingResult bindingResult, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/index";
            //Nếu thất bại thì trả ra thông báo lỗi
        }
        else {
            model.addAttribute("user", new User());
            return "/result";
        }
  };



}
