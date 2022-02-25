package com.gdsc.backend.controller;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "SignUp", description = "회원가입 관련 API")
@RestController
@RequestMapping("/api")
public class UserSignController {
    private final UserService userService;

    public UserSignController(UserService userService) {
        this.userService = userService;
    }

   /* @Operation(summary = "회원가입 폼", description = "회원가입 폼 합니다.", tags = "SignUp",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원가입 폼 이동 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
            }
    )
    @GetMapping("/signup")
    public String signUpForm(UserRequest request) {
        return "/user/signup";
    }*/

    @Operation(summary = "회원가입", description = "회원가입 합니다.", tags = "SignUp",
            responses = {
                    @ApiResponse(responseCode = "201", description = "회원가입 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
            }
    )
    @PostMapping("/signup")
    public String signUp(@RequestBody UserRequest userRequest){
        userService.joinUser(userRequest);
        return "/user/signup";
    }
}
