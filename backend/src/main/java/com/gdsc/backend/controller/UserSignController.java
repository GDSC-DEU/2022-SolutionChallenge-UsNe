package com.gdsc.backend.controller;

import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
            return "/user/signup";
        } else {
            if (userService.joinCheck(userRequest)) {
                userService.join(userRequest);
            }
        }
        return "redirect:login";
    }

    @PostMapping("/api/idCheck")
    @ResponseBody
    public int idCheck(@ModelAttribute UserRequest userRequest) {
        int count = userService.userIdCheck(userRequest.getUserId());
        return count;
    }
}
