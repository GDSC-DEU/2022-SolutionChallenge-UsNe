package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumptionGoalCreateFailException extends RuntimeException {
    public static final String CONSUMPTIONGOAL_CREATE_FAIL_MESSAGE = "목표 소비 등록 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(ConsumptionGoalCreateFailException.class);

    public ConsumptionGoalCreateFailException(String message) {
        super(CONSUMPTIONGOAL_CREATE_FAIL_MESSAGE + message);
        log.error(CONSUMPTIONGOAL_CREATE_FAIL_MESSAGE + message);
    }
}
