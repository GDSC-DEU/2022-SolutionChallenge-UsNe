package com.gdsc.backend.controller;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.SignUpResponse;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Tag(name = "user", description = "회원 관리 관련 API")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원 가입", description = "회원 가입합니다.", tags = "User",
            responses = {
                    @ApiResponse(responseCode = "201", description = "회원 가입 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
            }
    )
    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody UserRequest userRequest, HttpSession httpSession){
        SignUpResponse creation = userService.joinUser(userRequest);

        return new ResponseEntity<SignUpResponse>(creation, HttpStatus.CREATED);
    }

    @Operation(summary = "전체 회원 조회", description = "회원 리스트를 조회합니다.", tags = "User",
            responses = {
                    @ApiResponse(responseCode = "200", description = "전체 회원 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class)))
            }
    )
    @GetMapping("/list")
    public ResponseEntity<List<User>> showUserList(HttpSession httpSession){
        List<User> users= userService.showUserList();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @Operation(summary = "회원 정보 조회", description = "회원 정보를 조회합니다.", tags = "User",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 정보 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class)))
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> showUserInfo(@Parameter(name = "id", in = ParameterIn.PATH, description = "조회할 회원 아이디")
                                                         @PathVariable("id")String id, HttpSession httpSession) {
        UserResponse userResponse = userService.findUserResponseById(httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정합니다.", tags = "User",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 정보 수정 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class)))
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserInfo(@Parameter(name = "id", in = ParameterIn.PATH, description = "수정할 회원 아이디")
                                                   @PathVariable("id")String id, @RequestBody UserRequest userRequest, HttpSession httpSession) {
        UserResponse updation= userService.update(userRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<UserResponse>(updation, HttpStatus.OK);
    }
    ////////////////////

    //////
    @Operation(summary = "회원 정보 삭제", description = "회원 정보를 삭제합니다.", tags = "User",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 정보 삭제 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserInfo(@Parameter(name = "id", in = ParameterIn.PATH, description = "삭제할 회원의 아이디")
                                            @PathVariable("id")String id,HttpSession httpSession){
        userService.delete(httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<>("{}", HttpStatus.NO_CONTENT);
    }


}
