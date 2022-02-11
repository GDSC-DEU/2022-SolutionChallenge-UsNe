package com.gdsc.backend.domain.enums;

public enum UseType {
    DEPOSIT("입금"),
    WITHDRAW("출금");

    private String name;

    UseType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEquals(String type){
        return this.getName().equals(type);
    }
}
