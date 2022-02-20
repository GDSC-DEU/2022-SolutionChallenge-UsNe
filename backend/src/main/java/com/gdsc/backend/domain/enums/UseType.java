package com.gdsc.backend.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum UseType {
    EDUCATION("교육"),
    TRAFFIC("교통"),
    BEAUTY("미용"),
    CULTURE("문화"),
    FOOD("식비"),
    LIFE("생활"),
    MEDICALTREATMENT("의료"),
    CLOTHES("의류"),
    ETC("기타");

    private String name;

    UseType(String name) {
        this.name = name.toUpperCase();
    }

    public String getName() {
        return this.name;
    }

    public boolean isEquals(String type){
        return this.getName().equals(type);
    }
}
