package com.gdsc.backend.domain.enums;

public enum DwType {
    DEPOSIT("입금"),
    WITHDRAW("출금");

    private String name;

    DwType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEquals(String type){
        return this.getName().equals(type);
    }
}
