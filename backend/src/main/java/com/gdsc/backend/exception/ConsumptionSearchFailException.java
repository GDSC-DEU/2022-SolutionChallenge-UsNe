package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumptionSearchFailException extends RuntimeException{
    public static final String CONSUMPTION_SEARCH_FAIL_MESSAGE = "소비 검색 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(ConsumptionSearchFailException.class);

    public ConsumptionSearchFailException(String message) {
        super(CONSUMPTION_SEARCH_FAIL_MESSAGE + message);
        log.error(CONSUMPTION_SEARCH_FAIL_MESSAGE + message);
    }
}
