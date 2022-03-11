package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Message;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.domain.enums.StatusEnum;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.request.LoginRequest;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.SignUpResponse;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.repository.UserRepository;
import com.gdsc.backend.service.UserService;
import com.gdsc.backend.service.UserSession;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.charset.Charset;

@Tag(name = "SignUp", description = "회원가입 관련 API")
@RestController
@RequestMapping("/api")
public class UserSignController {
    private final UserService userService;

    public UserSignController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원가입", description = "회원가입 합니다.", tags = "SignUp",
            responses = {
                    @ApiResponse(responseCode = "201", description = "회원가입 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
            }
    )
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody UserRequest userRequest, HttpSession httpSession){
        SignUpResponse creation = userService.joinUser(userRequest);

        return new ResponseEntity<SignUpResponse>(creation, HttpStatus.CREATED);
    }

}
