package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserGetFailException extends RuntimeException{
    public static final String FIND_USER_FAIL_MESSAGE = "전체 회원 조회 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(SignUpFailException.class);

    public UserGetFailException(String message) {
        super(FIND_USER_FAIL_MESSAGE + message);
        log.error(FIND_USER_FAIL_MESSAGE + message);
    }
}
