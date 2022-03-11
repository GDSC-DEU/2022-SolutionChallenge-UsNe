package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumptionGetFailException extends RuntimeException {
    public static final String CONSUMPTION_GET_FAIL_MESSAGE = "소비 조회 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(ConsumptionGetFailException.class);

    public ConsumptionGetFailException(String message) {
        super(CONSUMPTION_GET_FAIL_MESSAGE + message);
        log.error(CONSUMPTION_GET_FAIL_MESSAGE + message);
    }
}
