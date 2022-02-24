package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumptionDeleteFailException extends RuntimeException{
    public static final String CONSUMPTION_DELETE_FAIL_MESSAGE = "소비 삭제 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(ConsumptionDeleteFailException.class);

    public ConsumptionDeleteFailException(String message) {
        super(CONSUMPTION_DELETE_FAIL_MESSAGE + message);
        log.error(CONSUMPTION_DELETE_FAIL_MESSAGE + message);
    }
}
