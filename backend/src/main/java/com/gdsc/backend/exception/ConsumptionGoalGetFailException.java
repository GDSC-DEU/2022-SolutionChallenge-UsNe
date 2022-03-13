package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumptionGoalGetFailException extends RuntimeException{
    public static final String CONSUMPTIONGOAL_GET_FAIL_MESSAGE = "목표 소비 조회 실패 : ";
        private static final Logger log = LoggerFactory.getLogger(ConsumptionGoalGetFailException.class);

    public ConsumptionGoalGetFailException(String message) {
            super(CONSUMPTIONGOAL_GET_FAIL_MESSAGE + message);
            log.error(CONSUMPTIONGOAL_GET_FAIL_MESSAGE + message);
    }
}
