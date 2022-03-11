package com.gdsc.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpFailException extends RuntimeException {
    public static final String SIGNUP_FAIL_MESSAGE = "회원가입 실패 : ";
    private static final Logger log = LoggerFactory.getLogger(SignUpFailException.class);

    public SignUpFailException(String message) {
        super(SIGNUP_FAIL_MESSAGE + message);
        log.error(SIGNUP_FAIL_MESSAGE + message);
    }
}
