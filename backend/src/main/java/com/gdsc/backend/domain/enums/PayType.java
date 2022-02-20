package com.gdsc.backend.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Locale;

public enum PayType {
    ACCOUNTTRANSFER("게좌이체"),
    CARD("카드"),
    GIRTCARD("상품권"),
    CASH("현금");

    private String name;

    PayType(String name) {
        this.name = name.toUpperCase();
    }

    public String getName() {
        return this.name;
    }

    public boolean isEquals(String type){
        return this.getName().equals(type);
    }
}
