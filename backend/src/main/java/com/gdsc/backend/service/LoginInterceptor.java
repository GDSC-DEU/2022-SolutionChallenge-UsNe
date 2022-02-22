package com.gdsc.backend.service;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.gdsc.backend.service.UserSession.USER_SESSION_KEY;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute(USER_SESSION_KEY) == null) {
            response.sendRedirect("/api/login");
            return false;
        }

        return true;
    }
}