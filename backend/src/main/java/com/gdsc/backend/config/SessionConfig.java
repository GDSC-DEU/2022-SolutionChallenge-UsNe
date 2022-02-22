package com.gdsc.backend.config;

import com.gdsc.backend.service.LoginService;
import com.gdsc.backend.service.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static com.gdsc.backend.service.UserSession.USER_SESSION_KEY;

@WebListener
public class SessionConfig implements HttpSessionListener {
    private static final Logger log = LoggerFactory.getLogger(SessionConfig.class);

    private final LoginService loginService;

    public SessionConfig(final LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        log.info("Session Created, session ID : {}, time-out : {}",
                httpSession.getId(), httpSession.getMaxInactiveInterval());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        log.info("Session Destroyed, session ID : {}, user : {}",
                httpSession.getId(), httpSession.getAttribute(USER_SESSION_KEY));
        logout(httpSession);
    }

    private void logout(HttpSession httpSession) {
        UserSession userSession = (UserSession) httpSession.getAttribute(USER_SESSION_KEY);
        if (userSession != null) {
            loginService.logout(userSession.getUserId());
        }
    }
}
