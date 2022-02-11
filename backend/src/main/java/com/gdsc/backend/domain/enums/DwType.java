package com.gdsc.backend.domain.enums;

import ch.qos.logback.core.pattern.parser.FormattingNode;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DwType {
    EUCATION("교육"),
    TRAFFIC("교통"),
    BEAUTY("미용"),
    CULTURE("문화"),
    FOOD("식비"),
    LIFE("생활"),
    MEDICALTREATMENT("의료"),
    CLOTHES("의류"),
    ETC("기타");

    private String name;

    DwType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static DwType nameOf(String name) {
        for (DwType num : DwType.values()) {
            if (num.getName().equals(name)) {
                return num;
            }
        }
        return null;
    }
}
