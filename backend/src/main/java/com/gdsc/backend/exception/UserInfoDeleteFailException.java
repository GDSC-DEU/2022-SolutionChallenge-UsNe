package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoDeleteFailException extends RuntimeException {
    public static final String DELETE_USER_INFO_FAIL_MESSAGE = "회원 정보 삭제 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(SignUpFailException.class);

    public UserInfoDeleteFailException(String message) {
        super(DELETE_USER_INFO_FAIL_MESSAGE + message);
        log.error(DELETE_USER_INFO_FAIL_MESSAGE + message);
    }
}
