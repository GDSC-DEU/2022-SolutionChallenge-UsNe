package com.gdsc.backend.controller;

import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserSignController {
    private final UserService userService;

    @GetMapping("/api/signup")
    public String signUp(UserRequest request) {
        return "/user/signup";
    }

    @PostMapping("/api/signup")
    public String signUpPost(@Valid @ModelAttribute UserRequest userRequest, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> list =  bindingResult.getAllErrors();
            for(ObjectError e : list) {
                System.out.println(e.getDefaultMessage());
            }
            return "error";
        } else {
            if (userService.joinCheck(userRequest)) {
                userService.join(userRequest);
            }
        }
        return "redirect:login";
    }
}
