package com.gdsc.backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequest {
    @Schema(description = "그룹 이름", nullable = false, example = "어쓰네?")
    private String name;
}
