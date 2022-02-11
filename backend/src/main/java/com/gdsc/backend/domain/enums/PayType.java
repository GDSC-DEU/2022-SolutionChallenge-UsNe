package com.gdsc.backend.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PayType {
    ACCOUNTTRANSFER("게좌이체"),
    CARD("카드"),
    GIRTCARD("상품권"),
    CASH("현금");

    private String name;

    PayType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static PayType nameOf(String name) {
        for (PayType num : PayType.values()) {
            if (num.getName().equals(name)) {
                return num;
            }
        }
        return null;
    }
}
