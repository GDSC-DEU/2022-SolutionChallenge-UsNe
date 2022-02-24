package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumptionUpdateFailException extends RuntimeException{
    public static final String CONSUMPTION_UPDATE_FAIL_MESSAGE = "소비 갱신 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(ConsumptionUpdateFailException.class);

    public ConsumptionUpdateFailException(String message) {
        super(CONSUMPTION_UPDATE_FAIL_MESSAGE + message);
        log.error(CONSUMPTION_UPDATE_FAIL_MESSAGE + message);
    }
}
