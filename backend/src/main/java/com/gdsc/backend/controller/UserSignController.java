package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.Message;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.StatusEnum;
import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.request.LoginRequest;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.dto.response.SignUpResponse;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.repository.UserRepository;
import com.gdsc.backend.service.UserService;
import com.gdsc.backend.service.UserSession;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.charset.Charset;
import java.util.List;

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


//
//    @Operation(summary = "전체 회원 조회", description = "전체 회원을 조회합니다.", tags = "SignUp",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "전체 회원 조회 성공",
//                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class)))
//            }
//    )
//    @GetMapping
//    public ResponseEntity<List<User>> showUserList(final Pageable pageable, HttpSession httpSession){
//        List<User> users= UserService.showConsumptionsByPage(pageable, httpSession.getAttribute("user_id").toString());
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }

    @Operation(summary = "회원 조회", description = "회원 한명을 조회합니다.", tags = "SignUp",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class)))
            }
    )

//    @PostMapping("/signup")
//    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody UserRequest userRequest, HttpSession httpSession){
//        SignUpResponse creation = userService.joinUser(userRequest);
//
//        return new ResponseEntity<SignUpResponse>(creation, HttpStatus.CREATED);
//    }
    @PostMapping("/user/list")
    public ResponseEntity<UserResponse> showUserInfo(@RequestBody UserRequest userRequest, HttpSession httpSession) {
        UserResponse userResponse = SignUpResponse.from(user);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }
//
//    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정합니다.", tags = "SignUp",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "회원 정보 수정 성공",
//                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
//            }
//    )
//    @PutMapping("/{index}")
//    public ResponseEntity<?> updateConsumption(@Parameter(name = "index", in = ParameterIn.PATH, description = "수정할 소비의 인덱스")
//                                               @PathVariable("index")Long index, @RequestBody ConsumptionRequest consumptionRequest,
//                                               HttpSession httpSession){
//        Consumption updation= consumptionManagementService.update(index, consumptionRequest, httpSession.getAttribute("user_id").toString());
//        return new ResponseEntity<>(updation, HttpStatus.OK);
//    }
//
//    @Operation(summary = "회원 기록 삭제", description = "회원을 기록 삭제합니다.", tags = "SignUp",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "회원 기록 삭제 성공",
//                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
//            }
//    )
//    @DeleteMapping("/{index}")
//    public ResponseEntity deleteConsumption(@Parameter(name = "index", in = ParameterIn.PATH, description = "삭제할 소비의 인덱스")
//                                            @PathVariable("index")Long index,HttpSession httpSession){
//        consumptionManagementService.delete(index, httpSession.getAttribute("user_id").toString());
//        return new ResponseEntity<>("{}", HttpStatus.NO_CONTENT);
//    }
//
//
//    @GetMapping("/search")
//    public ResponseEntity<List<ConsumptionResponse>> searchConsumptionByTag(@RequestParam(value="useType", required = false) UseType useType,
//                                                                            @RequestParam(value = "dwType", required = false) DwType dwType,
//                                                                            @RequestParam(value="payType", required = false) PayType payType,
//                                                                            HttpSession httpSession){
//        List<ConsumptionResponse> consumptions = consumptionManagementService.search(useType,dwType,payType,httpSession.getAttribute("user_id").toString());
//        return new ResponseEntity<List<ConsumptionResponse>>(consumptions,HttpStatus.OK);
//    }

}
