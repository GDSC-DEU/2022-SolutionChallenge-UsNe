package com.gdsc.backend.controller;

import com.gdsc.backend.annotation.LoginUser;
import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.dto.request.LoginRequest;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.service.LoginService;
import com.gdsc.backend.service.UserService;
import com.gdsc.backend.service.UserSession;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.gdsc.backend.service.UserSession.USER_SESSION_KEY;


@Tag(name = "login", description = "로그인과 로그아웃 관련 API")
@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;

    public LoginController(final LoginService loginService,final UserService userService){
        this.loginService=loginService;
        this.userService=userService;
    }
    @Operation(summary = "로그인", description = "로그인 합니다.", tags = "login",
            responses = {
                    @ApiResponse(responseCode = "200", description = "로그인 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
            }
    )
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest, HttpSession httpSession){
        UserSession userSession = loginService.login(loginRequest);
        httpSession.setAttribute(USER_SESSION_KEY, userSession);
        return new ResponseEntity<UserResponse>(userService.findUserResponseById(userSession.getUsreId()), HttpStatus.OK);
    }

    @Operation(summary = "로그아웃", description = "로그아웃 합니다.", tags = "login",
            responses = {
                    @ApiResponse(responseCode = "200", description = "로그아웃 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PostMapping("/logout")
    public ResponseEntity logout(@LoginUser UserSession userSession, HttpSession httpSession) {
        loginService.logout(userSession.getUsreId());
        httpSession.removeAttribute(USER_SESSION_KEY);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }
}
