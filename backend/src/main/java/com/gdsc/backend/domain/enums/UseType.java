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

    public static UseType nameOf(String name) {
        for (UseType num : UseType.values()) {
            if (num.getName().equals(name)) {
                return num;
            }
        }
        return null;
    }
}
