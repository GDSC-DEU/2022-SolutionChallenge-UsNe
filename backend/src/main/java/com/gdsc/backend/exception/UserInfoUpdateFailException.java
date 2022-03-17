package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoUpdateFailException extends RuntimeException {
    public static final String UPDATE_USER_INFO_FAIL_MESSAGE = "회원 정보 수정 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(SignUpFailException.class);

    public UserInfoUpdateFailException(String message) {
        super(UPDATE_USER_INFO_FAIL_MESSAGE + message);
        log.error(UPDATE_USER_INFO_FAIL_MESSAGE + message);
    }
}
