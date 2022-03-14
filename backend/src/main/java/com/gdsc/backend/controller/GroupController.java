package com.gdsc.backend.controller;

import com.gdsc.backend.domain.GroupList;
import com.gdsc.backend.dto.request.GroupRequest;
import com.gdsc.backend.service.GroupListService;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "group", description = "그룹 관련 API")
@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupListService groupListService;
    public GroupController(final GroupListService groupListService){
        this.groupListService = groupListService;
    }

    @Operation(summary = "그룹 생성", description = "그룹을 생성합니다.", tags = "group",
            responses = {
                    @ApiResponse(responseCode = "201", description = "그룹 생성 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroupList.class)))
            }
    )
    @PostMapping
    public ResponseEntity<GroupList> createGroup(@Valid @RequestBody GroupRequest groupRequest, HttpSession httpSession){
        GroupList creation = groupListService.saveGroup(groupRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<GroupList>(creation, HttpStatus.CREATED);
    }

    @Operation(summary = "그룹 조회", description = "모든 그룹을 조회합니다.", tags = "group",
            responses = {
                    @ApiResponse(responseCode = "200", description = "그룹 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroupList.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<GroupList>> showGroup(){
        List<GroupList> groupLists = groupListService.findAllGroup();
        return new ResponseEntity<List<GroupList>>(groupLists, HttpStatus.OK);
    }

    @Operation(summary = "그룹 수정", description = "그룹을 수정합니다.", tags = "group",
            responses = {
                    @ApiResponse(responseCode = "200", description = "그룹 수정 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GroupList.class)))
            }
    )
    @PutMapping("/{index}")
    public ResponseEntity<GroupList> updateGroup(@PathVariable Long index, @Valid @RequestBody GroupRequest groupRequest,HttpSession httpSession){
        GroupList groupList = groupListService.updateGroup(groupRequest, index, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<GroupList>(groupList, HttpStatus.OK);
    }

    @Operation(summary = "그룹 삭제", description = "그룹을 삭제합니다.", tags = "group",
            responses = {
                    @ApiResponse(responseCode = "200", description = "그룹 삭제 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @DeleteMapping("/{index}")
    public ResponseEntity deleteGroup(@PathVariable Long index, HttpSession httpSession){
        groupListService.deleteGroup(index, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
